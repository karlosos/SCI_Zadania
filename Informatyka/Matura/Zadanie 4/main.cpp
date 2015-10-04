#include <iostream>
#include "SCILibrary.h"
#include <time.h>
#include <fstream>

int main() 
{
	srand((unsigned)time(NULL));
	std::fstream output_file;
	output_file.open("wynik.txt", std::ios::out);

	for (double i=0; i < 10000; i++) {
		std::string data = RandDate(1900, 2023);
		std::cout << data << std::endl;	
		output_file << data << std::endl;
	}

	return 0;
}