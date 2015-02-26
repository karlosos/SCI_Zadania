<?php
function loadPage($id, $lang) {
        // To można opakować do funkcji
        $plik = ROOT_PATH."/pages/" . $lang . "_" . $id . ".php";
        if (file_exists($plik)) {
            include $plik;
            return true;
        } else {
            echo $plik;
            return false;
        }
}