#include "global.h"

// Zmienne globalne
std::vector < string > words;
std::vector < string > wiki_words;
std::vector < string > scope_words;
std::vector < string > scope_words_tmp;
std::vector < string > deep_words;
std::vector < string > deep_words_tmp;
std::vector < string > scope_words_corrupt;
string scope_type;
string previous_scope;
string log_name;

#include "files.h"
#include "downloading.h"
#include "trimming.h"
#include "saving.h"

int main () {
	// Zmienna do okreslania ile procent slow wykonano
	long double status = 0;
	// Zmienna do okreslania zadania ktore program ma wykonac
	int nr_zadania = 0;

	while(nr_zadania != 1 && nr_zadania != 2) {
		cout << "Podaj numer zadania [1 lub 2]: ";
		cin >> nr_zadania;
	}
	////////////////////////////////////////////////////
	///Zadanie 2
	////////////////////////////////////////////////////
	if (nr_zadania == 2) {
		// Tworzy pliki wynikowe
		create_log(currentDateTime());
		create_html("zadanie2");
		create_xml("zadanie2");
		create_xml("zadanie2_corrupt");

		// Tworzy folder
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

		// Sortuje i usuwa powtorzenia w kontenerze ze s³owami
		sort_unique_words();

		// Petla pobiera i parsuje kazde slowo
		for (unsigned int i = 0; i < words.size(); i++) {
			// Jezeli pliku nie mamy na dysku to go sciagamy
			if (fileNotExists(words[i], "thesaurus")) {
				download_thesaurus(words[i]);
				// Na konsoli wyswietla nam przebieg dzia³ania programu
				status = ( i / double(words.size()) ) * 100;
				cout << "Bad one: " + words[i] + ". " + to_string(status) + "%\n";
			}
			else {
				// Na konsoli wyswietla nam przebieg dzia³ania programu
				status = ( i / double(words.size()) ) * 100;
				cout << "N1: " + words[i] + ". " + to_string(status) + "%\n";
			}
			//Parsowanie pliku ze slowa
			trim_thesaurus(words[i]);
		}// - Petla pobiera i parsuje kazde slowo

		// Sortuje kontener z deep_words
		// Slowa te to wszystkie synonimy dla noun
		sort_deep_words();
		// Petla pobiera i parsuje kazde slowo deep
		for (unsigned int i = 0; i < deep_words.size(); i++) {
			// Jezeli pliku nie mamy na dysku to go sciagamy
			if (fileNotExists(deep_words[i], "thesaurus")) {
				download_thesaurus(deep_words[i]);
				// Na konsoli wyswietla nam przebieg dzia³ania programu
				status = (i / double(deep_words.size())) * 100;
				cout << "Bad deep: " + deep_words[i] + ". nr=" + to_string(long double(i)) + " " + to_string(status) + "%\n";
			}
			else {
				// Na konsoli wyswietla nam przebieg dzia³ania programu
				status = (i / double(deep_words.size())) * 100;
				cout << "N1 deep: " + deep_words[i] + ". nr=" + to_string(long double(i)) + " " + to_string(status) + "%\n";
			}
			trim_thesaurus(deep_words[i], 0);
		}// - Petla pobiera i parsuje kazde slowo deep

		// Domykamy pliki
		close_log(currentDateTime());
		close_xml("zadanie2");
		close_html("zadanie2");
		close_xml("zadanie2_corrupt");
		post_process("zadanie2");
	} 

	////////////////////////////////////////////////////
	///Zadanie 1
	////////////////////////////////////////////////////

	else if (nr_zadania == 1) {

		// Tworzy pliki wynikowe
		create_log(currentDateTime());
		create_html_old("zadanie1");
		create_xml("zadanie1");


		// Twprzy foldery
		_mkdir("wordnik");

		// Pobiera dane z wordnetcode i z wiktionary
		download_wordnetcode();
		download_wiktionary();

		// Wydziela dane z powyzszych plikow
		trim_wordnetcode();
		trim_wiktionary();

		// Sortuje i usuwa powtorzenia w kontenerze
		sort_unique_words();

		// Petla pobiera i parsuje kazde slowo words.size()
		for (unsigned int i = 0; i < words.size(); i++) {
			if (fileNotExists(words[i], "wordnik")) {
				// Pobieramy i trimujemy dane slowo
				download_wordnik(words[i]);
				status = (i / double(words.size())) * 100;
				cout << "Bad 1: " + words[i] + ". nr=" + to_string(long double(i)) + " " + to_string(status) + "%\n";
			}
			else {
				trim_wordnik(words[i]);
				status = (i / double(words.size())) * 100;
				cout << "N1: " + words[i] + ". nr=" + to_string(long double(i)) + " " + to_string(status) + "%\n";
			}
		}// - Petla pobiera i parsuje kazde slowo
		// Domykamy pliki
		close_log(currentDateTime());
		close_xml("zadanie1");
		close_html("zadanie1");

		post_process("zadanie1");
	}
	return 0;
}