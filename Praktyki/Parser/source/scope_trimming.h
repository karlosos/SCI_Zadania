#ifndef SCOPE_TRIMMING_H
#define SCOPE_TRIMMING_H

#include "saving.h"

void scope_trim_white();
void scope_add(string* scope);

void scope_save(string word) {
	if(scope_words.size() > 0) {
		for (int i=0; i < scope_words_tmp.size(); i++) {
		save_to_html( word, "noun", , vector<string>* common_syn, vector<string>* syn, string file_name);
		}
	}

	scope_words.clear();
	scope_words_tmp.clear();
}

///
/// Ucina pierwsz¹ spacjê
///
void scope_trim_white() {
	for (int i=0; i < scope_words_tmp.size(); i++) {
		if(scope_words_tmp.at(i).at(0) == 0x20) 
			scope_words_tmp.at(i).erase(0,1);
	}
}

///
/// Dodaje tylko dwuwyrazowe
///
void scope_sort() {
	for (int i=0; i < scope_words_tmp.size(); i++) {
		int spaces = std::count_if(scope_words_tmp.at(i).begin(), scope_words_tmp.at(i).end(), [](unsigned char c){ return isspace(c); });
		if (spaces <2) {
			scope_words.push_back(scope_words_tmp.at(i));
		}
	}

	  sort(scope_words.begin(), scope_words.end());
      scope_words.erase(unique(scope_words.begin(), scope_words.end() ), scope_words.end() );
}

///
/// Tnie scope
///
/// @param string scope - Scope do skrojenia
///
void scope_add(string* scope) {	
	string str = *scope;
    std::size_t prev_pos = 0, pos;
    while ((pos = str.find_first_of(",;", prev_pos)) != std::string::npos)
    {
        if (pos > prev_pos)
            scope_words_tmp.push_back(str.substr(prev_pos, pos-prev_pos));
        prev_pos= pos+1;
    }
    if (prev_pos< str.length())
        scope_words_tmp.push_back(str.substr(prev_pos, std::string::npos));
}


#endif //SCOPE_TRIMMING_H