#include "global.h"

std::vector < string > words;
std::vector < string > wiki_words;
std::vector < string > scope_words;
string scope_type;
std::vector < string > scope_words_tmp;
std::vector < string > deep_words;
std::vector < string > deep_words_tmp;
std::vector < string > scope_words_corrupt;
string previous_scope;

string log_name;

#include "files.h"
#include "downloading.h"
#include "trimming.h"
#include "saving.h"
#include "scope.h"

int main () {
	long double status = 0;
		int nr_zadania = 0;

		while(nr_zadania != 1 && nr_zadania != 2) {
			cout << "Podaj numer zadania [1 lub 2]: ";
			cin >> nr_zadania;
		}
////////////////////////////////////////////////////
///Zadanie 2
////////////////////////////////////////////////////
		if (nr_zadania == 2) {
			// Tworzy poczatek html
			create_log(currentDateTime());
			create_html("zadanie2");
			create_xml("zadanie2");
			create_xml("zadanie2_corrupt");

			//mkdir("b_wordnik");
			_mkdir("thesaurus");

			// Pobiera dane z wordnetcode i z wiktionary
			if(fileNotExists("wordnetcode")) {
				download_wordnetcode();
			}

			if(fileNotExists("wiktionary")) {
				download_wiktionary();
			}

			// Wydziela dane z powyzszych plikow
			trim_wordnetcode();
			trim_wiktionary();
 
			// Sortuje i usuwa powtorzenia w kontenerze
			sort_unique_words();
			// Petla pobierajaca synonimy/equivalenty dla danego slowa
			// generuje html w postaci tabeli words.size();
			for (unsigned int i = 0; i < words.size(); i++) {
					// Sprawdzamy czy nie istnieje plik. Je¿eli prawda to œci¹gnij.
				//double(words.size())
				if (fileNotExists(words[i], "thesaurus"))
						download_thesaurus(words[i]);
					else {
						status = ( i / double(words.size()) ) * 100;
						cout << "N1 " + words[i] + ". " + to_string(status) + "%\n";
					}

					trim_thesaurus(words[i]);
			}

				sort_deep_words();
				// Petla pobierajaca synonimy dla danego slowa
				// generuje html w postaci tabeli deep_words.size();
				for (unsigned int i = 0; i < deep_words.size(); i++) {
					if (fileNotExists(deep_words[i], "thesaurus"))
						download_thesaurus(deep_words[i]);
					else {
						status = (i / double(deep_words.size())) * 100;
						cout << "N1 deep " + deep_words[i] + ". nr=" + to_string(i) + " nr_o=" + to_string(words.size()) + " " + to_string(status) + "%\n";
					}
					trim_thesaurus(deep_words[i], 0);
				}

			// Domykamy pliki
			close_log(currentDateTime());
			close_xml("zadanie2");
			close_html("zadanie2");
			close_xml("zadanie2_corrupt");
		} 

////////////////////////////////////////////////////
///Zadanie 1
////////////////////////////////////////////////////

		else if (nr_zadania == 1) {

			// Tworzy poczatek html
			create_log(currentDateTime());
			create_html_old("zadanie1");
			create_xml("zadanie1");

			_mkdir("b_wordnik");
			_mkdir("t_wordnik");
			_mkdir("wordnik");

			// Pobiera dane z wordnetcode i z wiktionary
			download_wordnetcode();
			download_wiktionary();
 
			// Wydziela dane z powyzszych plikow
			trim_wordnetcode();
			trim_wiktionary();
 
			// Sortuje i usuwa powtorzenia w kontenerze
			sort_unique_words();

			// Petla pobierajaca synonimy/equivalenty dla danego slowa
			// generuje html w postaci tabeli
			for (unsigned int i = 0; i < words.size(); i++) {
				// Pobieramy i trimujemy dane slowo
				download_wordnik(words[i]);
				trim_wordnik(words[i]);
			}

			// Domykamy pliki
			close_log(currentDateTime());
			close_xml("zadanie1");
			close_html("zadanie1");
		}
  return 0;
}
 








