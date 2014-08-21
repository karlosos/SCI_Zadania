#ifndef SAVING_H
#define SAVING_H

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
void save_to_xml(string word, string* type, string* scope, vector<string>* common_syn, vector<string>* syn, string file_name) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie2.xml", std::ios::app);

		long double syn_weight = syn->size();
		long double common_syn_weight = common_syn->size();

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		//string xml_syn_weight = to_string(syn_weight);
		//string xml_common_syn_weight = to_string(common_syn_weight);

		//string xml_weight = "\t\t\t<weight> \n" + + "</weight> \n";
		string xml_type = "\t\t\t<type>" + *type + "</type> \n";

		string xml_scope = "\t\t\t<scope>" + *scope + "</scope> \n";
		string xml_synonyms_start = "\t\t\t<synonyms> \n";
		string xml_synonyms_end = "\t\t\t</synonyms> \n";
		string xml_synonym = "";

		// Zapisywanie kodu xml
		if (common_syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>" + to_string(common_syn_weight) + "</weight> \n";
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<common_syn_weight; i++) {
				xml_synonym = "\t\t\t\t<synonym>" +  common_syn->at(i) + "</synonym> \n";
				out_xml << xml_synonym;
				xml_synonym = "";
			}
			out_xml << xml_synonyms_end;
			out_xml << xml_word_end;
		}

		if (syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>" + to_string(syn_weight) + "</weight> \n";
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				xml_synonym = "\t\t\t\t<synonym>" +  syn->at(i) + "</synonym> \n";
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
void save_to_xml(string word, vector<string>* syn) {
		// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_xml;
		out_xml.open("zadanie1.xml", std::ios::app);

		long double syn_weight = syn->size();

		// Lancuchy xml
		string xml_word_start = "\t\t<word> \n";
		string xml_word_end = "\t\t</word> \n";
		string xml_keyword = "\t\t\t<keyword>" + word + "</keyword> \n";

		//string xml_syn_weight = to_string(syn_weight);
		//string xml_common_syn_weight = to_string(common_syn_weight);

		//string xml_weight = "\t\t\t<weight> \n" + + "</weight> \n";

		string xml_scope = "\t\t\t<scope>" + word + "</scope> \n";
		string xml_synonyms_start = "\t\t\t<synonyms> \n";
		string xml_synonyms_end = "\t\t\t</synonyms> \n";
		string xml_synonym = "";

		if (syn_weight > 0) {
			out_xml << xml_word_start;
			out_xml << xml_keyword;
			out_xml << "\t\t\t<weight>" + to_string(syn_weight) + "</weight> \n";
			out_xml << xml_scope;
			out_xml << xml_synonyms_start;
			for (int i=0; i<syn_weight; i++) {
				xml_synonym = "\t\t\t\t<synonym>" +  syn->at(i) + "</synonym> \n";
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
void save_to_html(string word, string* type, string* scope, vector<string>* common_syn, vector<string>* syn, string file_name){
	// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_html;
		out_html.open("zadanie2.html", std::ios::app);

		long double syn_weight = syn->size();
		long double common_syn_weight = common_syn->size();

		// Lancuchy xml
		string html_word_start = "\t <tr id=\"word\"> \n";
		string html_word_end = "\t </tr> \n";
		string html_keyword = "\t\t<td id=\"keyword\">" + word + "</keyword> \n";


		//string xml_weight = "\t\t\t<weight> \n" + + "</weight> \n";
		string html_type = "\t \t <td id=\"type\">" + *type + "</td> \n";

		string html_scope = "\t \t <td id=\"scope\">" + *scope + "</td> \n";
		string html_synonyms_start = "\t \t <td id=\"syn\">";
		string html_synonyms_end = "</td> \n";
		string html_synonym = "";

		// Zapisywanie kodu xml
		if (common_syn_weight > 0) {
			out_html << html_word_start;
			out_html << html_keyword;
			out_html << "\t \t <td id=\"weight\">" + to_string(common_syn_weight) + "</td> \n";
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
			out_html << "\t \t <td id=\"weight\">" + to_string(syn_weight) + "</td> \n";
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
}

///
/// Zapisuje dane do xml
///
/// @string word - nazwa slowa
/// @vector<string>* syn - wskaznik na kontener pozostalych synonimow
///
void save_to_html(string word, vector<string>* syn){
	// Output plik index.html, otwieramy w formie dopisywania
		std::ofstream out_html;
		out_html.open("zadanie1.html", std::ios::app);

		long double syn_weight = syn->size();

		// Lancuchy xml
		string html_word_start = "\t <tr id=\"word\"> \n";
		string html_word_end = "\t </tr> \n";
		string html_keyword = "\t\t<td id=\"keyword\">" + word + "</keyword> \n";


		//string xml_weight = "\t\t\t<weight> \n" + + "</weight> \n";

		string html_scope = "\t \t <td id=\"scope\">" + word + "</td> \n";
		string html_synonyms_start = "\t \t <td id=\"syn\">";
		string html_synonyms_end = "</td> \n";
		string html_synonym = "";

		if (syn_weight > 0) {
			out_html << html_word_start;
			out_html << html_keyword;
			out_html << "\t \t <td id=\"weight\">" + to_string(syn_weight) + "</td> \n";
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

#endif //SAVING_H