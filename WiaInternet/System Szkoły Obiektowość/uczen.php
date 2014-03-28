<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Description of uczen
 *
 * @author KarolL
 */
class uczen extends osoba {

    //put your code here
    private $nr_legit;
    private $oceny;

    public function __construct($name, $surname, $pesel, $nr_legit) {
        parent::__construct($name, $surname, $pesel);
        $this->nr_legit = $nr_legit;
        $this->oceny = new Oceny;
    }

    public function __destruct() {
        parent::__destruct();
        $this->nr_legit = "";
    }
    
    public function getNr_legit() {
        return $this->nr_legit;
    }
    
    public function setNr_legit($nr_legit) {
        $this->nr_legit = $nr_legit;
        echo "Dodano nr legitymacji";
    }
    
    public function getOceny($przedmiot) {
        return $this->oceny->getOceny($przedmiot);
    }
    
    public function dodajOcene($przedmiot, $ocena, $haslo) {
            $this->oceny->dodajOcene($przedmiot, $ocena, $haslo);
    }
}
