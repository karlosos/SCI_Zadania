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
    
    $("#pokaz1").mouseenter(function() {
        $(this).stop().animate({
            height:200,
            width:300,
            opacity: 0.5
            }, 1000, 'linear');
    });
    
    $("#pokaz2").mouseenter(function() {
        $(this).stop().animate({
                opacity: 0.4,
                marginLeft: "0.6in",
                fontSize: "20px", 
                borderWidth: "10px"
            }, 1000, 'linear');
    });
    
    $("#pokaz3").mouseenter(function() {
        $(this).stop().animate({
                width: "200px"
            }, 1000, 'linear');
    });
    
    $(".pokaz").mouseleave(function() {
        $(this).stop().animate({
            width:100,
            height:200,
            opacity: 1,
            marginLeft: 0,
            borderWidth: "0px",
            fontSize: "10px"          
            }, 1000, 'linear');
    })
    
});