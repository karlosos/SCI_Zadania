<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
            require('./osoba.php');
            require('./uczen.php');
            require('./nauczyciel.php');
            require('./oceny.php');
            
            $karol = new uczen("Karol", "Dzialowski", 123123, 23213);
            $nauczyciel = new nauczyciel("Jakis", "Nauczyciel", 123123);
            
            echo $karol->getFullName();
            echo "<br> Dodajemy ocene chemii <br>";
            $karol->dodajOcene(chemia, 5, "tajne_haslo");
            $karol->dodajOcene(chemia, 3, "tajne_haslo");
            $karol->dodajOcene(chemia, 5, "tajne_haslo");
            $karol->dodajOcene(chemia, 5, "tajne_haslo");
            echo "Wyswietlamy oceny z chemii <br>";
            print_r($karol->getOceny(chemia));
        ?>
    </body>
</html>
