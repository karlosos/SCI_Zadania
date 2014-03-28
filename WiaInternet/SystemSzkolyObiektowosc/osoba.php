<?php
/**
 * Klasa osoby
 * 
 * Klasa bazowa dla klasy nauczyciel i uczen
 *
 * @author Karol Działowski
 */
class osoba {

    // Pola prywatne
    private $name;
    private $surname;
    private $pesel;

    /**
     * Konstruktor
     * 
     * @param string $name
     * @param string $surname
     * @param int $pesel
     */
    public function __construct($name, $surname, $pesel) {
        $this->name = $name;
        $this->surname = $surname;
        $this->pesel = $pesel;
    }

    /**
     * Destruktor
     */
    public function __destruct(){
        $this->name = "";
        $this->surname = "";
        $this->pesel = "";
   }
   
   /**
    * Zmien imie i nazwisko
    * 
    * @param string $name
    * @param string $surname
    */
    public function setFullName($name, $surname) {
        $this->name = $name;
        $this->surname = $surname;
        echo "Dodano imie i nazwisko";
    }

    /**
     * Zwróć imię i nazwisko
     * 
     * @return string
     */
    public function getFullName() {
        return $this->name . ' ' . $this->surname;
    }

    /**
     * Zwróć pesel
     * 
     * @return int
     */
    public function getPesel() {
        return $this->pesel;
    }

}
