function pierwszyKlik() {
		alert("Pierwszy klik")
}

function kolorowanieStrony() {
	document.body.style.backgroundColor = "green";
}

function miasto() {
	alert(document.getElementById("miasto").value);
}

function zamien() {
	var temp = document.getElementById("zmienna_a").value;
	document.getElementById("zmienna_a").value = document.getElementById("zmienna_b").value
	document.getElementById("zmienna_b").value = temp;
}

function dodaj() {
	var zmienna_1 = parseInt(document.getElementById("zmienna_1").value);
	var zmienna_2 = parseInt(document.getElementById("zmienna_2").value);
	var suma = zmienna_1 + zmienna_2;
	var rozwiazanie = document.getElementById("rozwiazanie");
	rozwiazanie.value = suma;
}

function okienko() {
	window.open('okienko.html', 'Polskie okienko', "height=200,width=200");
}