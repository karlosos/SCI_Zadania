#ifndef TRIMMING_H
#define TRIMMING_H

#include "saving.h"
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
/// wydobywa slowa z wordnika
///
/// @param string word - slowo ktore szukamy w wordniku
///
//void trim_wordnik(string word) {
//		string line;
//		// Input file
//		string i_path = "\wordnik\\" + word + ".txt";
//        ifstream i_file (i_path);
//
//		//Output file for synonyms
//		string o_path_syn = "t_wordnik\\t_" + word + "_syn.txt";
//		std::ofstream o_file_syn (o_path_syn, std::ofstream::out);
//
//		//Output file for equvalents
//		string o_path_eq = "t_wordnik\\t_" + word + "_eq.txt";
//		std::ofstream o_file_eq (o_path_eq, std::ofstream::out);
//
//		// Trimming second file
//        if (i_file.is_open())
//        {
//                regex pattern_start_syn( "synonyms" );
//				regex pattern_start_eq( "equivalents" );
//				regex pattern_end_syn( "<\/ol>" );
//				regex pattern_end_eq( "<\/ol>" );
//				bool match_syn = false;
//				bool match_eq = false;
//
//                while ( getline (i_file,line))
//                {
//					// Synonyms
//					if(regex_search (line, pattern_start_syn))
//						match_syn = true;
//					if(regex_search (line, pattern_end_syn))
//						match_syn = false;
//					if(match_syn)
//						o_file_syn << line + "\n";   
//
//					// Equivalents
//					if(regex_search (line, pattern_start_eq))
//						match_eq = true;
//					if(regex_search (line, pattern_end_eq))
//						match_eq = false;
//					if(match_eq)
//						o_file_eq << line + "\n";  
//
//                }
//                i_file.close();
//				o_file_syn.close();
//        }
//        else cout << "Unable to open file";
//
//		//cout << "Triming wordnik: " << word << endl;
//}

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

                while ( getline (i_file,line))
                {
					if(regex_search (line, pattern_scope_end)) {
						// Zapisywanie do html i xml
						save_to_xml(word, type, scope, common_syn, syn, "zadanie2");
						save_to_html(word, type, scope, common_syn, syn, "zadanie2");

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
}

////////////////////// NOWE
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

				bool is_scope = false;

                while ( getline (i_file,line))
                {
					if(regex_search (line, pattern_end)) {
						// Zapisywanie do html i xml
						save_to_xml(word, syn);
						save_to_html(word, syn);

						// Usuwanie zmiennych ze wskaznikow
						syn->clear();
						//delete syn;

						is_scope = false;
					}

					if(regex_search (line, pattern_syn_start) || regex_search (line, pattern_eq_start)) {
						is_scope = true;
						// Tworzy nowe zmienne dla wskaznikow

					}

					if(is_scope) {

						if ( regex_search (line, pattern_syn) ) {

                            std::size_t pos_start = line.find("<span data-definition-for=\"");  
                            std::size_t pos_end = line.find("\">", pos_start+27);

							pos_start += 27;
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