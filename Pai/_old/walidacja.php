 <?php
 if(isset($_GET["add"])) {
	$patternImie = '/^[A-Z]..*/';
        // Zakres od 0 do 200 (0;200)
        // wytłumaczone tutaj https://regex101.com/r/jU1vG3/1
        $patternWiekZakres = '/^(([1-9])|([1-9][0-9])|(1[0-9][0-9]))$/'; 
	$patternWiek = '/^[1-9][0-9]*$/';
        
	$imie = $_GET["imie"];
	$wiek = $_GET["wiek"];
        
        $test = false;
	
	if(preg_match($patternImie, $imie)) {
		$test = true;
	}
	else {
		$test = false;
	}
	
	if(preg_match($patternWiek, $wiek)) {
		$test = true;
	}
	else {
		$test = false;
	}
	
	if(preg_match($patternWiekZakres, $wiek)) {
		$test = true;
	}
	else {
		$test = false;
	}
        
	if($wiek > 0 && $wiek < 200) {
		$test = true;
	}
	else {
		$test = false;
	}
        
        if($test) {
            // tu robie dodawanie
        } else {
            echo 'Tu wyswietlam blad';
        }
 }
?>


 <html>   
	<head>	
	</head>
	
	<body>
		Dodaj zawodnika: <br>
		<form method="get">
			<input type="hidden" name="add" value="1"/>
			Imie: <input type="text" name="imie" pattern="^[A-Z]..*" required /> <br>
			Wiek: <input type="text" name="wiek" pattern="^(([1-9])|([1-9][0-9])|(1[0-9][0-9]))$" required /> <br>
                        <!-- Wiek: <input type="number" name="wiek" step="1" min="1" max="200" required /> <br> -->
			<input type="submit" />
		</form>
	</body>	
</html>