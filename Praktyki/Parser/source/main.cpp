#include "global.h"

std::vector < string > words;
std::vector < string > wiki_words;
string log_name;

#include "files.h"
#include "downloading.h"
#include "trimming.h"
#include "saving.h"

int main () {
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

			//mkdir("b_wordnik");
			mkdir("thesaurus");

			// Pobiera dane z wordnetcode i z wiktionary
			download_wordnetcode();
			download_wiktionary();
 
			// Wydziela dane z powyzszych plikow
			trim_wordnetcode();
			trim_wiktionary();
 
			// Sortuje i usuwa powtorzenia w kontenerze
			sort_unique_words();

			// Petla pobierajaca synonimy/equivalenty dla danego slowa
			// generuje html w postaci tabeli words.size();
			;
			for(int i = 0; i < words.size(); i++ ) {
					// Pobieramy i trimujemy dane slowo
					download_thesaurus(words[i]);
					trim_thesaurus(words[i]);
			}

			// Domykamy pliki
			close_log(currentDateTime());
			close_xml("zadanie2");
			close_html("zadanie2");
		} 

////////////////////////////////////////////////////
///Zadanie 1
////////////////////////////////////////////////////

		else if (nr_zadania == 1) {

			// Tworzy poczatek html
			create_log(currentDateTime());
			create_html_old("zadanie1");
			create_xml("zadanie1");

			mkdir("b_wordnik");
			mkdir("t_wordnik");
			mkdir("wordnik");

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
			for(int i = 0; i < words.size(); i++ ) {
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
 








