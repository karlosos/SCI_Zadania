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
///Funkcja zamienia liczbê z systemu dziesiênego na system dwójkowy
///
///@param decimal - liczba w systemie dziesiêtnym
///
std::string DecToBin(int decimal);

///
///Funkcja zamienia liczbê z systemu dwójkowego na system dziesiêtny
///
///@param &binary - referencja na ³añcuch reprezentuj¹cy liczbê dwójkow¹
///
int BinToDec(std::string & binary);

///
///Funkcja zamienia liczbê z dowolnego systemu na system dziesiêtny
///
///@param &number_in_any_system - referencja na ³añcuch reprezentuj¹cy liczbê zapisan¹ w rozpatrywanym systemie
///
///@param system - system liczbowy
///
int AnyToDec(std::string & number_in_any_system, int system = 2);

///
///Funkcja zwraca (o ile taka istnieje) szukan¹ wartoœæ
///Strategia "dziel i zwyciê¿aj - Wyszukiwanie binarne (ang. binary search)
///Przyk³ad bazuje na liczba ca³kowitych.
///Uwaga - bardzo wa¿ne - wyszukiwanie binarne stosujemy tylko
///wobec zbiorów zawieraj¹cych dane uporz¹dkowane - np. tablica wczeœniej
///posortowana rosn¹co.
///
///@param tab[] - tablica typu int zawieraj¹ca uporz¹dkowane dane
///
///@param tab_size - rozmiar tablicy
///
///@param value_searched - wartoœæ, której szukamy
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
///Funkcja losuje liczbê z przedzia³u obustronnie domkniêtego
///
///@param min - dolna wartoœæ zakresu
///
///@param max - górna wartoœæ zakresu
///
int Rand(int min, int max);


///
///Funkcja zwraca flagê, czy rok jest przestêpny
///
///@param year - rok
///
bool checkYear(int year);

///
///Funkcja przeszukuje liniowo tablicê i zwraca
///flagê true, gdy znajdzie w niej szukany element
///@param tab[] - tablica typu int zawieraj¹ca uporz¹dkowane dane
///
///@param tab_size - rozmiar tablicy
///
///@param value_searched - wartoœæ, której szukamy
///
bool LinearSearch(int tab[], int tab_size, int value_searched);

///
///Funkcja konwertuje int na std::string
///
///@param value - wartoœæ int
///
std::string IntToString(int value);


//Temat:	2015-09-30
//Data i czas w programach

///
///Funkcja zwraca PRAWID£OW¥ datê, pseudolosow¹, z podanego zakresu
///
///Kalendarz Gregoriañski
///format daty koniecznie: "YYYY-MM-DD"
///Year:	2015 => string
///Month:	8	 => string "08"
///Day		12	 => "12"
///Day		3	 => "03"
///Uwzglêdniamy lata przestêpne
///
///@param year_min - dolny zakres roku
///
///@param year_max - górny zakres roku
///
std::string RandDate(int year_min, int year_max);

///
///Funkcja zwraca iloœæ cyfr liczby ca³kowitej
///
///@param liczba - iloœæ cyfr liczby ca³kowitej
///
int IloscCyfrliczbyCalkowitej(int liczba);

///
///Funkcja zwraca sumê cyfr liczby ca³kowitej
///
///@param liczba - liczba
///
int SumaCyfrLiczbyCalkowitej(int liczba);


#endif//H_SCI_LIBRARY