<!DOCTYPE html>
<!--
Karol Działowski
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        /**
         * Funkcja wyświetla ładnie oceny
         * 
         * @param array $oceny
         * @return string
         */
        function wyswietl_oceny($oceny) {
            return '<ul><li>' . implode('</li><li>', $oceny) . '</li></ul>';
        }
        
        // Wymagamy wszystkich plików z klasami
        require('osoba.php');
        require('uczen.php');
        require('nauczyciel.php');
        require('oceny.php');

        // Tworzymy nowe obiekty
        $karol = new uczen("Karol", "Dzialowski", 123123, 23213);
        $nauczyciel_chemii = new nauczyciel("Jakis", "Nauczyciel", 123123, "chemia");
        $nauczyciel_biologii = new nauczyciel("Inny", "Nauczyciel", 432432, "biologia");

        // Testujemy funkcjonalność
        echo "<i> Dodajemy ocenę chemii i biologii </i> <br>";
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 5);
        $nauczyciel_chemii->dodajOcene($karol, 4);

        $nauczyciel_biologii->dodajOcene($karol, 2);
        $nauczyciel_biologii->dodajOcene($karol, 4);
        $nauczyciel_biologii->dodajOcene($karol, 5);
        $nauczyciel_biologii->dodajOcene($karol, 1);
        $nauczyciel_biologii->dodajOcene($karol, 3);

        echo "<b>Wyswietlamy oceny z chemii</b> <br>";
        echo wyswietl_oceny($karol->getOceny(chemia));
        echo "<br> <b> Wyswietlamy oceny z biologii </b><br>";
        echo wyswietl_oceny($karol->getOceny(biologia));
        echo "<br> <b>Wyswietlamy średnią ocen chemii:</b> ";
        echo $karol->getSrednia(chemia);
        echo "<br> <b>Wyswietlamy średnią ocen biologii:</b> ";
        echo $karol->getSrednia(biologia);
        ?>
    </body>
</html>
