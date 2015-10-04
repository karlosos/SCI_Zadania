//2015-09-22
//Temat: Wyszukiwanie binarne
//		 Sortowanie - na przyk³adzie sortowania b¹belkowego
//		 przypomnienie wiadomoœci
//		 Wstêp dop pojêæ zwi¹zanych ze z³o¿onoœci¹ algorytmów
//

#include <iostream>

int main()
{
	//szukanie liniowe...
	//int tab[10] = { 1, 32, 4, 45, -56, 33,43,4, 65, 456 };
	//int szukana = 1;//optymistycznie (ilosc iteracji - 1)
	//int szukana = 456;//pesymistycznie (ilosc iteracji - 10)


	//Strategia "Dziel i zwyciê¿aj"
	//Warunek konieczny - zbiór MUSI byæ uporz¹dkowany
	//posorotwany
	//
	int tab[10] = { 1, 23, 33, 48, 77, 90, 92, 100, 123, 300 };
	//tutaj wstaw kod sortuj¹cy tablicê...
	int szukana = 33;
	//dzielimy zbiór na po³owê (œrodek) - po indeksach
	int l = 0; //lewa strona zbioru (przedzia³u)
	int r = 9; //prawa strona zbioru (przedzia³u)
	int srodek = (l+r)/2; // dla 77 mamy (0+9)/2 = 4,5
	//ale mamy typ int, czyli liczy siê tylko 
	//czêœæ ca³kowita = czyli mamy wynik => 4
	
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
	//nie trzeba dalej szukaæ...
	//
	//ale gdy musimy szukaæ dalej...

	//*************************
	//tutaj szukanie binarne...	
	//dopóki zakresy zbioru siê nie wyczerpi¹
	//warunek zawsze siê zakoñczy (opuœcimy pêtlê)
	//poniewa¿ r zwiêkszamy, a l zmniejszamy
	while(l <= r)
	{
		srodek = (l+r)/2;
		if(tab[srodek]==szukana)//optymistycznie...
			std::cout << "Znaleziono" << std::endl;
		
		//pesymistycznie - musimy dalej szukaæ
		//decydujemy, czy bêdziemy przesuwaæ siê w lewo, czy w prawo?
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
	//funckji (nazwê, argumenty, miejsce implementacji
	//zaproponuj sam.
	//
	//Zadanie dodatkowe:
	//Napisz kod, który tworzy bardzo du¿¹ tablicê typu
	//int - np. 1000000 (milion) elementów.
	//Wstaw do tej tablicy milion elementów wygenerowanych
	//pseudolosowo.
	//Posortuj tê tablicê rosn¹co.
	//Dokonaj testu polegaj¹cego na pomiarze czasu
	//wyszikania elementu z tej tablicy, pos³uguj¹c
	//siê z³o¿onoœci¹ liniow¹ i dla porównania
	//z³o¿onoœci¹ binary serach.
	//
	//Opracuj prezentacjê na temat:
	//"Z³o¿onoœæ algorytmów"
	//oceniam w dniu 29 wrzeœnia 2015
