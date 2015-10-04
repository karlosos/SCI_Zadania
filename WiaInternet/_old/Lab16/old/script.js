$(document).ready(function() {
	$("#facebook").mouseleave(function() {
		$("#text").stop().animate({width:0}, 500);
	});

	$("#facebook").mouseenter(function() {
		$("#text").stop().animate({width:150}, 500);
	});

	
});

function show() {
	$("#main").show('slow');
}

function hide() {
	$("#main").hide('slow');
}

function fadeOut() {
	$("#main").fadeOut('slow');
}

function fadeTo() {
	$("#main").fadeTo('slow', 0.25);
}

function slideUp() {
	$("#main").slideUp('slow');
}

function slideDown() {
	$("#main").slideDown('slow');
}

function slideToggle() {
	$("#main").slideToggle('slow');
}
