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
		// Input file
		string i_path = "thesaurus\\" + word + ".txt";
        ifstream i_file (i_path);

		// Trimming second file
        if (i_file.is_open()) {
			string line;
			string *type = nullptr;
			vector <string> *meanings = new vector <string>;
			vector <string> *syn = nullptr;
			vector <string> *common_syn = nullptr;

			regex r_scope_start("<div id=\"synonyms-");
			regex r_scope_end("<div id=\"filter-");
			regex r_type("<em class=\"txt\">");

			regex r_synonym("<a href=\"http://www.thesaurus.com/browse/");
			regex r_common_synonym("class=common-word");

			regex r_meanings_start(" <!-- words-gallery -->");
			regex r_meanings_end("</ul>");
			regex r_meaning_list("<strong class=\"ttl\">");

			bool found_meanings = false;
			bool meanings_start = false;
			bool is_scope = false;
			bool in_scope = false;
			bool is_synonym = false;
			bool is_common_synonym = false;

			int meaning_count = -1;

			while (getline(i_file, line)) {
				// Przetwarzanie meanings
				if (found_meanings == false) {
					if (meanings_start) {
						if (regex_search(line, r_meaning_list)) {
							std::size_t pos_start = line.find("<strong class=\"ttl\">");
							std::size_t pos_end = line.find("</strong>", pos_start);
							pos_start += 20;
							pos_end;
							std::size_t pos_len = pos_end - pos_start;
							std::string str = line.substr(pos_start, pos_len);
							// Push common synonim
							meanings->push_back(str);
						}
						else if (regex_search(line, r_meanings_end))
							found_meanings = true;
					}
					else if (regex_search(line, r_meanings_start))
						meanings_start = true;
				}// - Przetwarzanie meanings
				// Szukanie ca³ego scope
				else {
					// Przetwarzanie scope
					if (is_scope) {
						// Zamkniecie scope
						if (regex_search(line, r_scope_end)) {
							is_scope = false;
							// Deep words
							if (*type == "noun") {
								for (unsigned int i = 0; i<syn->size(); i++) {
									deep_words_tmp.push_back(syn->at(i));
								}
								for (unsigned int i = 0; i<common_syn->size(); i++) {
									deep_words_tmp.push_back(common_syn->at(i));
								}
							}
							// Zapisywanie
							save_to_xml(word, meanings->at(++meaning_count), type, common_syn, syn, "zadanie2");
							save_to_html(word, meanings->at(meaning_count), type, common_syn, syn, "zadanie2", 0);
							// Usuwanie zmiennych
							delete type;
							delete common_syn;
							delete syn;
						} // - Zamkniecie scope
						else {
							// Przetwarzanie synonimow
							if (in_scope) {
								if (is_common_synonym) {
									std::size_t pos_start = line.find("<span class=\"text\">");
									std::size_t pos_end = line.find("</span>", pos_start);
									pos_start += 19;
									std::size_t pos_len = pos_end - pos_start;
									std::string str = line.substr(pos_start, pos_len);
									// Push common synonim
									common_syn->push_back(str);
									is_common_synonym = false;
									in_scope = false;
								}
								if (is_synonym) {
									std::size_t pos_start = line.find("<span class=\"text\">");
									std::size_t pos_end = line.find("</span>", pos_start);
									pos_start += 19;
									pos_end;
									std::size_t pos_len = pos_end - pos_start;
									std::string str = line.substr(pos_start, pos_len);
									//Push synonim
									syn->push_back(str);
									is_synonym = false;
									in_scope = false;
								}
							}// - Przetwarzanie synonimow
							// Szukanie pocz¹tku synonimów i typu
							else {
								if (regex_search(line, r_common_synonym)) {
									is_common_synonym = true;
									in_scope = true;
								}
								else if (regex_search(line, r_synonym)) {
									is_synonym = true;
									in_scope = true;
								}
								else if (regex_search(line, r_type)) {
									std::size_t pos_start = line.find("<em class=\"txt\">");
									std::size_t pos_end = line.find("</em>", pos_start);
									pos_start += 16;
									pos_end;
									std::size_t pos_len = pos_end - pos_start;
									std::string str = line.substr(pos_start, pos_len);
									*type = str;
								}
							}// - Szukanie pocz¹tku synonimów i typu
						}
					}
					else {
						if (regex_search(line, r_scope_start)) {
							is_scope = true;
							type = new string;
							common_syn = new vector <string>;
							syn = new vector <string>;
						}			
					}
				}// - Szukanie ca³ego scope

			}
			delete meanings;
        }
        else {
			cout << "Unable to open file for word: " << word << endl;
			save_log("Unable to open file for word: " + word, currentDateTime());
		}
}

