#ifndef FILES_H
#define FILES_H

///
/// Tworzy logi
///
void create_log(string date) {
	string file_name = date + "_log.txt";
	std::wstring w_file_name(file_name.begin(), file_name.end());
	std::ofstream o_file (file_name, std::ofstream::out);
	o_file << "Starting: " + date + "\n";
	o_file.close();

	log_name = file_name;
}


void close_log(string date) {
	std::ofstream out;
	out.open(log_name, std::ios::app);
	out << "End at: " + date;
	out.close();
}

///
/// Tworzy poczatek dokumentu html
///
void create_html(string file_name) {
	//Output file
	file_name = file_name + ".html";
	std::wstring w_file_name(file_name.begin(), file_name.end());
	std::ofstream o_file (file_name, std::ofstream::out);
	string html = "<html>\n<head>\n <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"> \n <meta http-equiv=\"refresh\" content=\"2\"/>\n<title>Words</title>\n</head>\n<body>\n<table border=\"1\">\n<tr id=\"head\">\n<th>Keyword</th>\n<th>Weight</th>\n<th>Type</th>\n<th>Scope</th>\n<th>Synonym</th>\n</tr>\n";
	o_file << html;
	o_file.close();
	ShellExecute(NULL, L"open", w_file_name.c_str(), NULL, NULL, SW_SHOWNORMAL);
}

///
/// Tworzy poczatek dokumentu html dla zadania 1
///
void create_html_old(string file_name) {
	//Output file
	file_name = file_name + ".html";
	std::wstring w_file_name(file_name.begin(), file_name.end());
	std::ofstream o_file (file_name, std::ofstream::out);
	string html = "<html>\n<head>\n <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"> \n <meta http-equiv=\"refresh\" content=\"2\"/>\n<title>Words</title>\n</head>\n<body>\n<table border=\"1\">\n<tr id=\"head\">\n<th>Keyword</th>\n<th>Weight</th>\n<th>Scope</th>\n<th>Synonym</th>\n</tr>\n";
	o_file << html;
	o_file.close();
	ShellExecute(NULL, L"open", w_file_name.c_str(), NULL, NULL, SW_SHOWNORMAL);
}

///
/// Tworzy poczatek dokumentu xml
///
void create_xml(string file_name) {
	//Output file
	file_name = file_name + ".xml";
	std::ofstream o_file (file_name, std::ofstream::out);
	string xml = "<?xml version=\"1.0\" ?>\n \t<dictionary>\n";
	o_file << xml;
	o_file.close();
}

///
/// Tworzy domkniecia w dokumencie html
///
void close_html(string file_name) {
	std::ofstream out;
	file_name = file_name + ".html";
	out.open(file_name, std::ios::app);
	string html_end = "<div id=\"end\"> </div> </body>\n </html>";
	out << html_end;
	out.close();
}

///
/// Tworzy domkniecia w dokumencie xml
///
void close_xml(string file_name) {
	std::ofstream out;
	file_name = file_name + ".xml";
	out.open(file_name, std::ios::app);
	string xml = "</dictionary>";
	out << xml;
	out.close();
}

#endif //FILES_H