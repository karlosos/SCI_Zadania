//  __________________________________
// | SCILibrary.cpp -  implementstion |
// | SCI - September 2015             |
// |__________________________________|

#include "SCILibrary.h"
#include <sstream>

//Funkcja zamienia liczb� z systemu dziesi�nego na system dw�jkowy
std::string DecToBin(int decimal)
{
	//zmienne pomocnicze lokalne
	int liczba = decimal;		//liczba, kt�r� zamieniamy - inicjujemy j� parametrem
	std::string binary = "";	//liczba binarna postaci ci�gu zer i jedynek,
								//kt�r� ta funkcja wygenruje - inicjujemy pustym
								//�a�cuchem

	//kosmetyka...
	if (liczba == 0)
		return "0";				//bo inaczej nie wejdziemy do p�tli while(...)

	//algorytm...

	while (liczba)						//dop�ki liczba jest r�na od zera
	{
		if (liczba % 2 == 0)			//je�li wyra�enie modulo zwraca 0
			binary = "0" + binary;		//do �a�cucha (tablica char) wstawiamy "0" - cyfr� zero
		else
			binary = "1" + binary;		//w przeciwnym wypadku  wstawiamy "1" - cyfr� zero
		liczba /= 2;					//dzielimy liczb� na dwa (system dw�jkowy)
	}
							
	return binary;
}

//Funkcja zamienia liczb� z systemu dw�jkowego na system dziesi�tny
int BinToDec(std::string & binary)
{
	//zmienne pomocnicze...
	int x;							//odczytany element �a�cucha zamieniony na zero lub jedenk�
	int power = 1;					//wyk�adnik pot�gowania
	int dlugosc = binary.length();	//wyliczamy d�ugo�� std::string binary
	int system = 2;					//operujemy na systemie dw�jkowym
	int result = 0;					//wyliczona liczba dziesi�tna, kt�r� zwraca ta fukcja

	//zaczynamy od ko�ca �a�cucha (tablicy)...
	for (int i = dlugosc - 1; i >= 0; i--)
	{
		if (binary[i] == '1') x = 1;
		if (binary[i] == '0') x = 0;
		result += x * power;		//do wyniku dodajemy otrzyman� warto��,
									//kt�r� mno�ymy przez podstaw� systemu
									//do odpowiedniej pot�gi
		power *= system;			//ustawiamy power (wyk�adnik) na odpowiedni� poteg� systemu (2)
	}
	return result;
}

//Funkcja zamienia liczb� z dowolnego systemu na system dziesi�tny
int AnyToDec(std::string & number_in_any_system, int system)
{
	int x;							//odczytany element �a�cucha
	int wynik = 0;					//warto��, kt�r� zwraca ta funkcja
	int power = 1;					//pot�ga
	int dlugosc = number_in_any_system.length();//wyliczamy d�ugo�� std::string binary

  //zaczynamy od ko�ca tablicy...
	for (int i = dlugosc - 1; i >= 0; i--)
	{
		//je�eli odczytany element �a�cucha jest cyfr�...
		if (number_in_any_system[i] >= '0' && number_in_any_system[i] <= '9')
			//odejmujemy kod zera - zamieniamy kod cyfry na cyfr�
			x = number_in_any_system[i] - '0';
		else
			//je�eli jest to litera (musi byc du�a)
			x = number_in_any_system[i] - 55;//to odejmujemy 55 np. A(65) - 55 = 10

		//do wyniku dodajemy otrzyman� warto��
		//pomno�on� przez podstaw� systemu do odpowiedniej pot�gi
		wynik += x  *power; 
		power *= system; // ustawiamy power(wyk�adnik) na odpowiedni� poteg� systemu
	}

	return wynik;

	//wi�cej:
	//http://www.algorytm.org/algorytmy-arytmetyczne/zamiana-z-i-na-system-dziesietny/systemy-2-c.html
}

//int dziesietna = 0;
//int w = 1;
//for (int i = 0; i < binarna.size(); ++i)
//{
//	if (binarna[i] == '1')
//		dziesietna += w;
//	w <<= 1;     // to samo co mnoznik = mnoznik*2, ale szybsze
//}

//uwagi:
//Funkcja jest tylko propzycj� rozwi�zania.
//Wiedz� na temat system�w liczb trzeba gruntownie opanowa�.
//

