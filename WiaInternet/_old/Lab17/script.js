$(document).ready(function() {
    $(".submenu").slideUp();
    
    $(".dropdown").mouseenter(function() {
        //$(this).find('ul').css('visibility', 'visible');
        $(this).find('ul').slideDown();
         console.log("enter");
    });
    
    $(".dropdown").mouseleave(function() {
        //$(this).find('ul').css('visibility', 'hidden');
        $(this).find('ul').slideUp();
         console.log("leave");
    });
});