#ifndef TRIMMING_H
#define TRIMMING_H

#include "saving.h"
#include "scope.h"

///
/// wydobywa slowa z wordnetcode
///
void trim_wordnetcode() {
		string line;

		//Input file
        ifstream i_file ("wordnetcode.txt");

		//Output file
		//std::ofstream o_file ("b_wordnetcode.txt", std::ofstream::out);
	
        // Trimming first file
        if (i_file.is_open())
        {
                while ( getline (i_file,line) )
                {
                        std::size_t pos_start = line.find("[");  
						std::size_t pos_end = line.find("%");
						std::size_t pos_len = pos_end - pos_start;

						pos_start++;
						pos_len--;

                        std::string str = line.substr (pos_start, pos_len);
               
                        words.push_back(str);
						//o_file << str+ "\n"; 
                }
                i_file.close();
				//o_file.close();
        }
        else {
			cout << "Unable to open file for wordnetcode" << endl;
			save_log("Unable to open file for wordnetcode", currentDateTime());
		}
}

///
/// wydobywa slowa z wiktionary
///
void trim_wiktionary() {
		string line;
		// Input file
        ifstream i_file ("wiktionary.txt");

		//Output file
		//std::ofstream o_file ("b_wiktionary.txt", std::ofstream::out);
 
        // Trimming second file
        if (i_file.is_open())
        {
                regex pattern( "<a href=\"/wiki/Wikisaurus:" );

                while ( getline (i_file,line) )
                {
                        if ( regex_search (line, pattern) ) {

                                std::size_t pos_start = line.find("title=\"Wikisaurus:");  
                                std::size_t pos_end = line.find("\"", pos_start+18);

								pos_start += 18;
								pos_end;

								std::size_t pos_len = pos_end - pos_start;
                                std::string str = line.substr (pos_start, pos_len);
								
                                wiki_words.push_back(str);
								//o_file << str+ "\n";        
                        }
                }
                i_file.close();
				//o_file.close();
        }
        else {
			cout << "Unable to open file for wiktionary" << endl;
			save_log("Unable to open file for wiktionary", currentDateTime());
		}
}

///
/// wydobywa slowa z thesaurusa
///
/// @param string word - slowo ktore szukamy w thesaurusie
///
void trim_thesaurus(string word) {
		string line;

		// WskaŸniki
		string *type;
		string *scope;
		vector<string> *common_syn;
		vector<string> *syn;

		// Input file
		string i_path = "thesaurus\\" + word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open())
        {
                regex pattern_scope_start( "<div id=\"synonyms-" );
				regex pattern_scope_end( "<div id=\"filter-" );
				regex pattern_scope_name("<strong class=\"ttl\">");
				regex pattern_type("<em class=\"txt\">");
				regex pattern_synonym("<a href=\"http://thesaurus.com/browse/");
				regex pattern_common_synonym("class=common-word");

				bool is_scope = false;
				bool is_synonym = false;
				bool is_common_synonym = false;
				bool used = false;

                while ( getline (i_file,line))
                {
					if(regex_search (line, pattern_scope_end)) {
						// Zapisywanie do html i xml
						save_to_xml(word, type, scope, common_syn, syn, "zadanie2");
						save_to_html(word, type, scope, common_syn, syn, "zadanie2", 0);

						if(*type == "noun") {
							for(int i=0; i<syn->size(); i++) {
								deep_words_tmp.push_back(syn->at(i));
							}
							for(int i=0; i<common_syn->size(); i++) {
								deep_words_tmp.push_back(common_syn->at(i));
							}
						}

						if(*type == "noun" && used == false && nr_podpunktu==1) {
							// Wysy³anie do trimowania scope
							scope_add(scope);
							used = true;
						}
						// Usuwanie zmiennych ze wskaznikow
						delete type;
						delete scope;
						delete common_syn;
						delete syn;

						is_scope = false;
					}

					if(regex_search (line, pattern_scope_start)) {
						is_scope = true;
						// Tworzy nowe zmienne dla wskaznikow
						type = new string;
						scope = new string;
						common_syn = new vector <string>;
						syn = new vector <string>;

					}

					if(is_scope) {
						if(is_synonym) {
							std::size_t pos_start = line.find("<span class=\"text\">");  
                            std::size_t pos_end = line.find("</span>", pos_start);

							pos_start += 19;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							//Push synonim
							syn->push_back(str);

							is_synonym = false;
						}

						if(is_common_synonym) {
							std::size_t pos_start = line.find("<span class=\"text\">");  
                            std::size_t pos_end = line.find("</span>", pos_start);

							pos_start += 19;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							// Push common synonim
							common_syn->push_back(str);

							is_common_synonym = false;
						}

						// Sprawdzamy typ, scope, synonim, i commonsynonim
						if(regex_search (line, pattern_common_synonym)) {
							is_common_synonym = true;
						} 
						else if(regex_search (line, pattern_synonym)) {
							is_synonym = true;
						}
						

						if(regex_search (line, pattern_type)) {
							std::size_t pos_start = line.find("<em class=\"txt\">");  
                            std::size_t pos_end = line.find("</em>", pos_start);

							pos_start += 16;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							*type = str;
						}

						if(regex_search (line, pattern_scope_name)) {
							std::size_t pos_start = line.find("<strong class=\"ttl\">");  
                            std::size_t pos_end = line.find("</strong>", pos_start);

							pos_start += 20;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							*scope = str;
						}
					
					} 

                }
                i_file.close();
        }
        else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
		}

		if(nr_podpunktu==1) {
			scope_clean();
			scope_sort();
			scope_save(word);
		}
}

