//  __________________________________
// | SCILibrary.cpp -  implementstion |
// | SCI - September 2015             |
// |__________________________________|

#include "SCILibrary.h"
#include <sstream>

//Funkcja zamienia liczbê z systemu dziesiênego na system dwójkowy
std::string DecToBin(int decimal)
{
	//zmienne pomocnicze lokalne
	int liczba = decimal;		//liczba, któr¹ zamieniamy - inicjujemy j¹ parametrem
	std::string binary = "";	//liczba binarna postaci ci¹gu zer i jedynek,
								//któr¹ ta funkcja wygenruje - inicjujemy pustym
								//³añcuchem

	//kosmetyka...
	if (liczba == 0)
		return "0";				//bo inaczej nie wejdziemy do pêtli while(...)

	//algorytm...

	while (liczba)						//dopóki liczba jest ró¿na od zera
	{
		if (liczba % 2 == 0)			//jeœli wyra¿enie modulo zwraca 0
			binary = "0" + binary;		//do ³añcucha (tablica char) wstawiamy "0" - cyfrê zero
		else
			binary = "1" + binary;		//w przeciwnym wypadku  wstawiamy "1" - cyfrê zero
		liczba /= 2;					//dzielimy liczbê na dwa (system dwójkowy)
	}
							
	return binary;
}

//Funkcja zamienia liczbê z systemu dwójkowego na system dziesiêtny
int BinToDec(std::string & binary)
{
	//zmienne pomocnicze...
	int x;							//odczytany element ³añcucha zamieniony na zero lub jedenkê
	int power = 1;					//wyk³adnik potêgowania
	int dlugosc = binary.length();	//wyliczamy d³ugoœæ std::string binary
	int system = 2;					//operujemy na systemie dwójkowym
	int result = 0;					//wyliczona liczba dziesiêtna, któr¹ zwraca ta fukcja

	//zaczynamy od koñca ³añcucha (tablicy)...
	for (int i = dlugosc - 1; i >= 0; i--)
	{
		if (binary[i] == '1') x = 1;
		if (binary[i] == '0') x = 0;
		result += x * power;		//do wyniku dodajemy otrzyman¹ wartoœæ,
									//któr¹ mno¿ymy przez podstawê systemu
									//do odpowiedniej potêgi
		power *= system;			//ustawiamy power (wyk³adnik) na odpowiedni¹ potegê systemu (2)
	}
	return result;
}

//Funkcja zamienia liczbê z dowolnego systemu na system dziesiêtny
int AnyToDec(std::string & number_in_any_system, int system)
{
	int x;							//odczytany element ³añcucha
	int wynik = 0;					//wartoœæ, któr¹ zwraca ta funkcja
	int power = 1;					//potêga
	int dlugosc = number_in_any_system.length();//wyliczamy d³ugoœæ std::string binary

  //zaczynamy od koñca tablicy...
	for (int i = dlugosc - 1; i >= 0; i--)
	{
		//je¿eli odczytany element ³añcucha jest cyfr¹...
		if (number_in_any_system[i] >= '0' && number_in_any_system[i] <= '9')
			//odejmujemy kod zera - zamieniamy kod cyfry na cyfrê
			x = number_in_any_system[i] - '0';
		else
			//je¿eli jest to litera (musi byc du¿a)
			x = number_in_any_system[i] - 55;//to odejmujemy 55 np. A(65) - 55 = 10

		//do wyniku dodajemy otrzyman¹ wartoœæ
		//pomno¿on¹ przez podstawê systemu do odpowiedniej potêgi
		wynik += x  *power; 
		power *= system; // ustawiamy power(wyk³adnik) na odpowiedni¹ potegê systemu
	}

	return wynik;

	//wiêcej:
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
//Funkcja jest tylko propzycj¹ rozwi¹zania.
//Wiedzê na temat systemów liczb trzeba gruntownie opanowaæ.
//

//Binary Search - implementacja
bool BinarySearch(int tab[], int tab_size, int value_searched)
{
	//zak³adamy, ¿e przeszukujemy tablicê w pe³nym zakresie
	//czyli ca³¹ tablicê od indeksu 0 do ostatniego elementu
	int l = 0;			//pocz¹tek tablicy
	int r = tab_size;	//koniec tablicy
	int sr= (l + r)/2;	//indeks - wyliczany œrodek (miejsce) indeks
	bool result = false;//flaga okreœla, czy w tablicy znajduje siê szukana wartoœæ
						//na pocz¹tku zak³adamy, ¿e nie...

	std::cout << "Elementy tablicy:" << std::endl;

	for (int i = 0; i < tab_size; i++)
		std::cout << tab[i] << "  ";

		std::cout << std::endl;
		std::cout << std::endl;

		std::cout << "Szukamy w talicy wartosci: " << value_searched  << std::endl;


	while (l <= r)
	{
		sr = (l + r) / 2;//wyliczamy œrodek
		if (tab[sr] == value_searched)//jeœli szukana jest w tablicy...
		{
			//mo¿na o tym poinformowaæ...
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
	int pom = a;	//zapamiêtujê a
	a = b;			//pod a przypisujê b,
	b = pom;		//a pod b pom - zapamiêtan¹ a
}

//Funkcja losuje liczbê z przedzia³u obustronnie domkniêtego
int Rand(int min, int max)
{
	//w poleceniu by³o: < 19, 31 >
	int pseudolosowa = ((rand() % (max - min + 1))) + (min);
	return pseudolosowa;//nasza cywilizacja ppotrafi za pomoc¹
						//komputerów generowaæ tylko liczby
						//p s e u d o l o s o w e
}


//Funkcja zwraca flagê, czy rok jest przestêpny
bool checkYear(int year)
{
	//jest przestêpny wtedy i tylko wtedy gdy:
	//dzieli siê przez 4 i nie dzieli siê przez 100,
	//za wyj¹tkiem lat podzielnych przez 400
	return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
}

//Funkcja przeszukuje liniowo tablicê i zwraca
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
	bufor << value;//wysy³amy value do bufora
	bufor >> wynik;	//teraz z bufora przepisuje to co w nim jest
	return wynik;
}

//Funkcja zwraca PRAWID£OW¥ datê, pseudolosow¹, z podanego zakresu
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

	//napisz na ocenê...na tej lekcji...(jeœli bêdzie czas)
	//Example: "1998-04-23"

	return output;//Uwaga = jak bêdzie gotowe, to tutaj wstawiæ to co trzeba

}

//Funkcja zwraca iloœæ cyfr liczby ca³kowitej
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

//Funkcja zwraca sumê cyfr liczby ca³kowitej
int SumaCyfrLiczbyCalkowitej(int liczba)
{
	int sumaCyfr = 0;

	while (liczba != 0)
	{
		sumaCyfr += liczba % 10;//akumulujemy sumê cyfr
		liczba /= 10;		//dzielimy liczbê przez 10 (system dziesiêtny)
	}
	return sumaCyfr;
}