///
/// wydobywa slowa z thesaurusa z ni¿szego poziomu
///
/// @param string word - slowo ktore szukamy w thesaurusie
/// @param int deep
///
void trim_thesaurus(string word, int deep) {
	// Input file
	string i_path = "thesaurus\\" + word + ".txt";
	ifstream i_file(i_path);

	// Trimming second file
	if (i_file.is_open()) {
		string line;
		string *type = nullptr;
		vector <string> *meanings = new vector <string>;
		vector <string> *syn = nullptr;
		vector <string> *common_syn = nullptr;

		regex r_scope_start("<div id=\"synonyms-");
		regex r_scope_end("<div id=\"filter-");
		regex r_type("<em class=\"txt\">");

		regex r_synonym("<a href=\"http://www.thesaurus.com/browse/");
		regex r_common_synonym("class=common-word");

		regex r_meanings_start(" <!-- words-gallery -->");
		regex r_meanings_end("</ul>");
		regex r_meaning_list("<strong class=\"ttl\">");

		bool found_meanings = false;
		bool meanings_start = false;
		bool is_scope = false;
		bool in_scope = false;
		bool is_synonym = false;
		bool is_common_synonym = false;

		int meaning_count = -1;

		while (getline(i_file, line)) {
			// Przetwarzanie meanings
			if (found_meanings == false) {
				if (meanings_start) {
					if (regex_search(line, r_meaning_list)) {
						std::size_t pos_start = line.find("<strong class=\"ttl\">");
						std::size_t pos_end = line.find("</strong>", pos_start);
						pos_start += 20;
						pos_end;
						std::size_t pos_len = pos_end - pos_start;
						std::string str = line.substr(pos_start, pos_len);
						// Push common synonim
						meanings->push_back(str);
					}
					else if (regex_search(line, r_meanings_end))
						found_meanings = true;
				}
				else if (regex_search(line, r_meanings_start))
					meanings_start = true;
			}// - Przetwarzanie meanings
			// Szukanie ca³ego scope
			else {
				// Przetwarzanie scope
				if (is_scope) {
					// Zamkniecie scope
					if (regex_search(line, r_scope_end)) {
						is_scope = false;
						// Zapisywanie
						save_to_xml(word, meanings->at(++meaning_count), type, common_syn, syn, "zadanie2");
						save_to_html(word, meanings->at(meaning_count), type, common_syn, syn, "zadanie2", 1);
						// Usuwanie zmiennych
						delete type;
						delete common_syn;
						delete syn;
					} // - Zamkniecie scope
					else {
						// Przetwarzanie synonimow
						if (in_scope) {
							if (is_common_synonym) {
								std::size_t pos_start = line.find("<span class=\"text\">");
								std::size_t pos_end = line.find("</span>", pos_start);
								pos_start += 19;
								std::size_t pos_len = pos_end - pos_start;
								std::string str = line.substr(pos_start, pos_len);
								// Push common synonim
								common_syn->push_back(str);
								is_common_synonym = false;
								in_scope = false;
							}
							if (is_synonym) {
								std::size_t pos_start = line.find("<span class=\"text\">");
								std::size_t pos_end = line.find("</span>", pos_start);
								pos_start += 19;
								pos_end;
								std::size_t pos_len = pos_end - pos_start;
								std::string str = line.substr(pos_start, pos_len);
								//Push synonim
								syn->push_back(str);
								is_synonym = false;
								in_scope = false;
							}
						}// - Przetwarzanie synonimow
						// Szukanie pocz¹tku synonimów i typu
						else {
							if (regex_search(line, r_common_synonym)) {
								is_common_synonym = true;
								in_scope = true;
							}
							else if (regex_search(line, r_synonym)) {
								is_synonym = true;
								in_scope = true;
							}
							else if (regex_search(line, r_type)) {
								std::size_t pos_start = line.find("<em class=\"txt\">");
								std::size_t pos_end = line.find("</em>", pos_start);
								pos_start += 16;
								pos_end;
								std::size_t pos_len = pos_end - pos_start;
								std::string str = line.substr(pos_start, pos_len);
								*type = str;
							}
						}// - Szukanie pocz¹tku synonimów i typu
					}
				}
				else {
					if (regex_search(line, r_scope_start)) {
						is_scope = true;
						type = new string;
						common_syn = new vector <string>;
						syn = new vector <string>;
					}
				}
			}// - Szukanie ca³ego scope

		}
		delete meanings;
	}
	else {
		cout << "Unable to open file for word: " << word << endl;
		save_log("Unable to open file for word: " + word, currentDateTime());
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
				// Sprawdzic "<\/ol>"
				regex pattern_end( "</ol>" );
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