<?php
//rozpocz�cie sesji
session_start();

echo '<hr>Wynik przed session_destroy';

//skasowanie ciasteczka z id sesji
var_dump($_COOKIE);echo '<br>';
var_dump($_SESSION);


echo '<hr>cookie destroy';
setcookie("PHPSESSID", null, time()-3600*365);
echo '<hr>session_destroy';
$_SESSION['PHPSESSID']=null;//skasowanie id sesji je�li mo�na
session_destroy();//zako�czenie sesji

echo '<hr>Wynik po session_destroy';
var_dump($_COOKIE);echo '<br>';
var_dump($_SESSION);

header("Location: ../index.php");
echo '<a href="index.php">Powr�t do strony g��wnej</a>';
?>