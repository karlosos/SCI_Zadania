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
//DO ZROBIENIA: odczyt z pliku 
/*do wykorzystania:
fopen
fread
list
explode
fgetcsv()
*/


		

//sprawdźmy czy użytkownik zaznaczył pole "Zapamiętaj mnie na tym komputerze" oraz podejmujemy stosowną akcję
if ($_POST['form_save']=='on'){
	echo 'Zaznaczono zapamiętanie';
}	
else {
	echo 'NIE Zaznaczono zapamiętania';
}	
//header("Location: index.php");
echo '<hr><table border="1">';	
//wskazanie pliku do otworzenia
$plik = ROOT_PATH."/passwords.csv";
$dane2 = fopen($plik,"r");
$dane = file($plik);
//var_dump($dane1);
//var_dump($dane);
foreach($dane as $linia){
	//var_dump($linia);	
	list($id,$baza_login,$baza_password,$im,$naz)=explode(";",$linia);
	echo "<tr><td>$id</td><td>$baza_login</td><td>$baza_password</td><td>$im</td><td>$naz</td></tr>
	";
if(
	$baza_login==$_POST['form_login']
	AND
	$baza_password==$_POST['form_password']
)
	{
	//co robimy jeśli prawda
	//echo "Jest supEEEr!";
	$_SESSION['status']=true;
	$_SESSION['imie']=$im;
	$_SESSION['nazwisko']=$naz;
	}
else
	{
	//co robimy jeśli nieprawda, czyli fałsz
	//echo "Jest źle, bardzo źle...";
	//$_SESSION['status']=false;
	}
	
}




fclose($dane2);
?>
</table><hr><a href="../index.php">Powrót do strony głównej</a>

