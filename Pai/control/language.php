<?php

if(isset($_GET['l'])) {
    $lang = $_GET["l"];
    setcookie ( 'language', $lang, time() + 60*60*24*30, "/pai");
}

header('Location: ' . $_SERVER['HTTP_REFERER']);