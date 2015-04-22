/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function show () {
    $("#zad1").show('slow');
}

function hide () {
    $("#zad1").hide('slow');
}

function fadeOut () {
    $("#zad1").fadeOut('slow');
}

function fadeTo () {
    $("#zad1").fadeTo('slow', 0.5);
}

function slideDown () {
    $("#zad1").slideDown('slow');
}

function slideUp () {
    $("#zad1").slideUp('slow');
}

function slideToggle () {
    $("#zad1").slideToggle('slow');
}

$(document).ready(function() {
    $("#text").hide();
    $("#zad2").mouseenter(function() {
        $("#zad2").stop(true).animate({width:200}, 500);
        $("#text").stop(true).fadeIn('slow');
    })
    
    $("#zad2").mouseleave(function() {
        $("#zad2").stop(true).animate({width:50}, 500);
        $("#text").stop(true).fadeOut('slow');
    })
    
    
});