///
/// wydobywa slowa z thesaurusa z ni¿szego poziomu
///
/// @param string word - slowo ktore szukamy w thesaurusie
/// @param int deep
///
void trim_thesaurus(string word, int deep) {
		string line;

		// WskaŸniki
		string *type;
		string *scope;
		vector<string> *common_syn;
		vector<string> *syn;

		// Input file
		string i_path = "thesaurus\\" + word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open())
        {
                regex pattern_scope_start( "<div id=\"synonyms-" );
				regex pattern_scope_end( "<div id=\"filter-" );
				regex pattern_scope_name("<strong class=\"ttl\">");
				regex pattern_type("<em class=\"txt\">");
				regex pattern_synonym("<a href=\"http://thesaurus.com/browse/");
				regex pattern_common_synonym("class=common-word");

				bool is_scope = false;
				bool is_synonym = false;
				bool is_common_synonym = false;
				bool used = false;

                while ( getline (i_file,line))
                {
					if(regex_search (line, pattern_scope_end)) {
						// Zapisywanie do html i xml
						save_to_xml(word, type, scope, common_syn, syn, "zadanie2");
						save_to_html(word, type, scope, common_syn, syn, "zadanie2", 1);

						if(*type == "noun" && nr_podpunktu==2) {
							for(int i=0; i<syn->size(); i++) {
								deep_words_tmp.push_back(syn->at(i));
							}
							for(int i=0; i<common_syn->size(); i++) {
								deep_words_tmp.push_back(common_syn->at(i));
							}
						}

						if(*type == "noun" && used == false && nr_podpunktu==1) {
							// Wysy³anie do trimowania scope
							scope_add(scope);
							used = true;
						}
						// Usuwanie zmiennych ze wskaznikow
						delete type;
						delete scope;
						delete common_syn;
						delete syn;

						is_scope = false;
					}

					if(regex_search (line, pattern_scope_start)) {
						is_scope = true;
						// Tworzy nowe zmienne dla wskaznikow
						type = new string;
						scope = new string;
						common_syn = new vector <string>;
						syn = new vector <string>;

					}

					if(is_scope) {
						if(is_synonym) {
							std::size_t pos_start = line.find("<span class=\"text\">");  
                            std::size_t pos_end = line.find("</span>", pos_start);

							pos_start += 19;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							//Push synonim
							syn->push_back(str);

							is_synonym = false;
						}

						if(is_common_synonym) {
							std::size_t pos_start = line.find("<span class=\"text\">");  
                            std::size_t pos_end = line.find("</span>", pos_start);

							pos_start += 19;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							// Push common synonim
							common_syn->push_back(str);

							is_common_synonym = false;
						}

						// Sprawdzamy typ, scope, synonim, i commonsynonim
						if(regex_search (line, pattern_common_synonym)) {
							is_common_synonym = true;
						} 
						else if(regex_search (line, pattern_synonym)) {
							is_synonym = true;
						}
						

						if(regex_search (line, pattern_type)) {
							std::size_t pos_start = line.find("<em class=\"txt\">");  
                            std::size_t pos_end = line.find("</em>", pos_start);

							pos_start += 16;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							*type = str;
						}

						if(regex_search (line, pattern_scope_name)) {
							std::size_t pos_start = line.find("<strong class=\"ttl\">");  
                            std::size_t pos_end = line.find("</strong>", pos_start);

							pos_start += 20;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

							*scope = str;
						}
					
					} 

                }
                i_file.close();
        }
        else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
		}

		if(nr_podpunktu==1) {
			scope_clean();
			scope_sort();
			scope_save(word);
		}
}

