<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Description of nauczyciel
 *
 * @author KarolL
 */
class nauczyciel extends osoba {

    public function __construct($name, $surname, $pesel) {
        parent::__construct($name, $surname, $pesel);
    }

    public function __destruct() {
        parent::__destruct();
    }

}
