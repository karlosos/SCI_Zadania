#ifndef SAVING_H
#define SAVING_H

void scope_save_xml(string word, string scope);
void scope_save_html(string word, string scope);
void scope_save_corrupt_xml(string word, string scope);

///
/// Zapisuje scope do plików
///
/// @string word
///
void scope_save(string word) {
	if(scope_words.size() > 0) {
		for (unsigned int i = 0; i < scope_words.size(); i++) {
			scope_save_xml(word, scope_words.at(i));
			scope_save_html(word, scope_words.at(i));
		}
	}

	if(scope_words_corrupt.size() > 0) {
		for (unsigned int i = 0; i< scope_words_corrupt.size(); i++) {
			scope_save_corrupt_xml(word, scope_words_corrupt.at(i));
		}
	}

	scope_words_corrupt.clear();
	scope_words.clear();
	scope_words_tmp.clear();
	scope_type = "";
}

///
/// Czyœci scope'y z spacji na pocz¹tku
///
void scope_clean() {
	for (unsigned int i = 0; i < scope_words_tmp.size(); i++) {
		if(scope_words_tmp.at(i).at(0) == 0x20) 
			scope_words_tmp.at(i).erase(0,1);
	}
}

///
/// Sortuje i usuwa powtórzenia
///
void scope_sort() {
	for (unsigned int i = 0; i < scope_words_tmp.size(); i++) {
		int spaces = std::count_if(scope_words_tmp.at(i).begin(), scope_words_tmp.at(i).end(), [](unsigned char c){ return isspace(c); });
		if (spaces <2) {
			scope_words.push_back(scope_words_tmp.at(i));
		}
	}

	  sort(scope_words.begin(), scope_words.end());
      scope_words.erase(unique(scope_words.begin(), scope_words.end() ), scope_words.end() );
}

///
/// Dodaje scope do kontenera
///
/// @string* scope
///
void scope_add(string scope, string* type) {
	scope_words.clear();
	scope_words_tmp.clear();
	scope_type = *type;
    std::size_t prev_pos = 0, pos;

	size_t comma = scope.find(",");
	size_t semicolon = scope.find(";");

	if (comma!=std::string::npos && semicolon!=std::string::npos) {
		while ((pos = scope.find_first_of(",;", prev_pos)) != std::string::npos)
		{
			if (pos > prev_pos)
				scope_words_corrupt.push_back(scope.substr(prev_pos, pos-prev_pos));
			prev_pos= pos+1;
		}
		if (prev_pos < scope.length())
			scope_words_corrupt.push_back(scope.substr(prev_pos, std::string::npos));
	}
}

///
///Zapisuje logi
///
///@param string message - wiadomosc
///@param string date - data
///
void save_log(string message, string date) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out;
		out.open(log_name, std::ios::app);
		out << message + " at " + date + " \n";
		out.close();
}

///
/// Zapisuje dane do xml
///
/// @string word - nazwa slowa
/// @string* type - wskaznik na typ
/// @string* scope - wskaznik na scope
/// @vector<string>* common_syn - wskaznik na kontener common synonimow
/// @vector<string>* syn - wskaznik na kontener pozostalych synonimow
///
void save_to_xml(string word, string scope, string* type, vector<string>* common_syn, vector<string>* syn, string file_name) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie2.xml", std::ios::app);

		long double syn_weight = syn->size();
		long double common_syn_weight = common_syn->size();

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		string xml_type = "\t\t\t<type>" + *type + "</type> \n";

		string xml_scope = "\t\t\t<scope>" + scope + "</scope> \n";
		string xml_synonyms_start = "\t\t\t<synonyms>";
		string xml_synonyms_end = "</synonyms> \n";
		string xml_synonym = "";

		// Zapisywanie kodu xml
		if (common_syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>80</weight> \n";
			out_xml << xml_type;
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<common_syn_weight; i++) {
				if (i>0 && i<common_syn_weight) 
					out_xml << ", ";
				xml_synonym = common_syn->at(i);
				out_xml << xml_synonym;
				xml_synonym = "";
			}
			out_xml << xml_synonyms_end;
			out_xml << xml_word_end;
		}

		if (syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>40</weight> \n";
			out_xml << xml_type;
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				if (i>0 && i<syn_weight) 
					out_xml << ", ";
				xml_synonym = syn->at(i);
				out_xml << xml_synonym;
				xml_synonym = "";
			}
			out_xml << xml_synonyms_end;
			out_xml << xml_word_end;
		}

		out_xml.close();
}

