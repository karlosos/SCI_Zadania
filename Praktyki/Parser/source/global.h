#ifndef GLOBAL_H
#define GLOBAL_H

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <stdio.h>
#include <time.h>
#include <Urlmon.h>
#include <regex>
#include <windows.h> // Sprawdzic
#include <direct.h>
#include <algorithm>
//#include <boost/tokenizer.hpp> //

#pragma comment(lib, "urlmon.lib")

using namespace std;

// Zmienne globalne
extern std::vector < string > words;
extern std::vector < string > wiki_words;
extern std::vector < string > deep_words_tmp;
extern std::vector < string > deep_words;
extern std::vector < string > scope_words;
extern std::vector < string > scope_words_tmp;
extern string previous_scope;
extern string log_name;
extern string scope_type;
extern int nr_podpunktu;

///
/// Get current date/time, format is YYYY-MM-DD.HH:mm:ss
///

const std::string currentDateTime() {
    time_t     now = time(0);
    struct tm  tstruct;
    char       buf[80];
    tstruct = *localtime(&now);
    // Visit http://en.cppreference.com/w/cpp/chrono/c/strftime
    // for more information about date/time format
    strftime(buf, sizeof(buf), "%Y-%m-%d %H-%M-%S", &tstruct);

    return buf;
}

///
/// Laczy i usuwa powtorzenia w kontenerach ze slowami
///
void sort_unique_words() {
		// wiki_words dodaje do words i usuwam powtorzenia
        for( int i = 0; i < wiki_words.size(); i++ )           
                words.push_back(wiki_words[i]);

        sort(words.begin(), words.end());
        words.erase(unique(words.begin(), words.end() ), words.end() );

		// wypisuje cala baze slow do b_all_words 
		// nie potrzebne
		std::ofstream o_file ("b_all_words.txt", std::ofstream::out);

		for( int i = 0; i < words.size(); i++ )  {
			o_file << words[i] << "\n";
		}
		o_file.close();
}

///
/// Laczy i usuwa powtorzenia w kontenerach ze slowami
///
void sort_deep_words() {

        sort(deep_words_tmp.begin(), deep_words_tmp.end());
        deep_words_tmp.erase(unique(deep_words_tmp.begin(), deep_words_tmp.end() ), deep_words_tmp.end() );

		std::set_difference(
			deep_words_tmp.begin(), deep_words_tmp.end(),
			words.begin(), words.end(),
			std::back_inserter( deep_words )
		);


		// wypisuje cala baze slow do b_all_words 
		// nie potrzebne
		std::ofstream o_file ("b_all_deep_words.txt", std::ofstream::out);

		for( int i = 0; i < deep_words.size(); i++ )  {
			o_file << deep_words[i] << "\n";
		}
		o_file.close();
}

#endif //GLOBAL_H