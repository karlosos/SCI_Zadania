#include "iostream"
#include "fstream"
#include "string"
#include "vector"

using namespace std;

int main(void)
{
  std::fstream file_handle;
  file_handle.open("names.txt", std::ios::in);
  bool test = file_handle.good();
  std::string napis;
  std::vector<std::string> imiona;
  
  while (!file_handle.eof())
    {
      std::getline(file_handle, napis);
      imiona.push_back(napis);
      //std::cout << napis << std::endl;
    }

  for (int i=0; i<imiona.size(); i++) 
    {
      std::cout << imiona[i] << std::endl;
    }

  file_handle.close();
    return 0;

    //Napisz kod, ktory zapisze do pliku tylko te imiona ktore rozpoczynaja sie na litere S oraz wypisze na konsoli ile takich imion spelnia ten warunek
}
