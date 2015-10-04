<?php

function read_csv($filename) {
    $rows = array();
    
    foreach(file($filename, FILE_IGNORE_NEW_LINES) as $line) {  
     $rows[] = str_getcsv($line,";");
    }
    
    return $rows;
}