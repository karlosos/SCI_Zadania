#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main(void)
{
	std::fstream input_file;
	std::fstream output_file;

	input_file.open("names.txt", std::ios::in);
	output_file.open("names_s.txt", std::ios::out);
	
	bool test = input_file.good();
	
	std::string napis;
	std::vector<std::string> imiona;
	std::vector<std::string> imiona_na_s;

	while (!input_file.eof())
	{
		std::getline(input_file, napis);
		imiona.push_back(napis);
	}

	for (int i = 0; i < imiona.size(); i++)
	{
		if (imiona[i].size() > 0)
		{
			char pierwsza = imiona[i].at(0);
			if (pierwsza == 'S')
			{
				imiona_na_s.push_back(imiona[i]);
				output_file << imiona[i] << std::endl;
			}
		}
	}

	std::cout << imiona_na_s.size();
	std::system("pause");
	input_file.close();
	output_file.close();

	return 0;

	//Napisz kod, ktory zapisze do pliku tylko te imiona ktore rozpoczynaja sie na litere S oraz wypisze na konsoli ile takich imion spelnia ten warunek
}
