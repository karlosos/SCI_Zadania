//2015 - 09 - 15
//Temat: Zapis do pliku - przyk³ad
//		 Generator - tworzenie danych...
#include <iostream>
#include <fstream>
#include <string>
#include <time.h>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	// Pliki do odczytu i zapisu
	std::fstream names_file;
	std::fstream surnames_file;
	std::fstream output_file;

	// Otwieranie plików
	names_file.open("names.txt", std::ios::in);
	surnames_file.open("surnames.txt", std::ios::in);
	output_file.open("wynik.txt", std::ios::out);

	// Zmienne na imiona
	std::string imie;
	std::vector<std::string> imiona;

	// Zmienne na nazwiska
	std::string nazwisko;
	std::vector<std::string> nazwiska;

	// Wczytywanie imion z pliku
	while (!names_file.eof())
	{
		std::getline(names_file, imie);
		if (imie.size() > 0)
		{
			imiona.push_back(imie);
		}
	}

	// Wczytywanie nazwisk z pliku
	while (!surnames_file.eof())
	{
		std::getline(surnames_file, nazwisko);
		if (nazwisko.size() > 0)
		{
			nazwiska.push_back(nazwisko);
		}
	}

	// Usuwanie powtorzen imion
	std::sort(imiona.begin(), imiona.end());

	std::vector<string>::iterator is;
	is = unique(imiona.begin(), imiona.end());
	imiona.resize(std::distance(imiona.begin(), is));

	// Usuwanie powtórzeñ nazwisk
	std::sort(nazwiska.begin(), nazwiska.end());

	is = unique(nazwiska.begin(), nazwiska.end());
	nazwiska.resize(std::distance(nazwiska.begin(), is));

	//start dla generatora liczb pseudolosowych
	srand((unsigned)time(NULL));//losujemy ziarno - zale¿y od czasu...

	//dane dla genaratora
	int rozmiar_danych = 10000;			//iloœæ danych w pliku docelowym
	int wylosowany_indeks_imion = 0;	//...
	int wylosowany_indeks_nazwisk = 0;	//...
										//zmienne pomocnicze
	imie = "";		//imiê - wartoœæ z tablicy zale¿na od losowania
	nazwisko = "";	//nazwisko - wartoœæ z tablicy zale¿na od losowania
	std::string data;		//dane, które zapiszemy do pliku (K O N K A T E N A C J A)
							//przygotowanie pliku, do którego zapiszemy dane...

												 //generowanie...
	for (int i = 0; i < rozmiar_danych; i++)
	{
		//losujemy indeks, na podstawie którego wybieramy imiê z banku
		wylosowany_indeks_imion = (std::rand() % imiona.size()) + 0;
		imie = imiona[wylosowany_indeks_imion];
		//std::cout << imie << std::endl;//lub tak: imie.c_str()

		//losujemy indeks, na podstawie którego wybieramy nazwisko z banku
		wylosowany_indeks_nazwisk = (std::rand() % nazwiska.size()) + 0;
		nazwisko = nazwiska[wylosowany_indeks_nazwisk];
		//std::cout << nazwisko << std::endl;//lub tak: imie.c_str()

		data = imie + " " + nazwisko;
		std::cout << data << std::endl;
		//zapisujemy dane do pliku...
		output_file << data << std::endl;
	}

	names_file.close();
	surnames_file.close();
	output_file.close();

	std::system("Pause");

	return 0;
}

//zadanie:
//zmodyfikuj ten program w taki sposób,
//aby bank imion oraz bank nazwisk by³ ³adowany
//z plików (odpowiednio imiona.txt i nazwiska.txt)