///
/// Zapisuje dane do xml
///
/// @string word - nazwa slowa
/// @vector<string>* syn - wskaznik na kontener pozostalych synonimow
///
void save_to_xml(string word, vector<string>* syn, int weight) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie1.xml", std::ios::app);

		long double syn_weight = syn->size();
		long double w_weight = weight;

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		string xml_scope = "\t\t\t<scope>" + word + "</scope> \n";
		string xml_synonyms_start = "\t\t\t<synonyms>";
		string xml_synonyms_end = "</synonyms> \n";
		string xml_synonym = "";

		if (syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>" + to_string(w_weight) + "</weight> \n";
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				if (i>0 && i<syn_weight) 
					out_xml << ", ";
				xml_synonym = syn->at(i);
				out_xml << xml_synonym;
				xml_synonym = "";
			}
			out_xml << xml_synonyms_end;
			out_xml << xml_word_end;
		}

		out_xml.close();
}

///
/// Zapisuje dane do xml
///
/// @string word - nazwa slowa
/// @string* type - wskaznik na typ
/// @string* scope - wskaznik na scope
/// @vector<string>* common_syn - wskaznik na kontener common synonimow
/// @vector<string>* syn - wskaznik na kontener pozostalych synonimow
///
void save_to_html(string word, string scope, string* type,vector<string>* common_syn, vector<string>* syn, string file_name, int deep){
	
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_html;
		out_html.open("zadanie2.html", std::ios::app);

		long double syn_weight = syn->size();
		long double common_syn_weight = common_syn->size();

		// Lancuchy xml
		string html_word_start = "\t <tr id=\"word\"> \n";
		if (deep == 1)
			html_word_start = "\t <tr id=\"word\" class=\"deep\"> \n";
		string html_word_end = "\t </tr> \n";
		string html_keyword = "\t\t<td id=\"keyword\">" + word + "</td> \n";

		string html_type = "\t \t <td id=\"type\">" + *type + "</td> \n";

		string html_scope = "\t \t <td id=\"scope\">" + scope + "</td> \n";
		string html_synonyms_start = "\t \t <td id=\"syn\">";
		string html_synonyms_end = "</td> \n";
		string html_synonym = "";

		// Zapisywanie kodu xml
		if (common_syn_weight > 0) {
			out_html << html_word_start;
			out_html << html_keyword;
			out_html << "\t \t <td id=\"weight\">80</td> \n";
			out_html << html_type;
			out_html << html_scope;
			out_html << html_synonyms_start;
			for (int i=0; i<common_syn_weight; i++) {
				if (i>0) 
					out_html << ", ";
				html_synonym = common_syn->at(i);
				out_html << html_synonym;
				html_synonym = "";
			}
			out_html << html_synonyms_end;
			out_html << html_word_end;
		}

		if (syn_weight > 0) {
			out_html << html_word_start;
			out_html << html_keyword;
			out_html << "\t \t <td id=\"weight\">40</td> \n";
			out_html << html_type;
			out_html << html_scope;
			out_html << html_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				if (i>0) 
					out_html << ", ";
				html_synonym = syn->at(i);
				out_html << html_synonym;
				html_synonym = "";
			}
			out_html << html_synonyms_end;
			out_html << html_word_end;
		}
		out_html.close();

		if (previous_scope != scope) {
			previous_scope = scope;
			scope_add(scope, type);
			scope_clean();
			scope_sort();
			scope_save(word);
			scope_words.clear();
			scope_words_tmp.clear();
			scope_type = "";
		}
	}

