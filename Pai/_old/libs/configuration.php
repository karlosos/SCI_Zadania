<?php
define('ROOT_PATH', realpath(__DIR__.'/../'));

require_once ROOT_PATH.'/control/HttpRequestHeaderProcesser.php';
require_once ROOT_PATH.'/control/PageLoader.php';
require_once ROOT_PATH.'/control/csv.php';
include ROOT_PATH.'/libs/ChromePhp.php';

//plik konfiguracyjny
$szkola="SCI";
$tytulStrony="test";
$autor="JC";

//zdefiniowane login i hasło tylko do testów mechanizmu logowania
$baza_login="admin";
$baza_password="admin1";

if (!isset($_COOKIE['language'])) {
    $languages = getLanguage();
        setcookie ( 'language', $languages[0], time() + 60*60*24*30);
}
?>