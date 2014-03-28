<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of osoba
 *
 * @author KarolL
 */
class osoba {

    private $name;
    private $surname;
    private $pesel;

    public function __construct($name, $surname, $pesel) {
        $this->name = $name;
        $this->surname = $surname;
        $this->pesel = $pesel;
    }

    public function __destruct(){
        $this->name = "";
        $this->surname = "";
        $this->pesel = "";
   }
   
    public function setFullName($name, $surname) {
        $this->name = $name;
        $this->surname = $surname;
        echo "Dodano imie i nazwisko";
    }

    public function getFullName() {
        return $this->name . ' ' . $this->surname;
    }

    public function getPesel() {
        return $this->pesel;
    }

}
