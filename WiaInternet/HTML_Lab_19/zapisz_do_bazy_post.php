<?php
    $a = $_POST['imie'];
    $b = $_POST['nazwisko'];

    $tablica = array();
    $tablica['msg'] = 'Wiadomosc POST. Witaj '.$a." ".$b; //przykładowe działanie 

	echo json_encode($tablica); //przekształcamy tablicę na zapis typu json
?>