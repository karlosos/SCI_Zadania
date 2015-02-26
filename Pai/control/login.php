<?php
//rozpoczęcie sesji
session_start();

//wczytanie konfiguracji
require_once __DIR__.'/../libs/configuration.php';

//odczyt tablicy GET lub POST
echo 'Wprowadzono w formularzu:<br>';
echo $_POST['form_login'];
echo '<br>';
echo $_POST['form_password'];
echo '<hr>';

if(
	$baza_login==$_POST['form_login']
	AND
	$baza_password==$_POST['form_password']
)
	{
	//co robimy jeśli prawda
	echo "Jest supEEEr!";
	$_SESSION['status']=true;
        $_SESSION['imie']="Admin";
        $_SESSION['nazwisko']="Administrator";
	}
else
	{
	//co robimy jeśli nieprawda, czyli fałsz
	echo "Jest źle, bardzo źle...";
	$_SESSION['status']=false;
	}		

//sprawdźmy czy użytkownik zaznaczył pole "Zapamiętaj mnie na tym komputerze" oraz podejmujemy stosowną akcję
if ($_POST['form_save']=='on'){
	echo 'Zaznaczono zapamiętanie';
}	
else {
	echo 'NIE Zaznaczono zapamiętania';
}	
	
	
header("Location: ../index.php");
echo '<a href="index.php">Powrót do strony głównej</a>';



?>