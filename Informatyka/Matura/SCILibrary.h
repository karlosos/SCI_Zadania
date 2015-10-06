//  __________________________________
// | SCILibrary.h -  definition       |
// | SCI - September 2015             |
// |__________________________________|

#ifndef H_SCI_LIBRARY
#define H_SCI_LIBRARY

#include <iostream>
#include <string>

using namespace std;

///
///Funkcja zamienia liczb� z systemu dziesi�nego na system dw�jkowy
///
///@param decimal - liczba w systemie dziesi�tnym
///
std::string DecToBin(int decimal);

///
///Funkcja zamienia liczb� z systemu dw�jkowego na system dziesi�tny
///
///@param &binary - referencja na �a�cuch reprezentuj�cy liczb� dw�jkow�
///
int BinToDec(std::string & binary);

///
///Funkcja zamienia liczb� z dowolnego systemu na system dziesi�tny
///
///@param &number_in_any_system - referencja na �a�cuch reprezentuj�cy liczb� zapisan� w rozpatrywanym systemie
///
///@param system - system liczbowy
///
int AnyToDec(std::string & number_in_any_system, int system = 2);

///
///Funkcja zwraca (o ile taka istnieje) szukan� warto��
///Strategia "dziel i zwyci�aj - Wyszukiwanie binarne (ang. binary search)
///Przyk�ad bazuje na liczba ca�kowitych.
///Uwaga - bardzo wa�ne - wyszukiwanie binarne stosujemy tylko
///wobec zbior�w zawieraj�cych dane uporz�dkowane - np. tablica wcze�niej
///posortowana rosn�co.
///
///@param tab[] - tablica typu int zawieraj�ca uporz�dkowane dane
///
///@param tab_size - rozmiar tablicy
///
///@param value_searched - warto��, kt�rej szukamy
///
bool BinarySearch(int tab[], int tab_size, int value_searched);

///
///Funkcja zamienia parametry
///
///@param &a - referencja na a (pracujemy na oryginale)
///
///@param &b - referencja na b (pracujemy na oryginale)
///
void Swap(int & a, int & b);

///
///Funkcja losuje liczb� z przedzia�u obustronnie domkni�tego
///
///@param min - dolna warto�� zakresu
///
///@param max - g�rna warto�� zakresu
///
int Rand(int min, int max);


///
///Funkcja zwraca flag�, czy rok jest przest�pny
///
///@param year - rok
///
bool checkYear(int year);

///
///Funkcja przeszukuje liniowo tablic� i zwraca
///flag� true, gdy znajdzie w niej szukany element
///@param tab[] - tablica typu int zawieraj�ca uporz�dkowane dane
///
///@param tab_size - rozmiar tablicy
///
///@param value_searched - warto��, kt�rej szukamy
///
bool LinearSearch(int tab[], int tab_size, int value_searched);

///
///Funkcja konwertuje int na std::string
///
///@param value - warto�� int
///
std::string IntToString(int value);


//Temat:	2015-09-30
//Data i czas w programach

///
///Funkcja zwraca PRAWID�OW� dat�, pseudolosow�, z podanego zakresu
///
///Kalendarz Gregoria�ski
///format daty koniecznie: "YYYY-MM-DD"
///Year:	2015 => string
///Month:	8	 => string "08"
///Day		12	 => "12"
///Day		3	 => "03"
///Uwzgl�dniamy lata przest�pne
///
///@param year_min - dolny zakres roku
///
///@param year_max - g�rny zakres roku
///
std::string RandDate(int year_min, int year_max);

///
///Funkcja zwraca ilo�� cyfr liczby ca�kowitej
///
///@param liczba - ilo�� cyfr liczby ca�kowitej
///
int IloscCyfrliczbyCalkowitej(int liczba);

///
///Funkcja zwraca sum� cyfr liczby ca�kowitej
///
///@param liczba - liczba
///
int SumaCyfrLiczbyCalkowitej(int liczba);


#endif//H_SCI_LIBRARY