///
/// wydobywa slowa z wordnika
///
/// @param string word - slowo ktore szukamy w thesaurusie
///
void trim_wordnik(string word) {
		string line;

		// WskaŸniki
		vector<string> *syn;
		syn = new vector <string>;

		// Input file
		string i_path = "wordnik\\" + word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open())
        {
                regex pattern_syn_start( "synonyms" );
				regex pattern_end( "<\/ol>" );
				regex pattern_eq_start( "equivalents" );
				regex pattern_syn( "<span data-definition-for=\"" );
				regex pattern_wikisaurus("See Wikisaurus:");

				bool is_scope = false;
				bool is_syn = false;
				bool is_eq = false;

                while ( getline (i_file,line))
                {
					if(regex_search (line, pattern_end)) {
						if (is_syn) {
							// Zapisywanie do html i xml
							save_to_xml(word, syn, 40);
							save_to_html(word, syn, 40);
						}
						else if(is_eq) {
							save_to_xml(word, syn, 80);
							save_to_html(word, syn, 80);
						}
						// Usuwanie zmiennych ze wskaznikow
						syn->clear();
						//delete syn;

						is_scope = false;
						is_eq = false;
						is_syn = false;
					}

					if(regex_search (line, pattern_syn_start)) {
						is_scope = true;
						is_syn = true;
					}

					if(regex_search (line, pattern_eq_start)) {
						is_scope = true;
						is_eq = true;
					}

					if(is_scope) {

						if ( regex_search (line, pattern_syn) ) {

                            std::size_t pos_start = line.find("<span data-definition-for=\"");  
                            std::size_t pos_end = line.find("\">", pos_start+27);

							if(regex_search (line, pattern_wikisaurus)) {
								pos_start = line.find("See Wikisaurus:");  
								pos_start += 15;
							} else {
								pos_start += 27;
							}

							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);

                            //Push synonim
							syn->push_back(str);    
						}					
					} 

                }
                i_file.close();
        }
        else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
		}

		delete syn;

}

///
/// wydobywa synonimy z plikow [do unowoczesnienia]
///
/// @param string word - slowo dla ktorego szukamy synonimow
///
vector <string> t_trim_wordnik_syn(string word) {
	string line;
	// Input file
	string i_path = "t_wordnik\\t_" + word + "_syn.txt";
    ifstream i_file (i_path);

	//Output file for equvalents
	//string o_path = "b_wordnik\\b_" + word + "_syn.txt";
	//std::ofstream o_file (o_path, std::ofstream::out);

	//Returned vector
	vector <string> synonyms;

	if (i_file.is_open())
    {
            regex pattern( "<span data-definition-for=\"" );

            while ( getline (i_file,line) )
            {
                    if ( regex_search (line, pattern) ) {

                            std::size_t pos_start = line.find("<span data-definition-for=\"");  
                            std::size_t pos_end = line.find("\">", pos_start+27);

							pos_start += 27;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
                            std::string str = line.substr (pos_start, pos_len);
								
                            synonyms.push_back(str);
							//o_file << str+ "\n";        
                    }
            }
            i_file.close();
			//o_file.close();
    }
    else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
	}

	return synonyms;
}

///
/// wydobywa equivalenty z plikow [do unowoczesnienia]
///
/// @param string word - slowo dla ktorego szukamy synonimow
///
vector <string> t_trim_wordnik_eq(string word) {
	string line;
	// Input file
	string i_path = "t_wordnik\\t_" + word + "_eq.txt";
	ifstream i_file (i_path);

	//Output file for equvalents
	//string o_path = "b_wordnik\\b_" + word + "_eq.txt";
	//std::ofstream o_file (o_path, std::ofstream::out);

	//Returned vector
	vector <string> equivalents;

	if (i_file.is_open())
	{
			regex pattern( "<span data-definition-for=\"" );

			while ( getline (i_file,line) )
			{
					if ( regex_search (line, pattern) ) {

							std::size_t pos_start = line.find("<span data-definition-for=\"");  
							std::size_t pos_end = line.find("\">", pos_start+27);

							pos_start += 27;
							pos_end;

							std::size_t pos_len = pos_end - pos_start;
							std::string str = line.substr (pos_start, pos_len);
								
							equivalents.push_back(str);
							//o_file << str+ "\n";        
					}
			}
			i_file.close();
			//o_file.close();
	}
	else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
	}

	return equivalents;
}

#endif //TRIMMING_H