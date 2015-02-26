<?php

// Tworzymy tymczasowa tablicy w ktorej bedziemy
$langs_temp = array();
// Tworzymy finaln� tablic�
$langs_final = array(array());
$langs_alternative = array();

// Sprawdzamy czy mamy ustawion� zmienn� z nag��wka http
if (isset($_SERVER['HTTP_ACCEPT_LANGUAGE'])) {
	// Do naszej tymczasowej tablicy dodajemy podzielone stringi przez przecinek
	$langs_temp = explode(",", $_SERVER["HTTP_ACCEPT_LANGUAGE"]);
	// P�tla w kt�rej dzielimy poszczeg�lne pola przez srednik
	for($i=0; $i<sizeof($langs_temp); $i++) {
		// Tu wlasnie dzielimy te pola przez srednik i dodajemy do nowej tymczasowej tablicy
		$langs_temp_2 = explode(';', $langs_temp[$i]);
		// Dodajemy do finalnej tablicy w indeksie [$i][0] string z jezykiem
		$langs_final[$i][0] =  $langs_temp_2[0];
		// Jezeli nie jest ustawiona waga jezyka to wynosi ona 1
		if(!isset($langs_temp_2[1]))
			$langs_final[$i][1] = 1; 
		// Ustawiamy wage jezyka
		else
			$langs_final[$i][1] =  $langs_temp_2[1];
                
                $langs_alternative[] = substr($langs_temp_2[0], 0, 2);
	}
	
        
        $langs_alternative = array_unique($langs_alternative);
	// Wyswietlamy tablice
}

print_r($langs_alternative);