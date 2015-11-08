/**
 * Liczy pierwiastki funkcji kwadratowej
 *
 * Funkcja przyjmuje wartości liczbowe. Według dokumentu https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/MAX_SAFE_INTEGER
 * w języku Javascript największa dostępna liczba całkowita to 9007199254740991.
 * Możnaby użyć w funkcji testu wykorzystując metodę isSafeInteger() sprawdzając czy 
 * podane wartości są bezpieczne. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/isSafeInteger
 *
 * Funkcja zwraca tablicę dwuelementową z wartościami liczbowymi. Jeżeli liczona funkcja kwadratowa
 * ma tylko jedno rozwiązanie to wtedy dwa elementy w tablicy są jednakowe. W przypadku niepowodzenia
 * np. gdy a jest równe 0 (funkcja nie jest kwadratowa), lub wprowadzone argumenty nie są liczbami, funkcja zwraca wartośc false.
 * W przypadku gdy delta jest mniejsza od 0 i funkcja nie ma rozwiązań zwracana jest wartość null
 * 
 * @param  {Number} a Liczba A w wzorze na funkcję kwadratową
 * @param  {Number} b Liczba B w wzorze na funkcję kwadratową
 * @param  {Number} c Liczba C w wzorze na funkcję kwadratową
 * @return {Number[]}   Pierwiastki funkcji w postaci tablicy dwuelementowej. Lub wartość FALSE w przypadku błędu.
 */
function kwadratowa(a, b, c) {
	if(!isNaN(a) && !isNaN(b) && !isNaN(c)) {
		if(a != 0) {
			var delta = (b*b)-(4*a*c);
			if(delta >= 0) {
				var sqrt_delta = Math.sqrt(delta);
				var x_1 = ((b*(-1))-sqrt_delta)/2*a;
				var x_2 = ((b*(-1))+sqrt_delta)/2*a;
				return [x_1, x_2];
			} else {
				return null;		// W przypadku gdy nie ma rozwiązań
			}
		} else {
			return false;			// W przypadku gdy nie jest to funkcja kwadratowa								
		}
	} else {
		return false;				// W przypadku gdy nie zostały wprowadzone liczby
	}
}

/**
 * Funkcja testująca metodę kwadratowa(a,b,c)
 * @param  {number} start Wartość od której mają zaczynać się testowane liczby
 * @param  {number} ilosc Ile testów ma być przetestowanych
 * @param  {number} krok  O ile ma się zwiększać testowana liczba
 */
function testKwadratowa(start, stop, krok) {
	var ilosc_null = 0;
	var ilosc_false = 0;
	var ilosc_wynikow = 0;
	var ilosc_t = 0;
	for(i=start; i<=stop; i += krok) {
		for(j=start; j<=stop; j += krok) {
			for(k=start; k<=stop; k += krok) {
				var wynik = kwadratowa(i,j,k);
				if(wynik != null && wynik != false)
					ilosc_wynikow++;
				if (wynik == null)
					ilosc_null++;
				else if (wynik == false)
					ilosc_false++;

				var msg = "Testowanie dla " + i + "x^2 + " + j + "x +" + k + " = " + kwadratowa(i,j,k);
				console.log(msg);
				ilosc_t++;
			}
		}
	}

	var msg = "Testowanie skończone dla " + ilosc_t + " testów. ----- " + ilosc_wynikow + ": ilosc wynikow liczbowych -----" + ilosc_false + ": ilosc wynikow false ------" + ilosc_null + ": ilosc wynikow null";     
	console.log(msg);
}
/**
 * Funkcja licząca funkcję kwadratową na podstawie wartości zamieszczonych w formuarzu
 * 
 */
function kwadratowaForm() {
	var a = document.forms['A'].a.value;
	var b = document.forms['A'].b.value;
	var c = document.forms['A'].c.value;
	var wynik = kwadratowa(a,b,c);
	var msg = "";
	
	if(wynik == null) 
		msg = 'Brak pierwiastkow';
	else if(wynik != false)	
		msg = "Pierwiastek 1: " + wynik[0] + " Pierwiastek 2: " + wynik[1];
	 else
		msg = "Cos poszlo nie tak";
	
	document.getElementById("output").innerHTML = msg;
}
