function validate(form) {
    var imie = form["imie_nazwisko"].value;
    var telefon = form["telefon"].value;
    var text_area = form["tresc_zapytania"].value;
    var errors = [];

    if (imie == '')
        errors.push('Puste pole imie i nazwisko');
    if (telefon.length <= 9)
        errors.push('Nieprawidlowy numer telefony');
    if (text_area.length > 500) {
        alert('Za długa treść zapytania.');
        errors.push('Za długa treść zapytania.');
    }
    if (errors.length == 0)
        return true;
    else
        alert(errors);
    return false;
}

function liczZnaki(text_area) {
    var text_area = text_area.value.length;
    document.forms["form_oferta"]["liczba_znakow"].value = text_area;
}

function typFundamentu() {
    var typ = document.forms["form_oferta"]["typ_fundamentu"].value;
    var x = document.getElementById("wymiary_fundamentu");

    if (typ == 'regularny') {
        x.style.display = 'block';
    }
    else if (typ = 'zlozony') {
        x.style.display = 'none';
    }
}
function odwierty(checkbox) {
    var x = document.getElementById("liczba_odwiertow");
    if (checkbox.checked)
        x.style.display = 'block';
    else
        x.style.display = 'none';
}
function pochylona(checkbox) {
    var x = document.getElementById("kat_dzialki");
    if (checkbox.checked)
        x.style.display = 'block';
    else
        x.style.display = 'none';
}

function pole() {
    var wymiar_a = document.forms["form_oferta"]["wymiar_a"].value;
    var wymiar_b = document.forms["form_oferta"]["wymiar_b"].value;
    var wynik = document.forms["form_oferta"]["pole_dzialki"];

    wynik.value = wymiar_a * wymiar_b;
}