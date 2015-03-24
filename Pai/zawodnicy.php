<?php
try { 
    // otwarcie/utworzenie bazy 
    $db = new PDO("sqlite:baza.sqlite"); 
} 
catch(PDOException $e) { 
     // bład przy otwieraniu/tworzeniu bazy  
    echo $e->getMessage(); 
} 
$sql = "SELECT * FROM zawodnicy";

if(isset($_GET["typ"])) {
    $typ = $_GET["typ"];
    if($typ == "wybrani") {
        $wiek_min = $_GET["wiek_min"];
        $wiek_max = $_GET["wiek_max"];
        $sql = "SELECT * FROM zawodnicy WHERE wiek > ". $wiek_min ." AND wiek < ". $wiek_max;
    } else {
        
    }
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
    echo '<td>'.$row['id'] . '</td>';
    echo '<td>'.$row['imie'] . '</td>';
    echo '<td>'.$row['wiek'] . '</td>';
    echo '<td> '
    . '<a href="zawodnicy.php?del='.$row['id'].'">USUN</a>  '
    . '<a href="zawodnicy.php?mod='.$row['id'].'">MODYFIKUJ</a>'
    . '</td>';
    echo '</tr>';
}
echo '</table>';
?>

<form method="get">
    WSZYSCY: <input onchange="customSearch()"  type="radio" value="wszyscy" name="typ" checked>
    WYBRANI: <input onchange="customSearch()" type="radio" id="typ" value="wybrani" name="typ">
    
    <div id="custom" style="display: none">
        WIEK MIN: <input type="number" name="wiek_min"> <br>
        WIEK MAX: <input type="number" name="wiek_max"> <br>
    </div>
        
    <input type="submit"/>
    
</form>

<?php
    if(isset($_GET['mod'])) {
        $sql = "SELECT * FROM zawodnicy WHERE id =".$_GET['mod'];
        foreach ($db->query($sql) as $row) {
?>
<form method="get">
    <input type="hidden" name="edit" value="1"/>
    Imie: <input type="text" name="imie" value="<?=$row['imie']?>"/> <br>
    Wiek: <input type="number" name="wiek" value="<?=$row['wiek']?>"/> <br>
    <input type="hidden" name="id" type="number" value="<?=$_GET['mod']?>"/>
    <input type="submit" />
</form>
<?php
        }
    }

    if(isset($_GET['edit'])) {
        if(isset($_GET['imie']) && isset($_GET['wiek']) && isset($_GET['id'])) {
            $imie = $_GET['imie'];
            $wiek = $_GET['wiek'];
            $id = $_GET['id'];
            
            $sql = "UPDATE zawodnicy SET imie='$imie', wiek='$wiek' WHERE id='$id';";
            echo $sql;
            $db->query($sql);
        }
    }
    
    if(isset($_GET['del'])) {
        echo "<script>alert (\"Usuwasz rekord!\")</script>";
        $sql = "DELETE FROM zawodnicy WHERE id=".$_GET['del'];
        $db->query($sql);
    }
?>


<script>
    function customSearch() {
        $type = document.getElementById("typ");
        $custom = document.getElementById("custom");
        if($type.checked) {
            $custom.style.display = "block";
        }
        else {
            $custom.style.display = "none";
        }
    }
</script>