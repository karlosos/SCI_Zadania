<?php
    $a = $_GET['imie'];
    $b = $_GET['nazwisko'];

    $tablica = array();
    $tablica['msg'] = 'Wiadomosc GET. Witaj '.$a." ".$b; //przykładowe działanie 

	echo json_encode($tablica); //przekształcamy tablicę na zapis typu json
?>