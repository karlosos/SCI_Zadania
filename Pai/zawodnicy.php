<?php
// Laczenie sie z baza danych
try {
    $db = new PDO("sqlite:baza.sqlite");
} catch (PDOException $e) {
    echo $e->getMessage();
}

// Jezeli zostala wykonana jakas akcja to wyswietlamy przycisk do powrotu
if (isset($_GET['edit']) OR isset($_GET['add']) OR isset($_GET['mod']) OR isset($_GET['del'])) {
    echo '<form>
              <input type="hidden" name="typ" value="wszyscy" />
              <input type="submit" value="Odswiez widok" />
          </form>';
}

// Jezeli chcemy wyswietlic liste zawodnikow
if (isset($_GET["typ"])) {
    $typ = $_GET["typ"];
    if ($typ == "wybrani") {
        if (!isset($_GET["wiek_min"]))
            $wiek_min = $_GET["wiek_min"];
        else
            $wiek_min = 0;

        if (!isset($_GET["wiek_max"]))
            $wiek_max = $_GET["wiek_max"];
        else
            $wiek_max = 200;
        $sql = "SELECT * FROM zawodnicy WHERE wiek > " . $wiek_min . " AND wiek < " . $wiek_max;
    } else {
        $wiek_min = 0;
        $wiek_max = 200;
        $sql = "SELECT * FROM zawodnicy WHERE wiek > " . $wiek_min . " AND wiek < " . $wiek_max;
    }

    echo '<table>';
    echo '<thead>';
    echo '<th>ID</th>';
    echo '<th>Imie</th>';
    echo '<th>Nazwisko</th>';
    echo '<th>Opcje</th>';
    echo '</thead>';
    foreach ($db->query($sql) as $row) {
        echo '<tr>';
        echo '<td>' . $row['id'] . '</td>';
        echo '<td>' . $row['imie'] . '</td>';
        echo '<td>' . $row['wiek'] . '</td>';
        echo '<td> '
        . '<a href="zawodnicy.php?del=' . $row['id'] . '">USUN</a>  '
        . '<a href="zawodnicy.php?mod=' . $row['id'] . '">MODYFIKUJ</a>'
        . '</td>';
        echo '</tr>';
    }
    echo '</table>';
}
?>

<form method="get">
    Wyswietl zawodnikow: <br>
    WSZYSCY: <input onchange="customSearch()"  type="radio" value="wszyscy" name="typ" checked>
    WYBRANI: <input onchange="customSearch()" type="radio" id="typ" value="wybrani" name="typ">

    <div id="custom" style="display: none">
        WIEK MIN: <input type="number" name="wiek_min"> <br>
        WIEK MAX: <input type="number" name="wiek_max"> <br>
    </div>

    <input type="submit"/>

</form>

<?php
// Jezeli wybralismy jakiegos zawodnika do modyfikacji to wyswietlamy formularz
// edycji
if (isset($_GET['mod'])) {
    $sql = "SELECT * FROM zawodnicy WHERE id =" . $_GET['mod'];
    foreach ($db->query($sql) as $row) {
        ?>
        <form method="get">
            <input type="hidden" name="edit" value="1"/>
            Imie: <input type="text" name="imie"  pattern="^[A-Z]..*" value="<?= $row['imie'] ?>"/> <br>
            Wiek: <input type="text" name="wiek" pattern="^(([1-9])|([1-9][0-9])|(1[0-9][0-9]))$" value="<?= $row['wiek'] ?>"/> <br>
            <input type="hidden" name="id" type="number" value="<?= $_GET['mod'] ?>"/>
            <input type="submit" />
        </form>
        <?php
    }
}

// Jezeli zedytowalismy jakiegos zawodnika w formularzu edycji to aktualizujemy go
if (isset($_GET['edit'])) {
    if (isset($_GET['imie']) && isset($_GET['wiek']) && isset($_GET['id'])) {
        $imie = $_GET['imie'];
        $wiek = $_GET['wiek'];
        $id = $_GET['id'];
        
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
            $sql = "UPDATE zawodnicy SET imie='$imie', wiek='$wiek' WHERE id='$id';";
            echo $sql;
            $db->query($sql);
        }
    }
}

// Jezeli wybralismy akcje usuwania na jakims zawodniku to usuwamy go
if (isset($_GET['del'])) {
    echo "<script>alert (\"Usuwasz rekord!\")</script>";
    $sql = "DELETE FROM zawodnicy WHERE id=" . $_GET['del'];
    $db->query($sql);
}

// Jezeli wyslalismy formularz dodawania zawodnika dodaje nam zawodnika do bazy
if (isset($_GET['add'])) {
    if (isset($_GET['imie']) && isset($_GET['wiek'])) {
        $imie = $_GET['imie'];
        $wiek = $_GET['wiek'];
        
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
                echo 'Popraw dane';
		$test = false;
	}
	
	if(preg_match($patternWiek, $wiek)) {
		$test = true;
	}
	else {
                echo 'Popraw dane';
		$test = false;
	}
	
	if(preg_match($patternWiekZakres, $wiek)) {
		$test = true;
	}
	else {
                echo 'Popraw dane';
		$test = false;
	}
        
	if($wiek > 0 && $wiek < 200) {
		$test = true;
	}
	else {
                echo 'Popraw dane';
		$test = false;
	}
        
        if($test) {
            $sql = "INSERT INTO zawodnicy (imie, wiek) VALUES ('$imie', '$wiek');";
            $db->query($sql);
        }
    }
}

// Jezeli nie jest ustawiona zadna akcja na zawodniku to wyswietla formularz
// dodawania zawodnika
if (!(isset($_GET['edit']) OR isset($_GET['add']) OR isset($_GET['mod']) OR isset($_GET['del']))) {
    ?>

    Dodaj zawodnika: <br>
    <form method="get">
        <input type="hidden" name="add" value="1"/>
        Imie: <input type="text" name="imie" pattern="^[A-Z]..*" /> <br>
        Wiek: <input type="text" name="wiek" pattern="^(([1-9])|([1-9][0-9])|(1[0-9][0-9]))$" /> <br>
        <input type="submit" />
    </form>

    <?php
}
?>
<script>
    function customSearch() {
        $type = document.getElementById("typ");
        $custom = document.getElementById("custom");
        if ($type.checked) {
            $custom.style.display = "block";
        }
        else {
            $custom.style.display = "none";
        }
    }
</script>