//Binary Search - implementacja
bool BinarySearch(int tab[], int tab_size, int value_searched)
{
	//zak�adamy, �e przeszukujemy tablic� w pe�nym zakresie
	//czyli ca�� tablic� od indeksu 0 do ostatniego elementu
	int l = 0;			//pocz�tek tablicy
	int r = tab_size;	//koniec tablicy
	int sr= (l + r)/2;	//indeks - wyliczany �rodek (miejsce) indeks
	bool result = false;//flaga okre�la, czy w tablicy znajduje si� szukana warto��
						//na pocz�tku zak�adamy, �e nie...

	std::cout << "Elementy tablicy:" << std::endl;

	for (int i = 0; i < tab_size; i++)
		std::cout << tab[i] << "  ";

		std::cout << std::endl;
		std::cout << std::endl;

		std::cout << "Szukamy w talicy wartosci: " << value_searched  << std::endl;


	while (l <= r)
	{
		sr = (l + r) / 2;//wyliczamy �rodek
		if (tab[sr] == value_searched)//je�li szukana jest w tablicy...
		{
			//mo�na o tym poinformowa�...
			std::cout << std::endl;
			std::cout << "znaleziono wartosc: "
				<< value_searched
				<< " pod indeksem: "
				<< sr
				<< std::endl
				<< std::endl;
			result = true;
		}
		if (tab[sr] > value_searched)
			r = sr - 1;
		else
			l = sr + 1;
	}

	if(!result)
		std::cout << "Nie znaleziono..." << std::endl;

	return result;
}

//Funkcja zamienia parametry
void Swap(int & a, int & b)
{
	int pom = a;	//zapami�tuj� a
	a = b;			//pod a przypisuj� b,
	b = pom;		//a pod b pom - zapami�tan� a
}

//Funkcja losuje liczb� z przedzia�u obustronnie domkni�tego
int Rand(int min, int max)
{
	//w poleceniu by�o: < 19, 31 >
	int pseudolosowa = ((rand() % (max - min + 1))) + (min);
	return pseudolosowa;//nasza cywilizacja ppotrafi za pomoc�
						//komputer�w generowa� tylko liczby
						//p s e u d o l o s o w e
}


//Funkcja zwraca flag�, czy rok jest przest�pny
bool checkYear(int year)
{
	//jest przest�pny wtedy i tylko wtedy gdy:
	//dzieli si� przez 4 i nie dzieli si� przez 100,
	//za wyj�tkiem lat podzielnych przez 400
	return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
}

//Funkcja przeszukuje liniowo tablic� i zwraca
bool LinearSearch(int tab[], int tab_size, int value_searched)
{
	for (int i = 0; i < tab_size; i++)
	if (tab[i] == value_searched)
		return true;//znaleziono
	return false;
}

//Funkcja konwertuje int na std::string
std::string IntToString(int value)
{
	std::stringstream bufor;//tutaj serializujemy bajt po bajcie cokolwiek
	std::string wynik;		//to jest liczone i zwracane
	bufor << value;//wysy�amy value do bufora
	bufor >> wynik;	//teraz z bufora przepisuje to co w nim jest
	return wynik;
}

//Funkcja zwraca PRAWID�OW� dat�, pseudolosow�, z podanego zakresu
std::string RandDate(int year_min, int year_max)
{
	int year = Rand(year_min, year_max);
	int month = Rand(1, 12);
	int day = 0;
	int months_w_31[7] = {1, 3, 5, 7, 8, 10, 12};

	if (month == 2) {
		if (checkYear(year)) {
			day = Rand(1,29);
		} else {
			day = Rand(1,28);
		}	
	} else if (BinarySearch(months_w_31, 7, month)){
		// tutaj albo 30 albo 31 narazie mi sie nie chce
		day = Rand(1, 31);
	} else {
		day = Rand(1, 30);
	}

	std::string year_s = IntToString(year);
	std::string month_s = "";
	if (month < 10) {
		month_s = "0" + IntToString(month);
	} else {
		month_s = IntToString(month);
	}

	std::string day_s = "";
	if (day < 10) {
		day_s = "0" + IntToString(day);
	} else {
		day_s = IntToString(day);
	}

	std::string output = year_s + "-" + month_s + "-" + day_s;

	//napisz na ocen�...na tej lekcji...(je�li b�dzie czas)
	//Example: "1998-04-23"

	return output;//Uwaga = jak b�dzie gotowe, to tutaj wstawi� to co trzeba

}

//Funkcja zwraca ilo�� cyfr liczby ca�kowitej
int IloscCyfrliczbyCalkowitej(int liczba)
{
	int ilosc_cyfr = 0;
	while (liczba != 0)
	{
		ilosc_cyfr++;
		liczba /= 10;
	}

	return ilosc_cyfr;
}

//Funkcja zwraca sum� cyfr liczby ca�kowitej
int SumaCyfrLiczbyCalkowitej(int liczba)
{
	int sumaCyfr = 0;

	while (liczba != 0)
	{
		sumaCyfr += liczba % 10;//akumulujemy sum� cyfr
		liczba /= 10;		//dzielimy liczb� przez 10 (system dziesi�tny)
	}
	return sumaCyfr;
}