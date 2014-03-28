<?php
/**
 * Klasa uczeń
 * 
 * Klasa pochodna klasy osoba
 *
 * @author Karol Działowski
 */
class uczen extends osoba {
   
    // Pola prywatne
    private $nr_legit;
    private $oceny;

    /**
     * Konstruktor
     * 
     * @param string $name
     * @param string $surname
     * @param int $pesel
     * @param string $nr_legit
     */
    public function __construct($name, $surname, $pesel, $nr_legit) {
        parent::__construct($name, $surname, $pesel);
        $this->nr_legit = $nr_legit;
        $this->oceny = new Oceny;
    }

    /**
     * Destruktor
     */
    public function __destruct() {
        parent::__destruct();
        $this->nr_legit = "";
    }
    
    /**
     * Zwróć numer legitymacji
     * 
     * @return string
     */
    public function getNr_legit() {
        return $this->nr_legit;
    }
    
    /**
     * Zmień numer legitymacji
     * 
     * @param string$nr_legit
     */
    public function setNr_legit($nr_legit) {
        $this->nr_legit = $nr_legit;
        echo "Dodano nr legitymacji";
    }
    
    /**
     * Zwróć oceny
     * 
     * @param string $przedmiot
     * @return array
     */
    public function getOceny($przedmiot) {
        return $this->oceny->getOceny($przedmiot);
    }
    
    /**
     * Metoda zwraca średnią ocen
     * 
     * @param string $przedmiot
     * @return int
     */
    public function getSrednia($przedmiot) {
        return $this->oceny->getSrednia($przedmiot);
    }
    
    /**
     * Dodaj ocenę
     * 
     * Wymaga super tajnego hasła, więc jeżeli nie znasz go to nie dodasz
     * 
     * @param string $przedmiot
     * @param int $ocena
     * @param string $haslo
     */
    public function dodajOcene($przedmiot, $ocena, $haslo) {
            $this->oceny->dodajOcene($przedmiot, $ocena, $haslo);
    }
}
