<?php
/**
 * Klasa nauczyciela
 * 
 * Klasa pochodna klasy osoba
 *
 * @author Karol Działowski
 */
class nauczyciel extends osoba {
    private $przedmiot;
    
    /**
     * Konstruktor
     * 
     * @param string $name
     * @param string $surname
     * @param int $pesel
     * @param string $przedmiot
     */
    public function __construct($name, $surname, $pesel, $przedmiot) {
        parent::__construct($name, $surname, $pesel);
        $this->przedmiot = $przedmiot;
    }

    /**
     * Destruktor
     */
    public function __destruct() {
        parent::__destruct();
    }
    
    /**
     * Metoda dodaje ocenę, nie wymaga super tajnego hasła
     * 
     * @param string $uczen
     * @param int $ocena
     */
    public function dodajOcene($uczen, $ocena) {
        $uczen->dodajOcene($this->przedmiot, $ocena, "4b202fdf140b0d9fdf60af5b84b72a002e9df685");
    }

}