///
/// Zapisuje dane do xml
///
/// @string word - nazwa slowa
/// @vector<string>* syn - wskaznik na kontener pozostalych synonimow
///
void save_to_html(string word, vector<string>* syn, int weight){
	// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_html;
		out_html.open("zadanie1.html", std::ios::app);

		long double syn_weight = syn->size();
		long double w_weight = weight;
		// Lancuchy xml
		string html_word_start = "\t <tr id=\"word\"> \n";
		string html_word_end = "\t </tr> \n";
		string html_keyword = "\t\t<td id=\"keyword\">" + word + "</td> \n";

		string html_scope = "\t \t <td id=\"scope\">" + word + "</td> \n";
		string html_synonyms_start = "\t \t <td id=\"syn\">";
		string html_synonyms_end = "</td> \n";
		string html_synonym = "";

		if (syn_weight > 0) {
			out_html << html_word_start;
			out_html << html_keyword;
			out_html << "\t \t <td id=\"weight\">" + to_string(w_weight) + "</td> \n";
			out_html << html_scope;
			out_html << html_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				if (i>0) 
					out_html << ", ";
				html_synonym = syn->at(i);
				out_html << html_synonym;
				html_synonym = "";
			}
			out_html << html_synonyms_end;
			out_html << html_word_end;
		}

		out_html.close();
}

///
/// Zapisuje scope do html
///
/// @param string word - s³owo które wpisujemy
/// @param string scope
///
void scope_save_html(string word, string scope) {
	// Output plik index.html, otwieramy w formie dopisywania
	std::ofstream out_html;
	out_html.open("zadanie2.html", std::ios::app);

	// Lancuchy xml
	string html_word_start = "\t <tr id=\"word\" class=\"scope\"> \n";
	string html_word_end = "\t </tr> \n";
	string html_keyword = "\t\t<td id=\"keyword\">" + word + "</td> \n";

	string html_type = "\t \t <td id=\"type\">"+ scope_type +"</td> \n";

	string html_scope = "\t \t <td id=\"scope\">" + scope + "</td> \n";
	string html_synonyms = "\t \t <td id=\"syn\">" + scope + "</td> \n";

	// Zapisywanie kodu xml
	out_html << html_word_start;
	out_html << html_keyword;
	out_html << "\t \t <td id=\"weight\">100</td> \n";
	out_html << html_type;
	out_html << html_scope;
	out_html << html_synonyms;
	out_html << html_word_end;

	out_html.close();
}

///
/// Zapisuje scope do xml
///
/// @param string word - s³owo które wpisujemy
/// @param string scope
///
void scope_save_xml(string word, string scope) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie2.xml", std::ios::app);

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		string xml_type = "\t\t\t<type>"+ scope_type +"</type> \n";

		string xml_scope = "\t\t\t<scope>" + scope + "</scope> \n";
		string xml_synonyms = "\t\t\t<synonyms>" + scope + "</synonyms> \n";

		// Zapisywanie kodu xml
		out_xml << xml_word_start;
		out_xml << xml_keyword;
		out_xml << "\t\t\t<weight>100</weight> \n";
		out_xml << xml_type;
		out_xml << xml_scope;
		out_xml << xml_synonyms;
		out_xml << xml_word_end;

		out_xml.close();
}

void scope_save_corrupt_xml(string word, string scope) {
		cout << "Dodano wiersz corrupt. Word: " + word + " scope: " + scope + currentDateTime() << endl;
		save_log("Dodano wiersz corrupt. Word: " + word + " scope: " + scope, currentDateTime());

		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie2_corrupt.xml", std::ios::app);

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		string xml_type = "\t\t\t<type>"+ scope_type +"</type> \n";

		string xml_scope = "\t\t\t<scope>" + scope + "</scope> \n";
		string xml_synonyms = "\t\t\t<synonyms>" + scope + "</synonyms> \n";

		// Zapisywanie kodu xml
		out_xml << xml_word_start;
		out_xml << xml_keyword;
		out_xml << "\t\t\t<weight>100</weight> \n";
		out_xml << xml_type;
		out_xml << xml_scope;
		out_xml << xml_synonyms;
		out_xml << xml_word_end;

		out_xml.close();
}

bool fileNotExists(string word, string folder) {
		// Input file
		string i_path = folder + "\\" + word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open()) { 
			return false;
		} else {
			cout << "There's no file. We will download: " << word << endl;
			save_log("There's no file. We will download: " + word, currentDateTime());
			return true;
		}
}

bool fileNotExists(string word) {
		// Input file
		string i_path = word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open()) { 
			return false;
		} else {
			cout << "There's no file. We will download: " << word << endl;
			save_log("There's no file. We will download: " + word, currentDateTime());
			return true;
		}
}
#endif //SAVING_H