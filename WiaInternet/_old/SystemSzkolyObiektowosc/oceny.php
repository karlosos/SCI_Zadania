<?php
/**
 * Klasa ocen
 * 
 * Obiekt klasy oceny tworzony jest w konstruktorze klasy uczeń
 *
 * @author Karol Działowski
 */
class oceny {
    // Lista przedmiotów
    private $chemia = array();
    private $biologia = array();
    
    /**
     * Konstruktor
     */
    public function __construct() {
    }
    
    /**
     * Metoda zwraca oceny
     * 
     * @param string $przedmiot
     * @return array Tablica z ocenami
     */
    public function getOceny($przedmiot) {
        return $this->$przedmiot;
    }
    
    /**
     * Metoda zwraca średnią ocen
     * 
     * @param string $przedmiot
     * @return int
     */
    public function getSrednia($przedmiot) {
        $suma = 0;
        $liczba_ocen = 0;
        foreach ($this->$przedmiot as $value) {
            $suma += $value;
            $liczba_ocen++;
        }
       $srednia = $suma/$liczba_ocen;
        return $srednia;
        
    }
    
    /**
     * Metoda dodaje ocenę
     * 
     * Wymaga super tajnego hasła, aby uczniowie nie dodawali ocen
     * 
     * @param string $przedmiot
     * @param int $ocena
     * @param string $haslo
     */
    public function dodajOcene($przedmiot, $ocena, $haslo) {
        if($haslo == "4b202fdf140b0d9fdf60af5b84b72a002e9df685") {
            if($przedmiot == "chemia") {
                $this->chemia[] = $ocena;
            } else if($przedmiot == "biologia" ) {
                $this->biologia[] = $ocena;
            }
        } else
            echo "Policja już po ciebie jedzie!";
    }
}
