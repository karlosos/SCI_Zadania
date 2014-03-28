<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of oceny
 *
 * @author KarolL
 */
class oceny {
    private $chemia = array();
    private $biologia = array();
    
    public function __construct() {
    }
    
    public function getOceny($przedmiot) {
        return $this->$przedmiot;
    }
    
    public function dodajOcene($przedmiot, $ocena, $haslo) {
        if($haslo == "tajne_haslo") {
            if($przedmiot = "chemia") {
                $this->chemia[] = $ocena;
            } else if($przedmiot = "biologia" ) {
                $this->biologia[] = $ocena;
            }
        }
    }
}
