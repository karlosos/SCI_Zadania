//2015-09-22
//Temat: Wyszukiwanie binarne
//		 Sortowanie - na przyk�adzie sortowania b�belkowego
//		 przypomnienie wiadomo�ci
//		 Wst�p dop poj�� zwi�zanych ze z�o�ono�ci� algorytm�w
//

#include <iostream>

int main()
{
	//szukanie liniowe...
	//int tab[10] = { 1, 32, 4, 45, -56, 33,43,4, 65, 456 };
	//int szukana = 1;//optymistycznie (ilosc iteracji - 1)
	//int szukana = 456;//pesymistycznie (ilosc iteracji - 10)


	//Strategia "Dziel i zwyci�aj"
	//Warunek konieczny - zbi�r MUSI by� uporz�dkowany
	//posorotwany
	//
	int tab[10] = { 1, 23, 33, 48, 77, 90, 92, 100, 123, 300 };
	//tutaj wstaw kod sortuj�cy tablic�...
	int szukana = 33;
	//dzielimy zbi�r na po�ow� (�rodek) - po indeksach
	int l = 0; //lewa strona zbioru (przedzia�u)
	int r = 9; //prawa strona zbioru (przedzia�u)
	int srodek = (l+r)/2; // dla 77 mamy (0+9)/2 = 4,5
	//ale mamy typ int, czyli liczy si� tylko 
	//cz�� ca�kowita = czyli mamy wynik => 4
	
	//{ 0,  1,  2,  3,  4,  5,  6,   7,   8,   9 };
	//{ 1, 23, 33, 48, 77, 90, 92, 100, 123, 300 };
	//                  |
	//                srodek
	//{ 1, 23, 33, 48, 77, 90, 92, 100, 123, 300 };
	//              |
	//{ 1, 23, 33, 48, 77, 90, 92, 100, 123, 300 };
	//          |

	if(tab[srodek] == szukana)
		std::cout << "Znaleziono" << std::endl;
	//sytuacja bardzo korzystna, optuymistyczna
	//nie trzeba dalej szuka�...
	//
	//ale gdy musimy szuka� dalej...

	//*************************
	//tutaj szukanie binarne...	
	//dop�ki zakresy zbioru si� nie wyczerpi�
	//warunek zawsze si� zako�czy (opu�cimy p�tl�)
	//poniewa� r zwi�kszamy, a l zmniejszamy
	while(l <= r)
	{
		srodek = (l+r)/2;
		if(tab[srodek]==szukana)//optymistycznie...
			std::cout << "Znaleziono" << std::endl;
		
		//pesymistycznie - musimy dalej szuka�
		//decydujemy, czy b�dziemy przesuwa� si� w lewo, czy w prawo?
		if(tab[srodek] > szukana)
			r = srodek - 1;
		else
			l = srodek + 1;
	}
	//*************************

	return 0;
}


//To do:
//2015-09-23
	
	//Zadanie:
	//Opakuje kod wyszukiwania binarnego do postaci
	//funckji (nazw�, argumenty, miejsce implementacji
	//zaproponuj sam.
	//
	//Zadanie dodatkowe:
	//Napisz kod, kt�ry tworzy bardzo du�� tablic� typu
	//int - np. 1000000 (milion) element�w.
	//Wstaw do tej tablicy milion element�w wygenerowanych
	//pseudolosowo.
	//Posortuj t� tablic� rosn�co.
	//Dokonaj testu polegaj�cego na pomiarze czasu
	//wyszikania elementu z tej tablicy, pos�uguj�c
	//si� z�o�ono�ci� liniow� i dla por�wnania
	//z�o�ono�ci� binary serach.
	//
	//Opracuj prezentacj� na temat:
	//"Z�o�ono�� algorytm�w"
	//oceniam w dniu 29 wrze�nia 2015
