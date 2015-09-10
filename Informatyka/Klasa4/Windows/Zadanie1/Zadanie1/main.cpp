#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main(void)
{
	std::fstream file_handle;
	file_handle.open("names.txt", std::ios::in);
	bool test = file_handle.good();
	std::string napis;
	std::vector<std::string> imiona;
	std::vector<std::string> imiona_na_s;

	while (!file_handle.eof())
	{
		std::getline(file_handle, napis);
		imiona.push_back(napis);
		//std::cout << napis.at(0) << std::endl;
	}

	for (int i = 0; i < imiona.size(); i++)
	{
		if (imiona[i].size() > 0)
		{
			char pierwsza = imiona[i].at(0);
			if (pierwsza == 'S')
			{
				imiona_na_s.push_back(imiona[i]);
				//std::cout << imiona[i] << std::endl;
			}
		}
	}

	std::cout << imiona_na_s.size();
	std::system("pause");
	file_handle.close();
	return 0;

	//Napisz kod, ktory zapisze do pliku tylko te imiona ktore rozpoczynaja sie na litere S oraz wypisze na konsoli ile takich imion spelnia ten warunek
}
