#ifndef DOWNLOADING_H
#define DOWNLOADING_H

#include "saving.h"
///
/// pobiera plik z wordnika
///
/// @param string word - slowo dla ktorego pobieramy plik
///
void download_wordnik(string word) {
		string log_word = word;
		std::wstring w_word(word.begin(), word.end());
		std::wstring url = std::wstring(TEXT("https://www.wordnik.com/words/")) + w_word + TEXT("/");
		TCHAR currentpath[MAX_PATH];
		GetCurrentDirectory(MAX_PATH, currentpath);
		std::wstring path = std::wstring(currentpath) + TEXT("\\wordnik\\") + w_word + TEXT(".txt");
		HRESULT res = URLDownloadToFile(NULL, url.c_str(), path.c_str(), 0, NULL);
 
        // Checking download
        if(res == S_OK) {
                //printf("Ok\n");
        } else if(res == E_OUTOFMEMORY) {
                printf("Buffer length invalid, or insufficient memory\n");
				save_log("Buffer length invalid, or insufficient memory for word: " + log_word, currentDateTime());
        } else if(res == INET_E_DOWNLOAD_FAILURE) {
                printf("URL is invalid\n");
				save_log("URL is invalid for word: " + log_word, currentDateTime());
        } else {
                printf("Other error: %d\n", res);
				save_log("Other error for word: " + log_word, currentDateTime());
        }

		//cout << "Download wordnik: " << word << endl;
}

///
/// pobiera plik z thesaurusa
///
/// @param string word - slowo dla ktorego pobieramy plik
///
void download_thesaurus(string word) {
		string log_word = word;
		std::wstring w_word(word.begin(), word.end());
		std::wstring url = std::wstring(TEXT("http://thesaurus.com/browse/")) + w_word + TEXT("/");
		TCHAR currentpath[MAX_PATH];
		GetCurrentDirectory(MAX_PATH, currentpath);
		std::wstring path = std::wstring(currentpath) + TEXT("\\thesaurus\\") + w_word + TEXT(".txt");
		HRESULT res = URLDownloadToFile(NULL, url.c_str(), path.c_str(), 0, NULL);
 
        // Checking download
        if(res == S_OK) {
                //printf("Ok\n");
        } else if(res == E_OUTOFMEMORY) {
                printf("Buffer length invalid, or insufficient memory\n");
				save_log("Buffer length invalid, or insufficient memory for word: " + log_word, currentDateTime());
        } else if(res == INET_E_DOWNLOAD_FAILURE) {
                printf("URL is invalid\n");
				save_log("URL is invalid for word: " + log_word, currentDateTime());
        } else {
                printf("Other error: %d\n", res);
				save_log("Other error for word: " + log_word, currentDateTime());
        }

		//cout << "Download wordnik: " << word << endl;
}
 
///
/// pobiera plik z wordnetcode
///
void download_wordnetcode() {
	string log_word = "wordnetcode";
    TCHAR url[] = TEXT("http://wordnetcode.princeton.edu/standoff-files/core-wordnet.txt");
    printf("Url: %S\n", url);
    TCHAR path[MAX_PATH];
    GetCurrentDirectory(MAX_PATH, path);
    wsprintf(path, TEXT("%s\\wordnetcode.txt"), path);
    printf("Path: %S\n", path);
    HRESULT res = URLDownloadToFile(NULL, url, path, 0, NULL);
 
        // Checking download
        if(res == S_OK) {
                //printf("Ok\n");
        } else if(res == E_OUTOFMEMORY) {
                printf("Buffer length invalid, or insufficient memory\n");
				save_log("Buffer length invalid, or insufficient memory for file: " + log_word, currentDateTime());
        } else if(res == INET_E_DOWNLOAD_FAILURE) {
                printf("URL is invalid\n");
				save_log("URL is invalid for file: " + log_word, currentDateTime());
        } else {
                printf("Other error: %d\n", res);
				save_log("Other error for file: " + log_word, currentDateTime());
        }
}

///
/// pobiera plik z wiktionary
///
void download_wiktionary() {   
	string log_word = "wiktionary";
    TCHAR url[] = TEXT("http://en.wiktionary.org/wiki/Wiktionary:All_Wikisaurus_pages");
    printf("Url: %S\n", url);
    TCHAR path[MAX_PATH];
    GetCurrentDirectory(MAX_PATH, path);
    wsprintf(path, TEXT("%s\\wiktionary.txt"), path);
    printf("Path: %S\n", path);
    HRESULT res = URLDownloadToFile(NULL, url, path, 0, NULL);
 
        // Checking download
        if(res == S_OK) {
                //printf("Ok\n");
        } else if(res == E_OUTOFMEMORY) {
                printf("Buffer length invalid, or insufficient memory\n");
				save_log("Buffer length invalid, or insufficient memory for file: " + log_word, currentDateTime());
        } else if(res == INET_E_DOWNLOAD_FAILURE) {
                printf("URL is invalid\n");
				save_log("URL is invalid for file: " + log_word, currentDateTime());
        } else {
                printf("Other error: %d\n", res);
				save_log("Other error for file: " + log_word, currentDateTime());
        }

}
#endif //DOWNLOADING_H