# Projekt
Projekt wykonywany podczas lekcji + poprawki w domu. Całość znajduje się pod linkiem: https://github.com/karlosos/SCI_Zadania/Pai/

# Zadanie 7
## Treść
Napisz fragment kodu w PHP (funkcje lub klas jeśli potrafisz), która przetworzy nagłówek żądania http w którym przesyłane są informacje nt akceptowalnego języka: 

- Wejście: z nagłówka http
- Wyjście: do tablicy, indeks 0 to pierwszy jęzk itp.

Zadanie obowiąkowe na ocenę czas wykonania 60 minut. Gotowe rozwiąanie prześlj na cichon@poczta.fm w postaci gotowej do przetestowania. 
Nie zapomnij o dokumentacji kodu pozwalającej łatwo go zaimplementować przetestowa

## Rozwiązanie
Dnia 12.12.2014 czyli podczas lekcji wysłałem rozwiązanie zadania w postaci pliku a dokładniej funkcji. 
Niestety plik ten nie był przystosowany do testowania bo była to tylko funkcja (bez jej wywołania).
W załączniku wrzucam poprawioną wersję ```UstawieniaJezyka.php```, która działa samodzielnie i niezależnie. 
Pragnę też dodać, że w wersji wysłanej podczas lekcji tworzyło nam tablicę wraz z wagami danego języka 
i nie ucinało łańcucha znaków to tylko dwóch charów.

# Zadanie 8
## Treść
Napisz fragment kodu w PHP (funkcje lub klasę jeślli potrafisz), który:

* pokaże możliwe do ustawienia języki treści aplikacji (menu rozwijane, lista, obrazki)
* po wybraniu przez użytkownika, aplikacja automatycznie zapamięta wybór użytkownika w ciastku
* przy kolejnyn wejściu najpierw sprawdzi istnienie ciastka a potem w razie potrzeby dokona detekcji języka (z zadania 7)

Zadanie obowiązkowe na ocenę, czas wykonania 90 minut. Gotowe rozwiązanie prześlij na cichon@poczta.fm w postaci gotowej do przetestowania (samodzielony plik php). Podpisz sie w temacie! Nie zapomnij o dokumentacji kodu pozwalającej łatwo go zaimplementować i przetestować.

Sprawdzamy czy jest ciastko wysłane przez przeglądarkę użytkownika.

jeżeli (istnieje ciastko, lub ma ustawioną wartoślć){
 odczytaj zawartoślć;
 wyślwietl odpowiednią treślć;
 zrób przekierowanie jeślli trzeba;
}
else{
 wykonaj detekcję języka z zadania 7;
 ustaw cistko z wykrytym jezykiem jeślli jest jakiśl pasujący; 
}
 
## Rozwiązanie
Zadanie to rozwiązałem w pliku ```index.php``` i ```mod_topbar.php```. Poniżej zamieszczę fragmenty kodu wraz z wyjaśnioną funkcjonalnością.
### Pokazane możliwe do ustawienia języki
Rozwiązałem to za pomocą dwóch flag (tak jak było mówione na lekcji) i includuje je na samej górze strony w pliku ```index.php```

``` PHP
<div id="top_bar">
    <?php
    if (isset($_COOKIE["language"])) {
        $lang = $_COOKIE["language"];
        echo "$lang";
    }
    // TO DO poprawić adresy do obrazków
    ?>
    <a href="/control/language.php?l=pl"><img src="http://localhost/pai/images/flags/pl.gif" /></a>
    <a href="/control/language.php?l=us"><img src="http://localhost/pai/images/flags/us.gif" /></a>
</div>
```

Flagi te są odnośnikami to pliku ```language.php``` który zmienia nam wartość w ciasteczku.

``` PHP
if(isset($_GET['l'])) {
    $lang = $_GET["l"];
    setcookie ( 'language', $lang, time() + 60*60*24*30);
}

header('Location: ' . $_SERVER['HTTP_REFERER']);
```

Co do ostatniego podpunktu, czyli:
> przy kolejnyn wejślciu najpierw sprawdzi istnienie ciastka a potem w razie potrzeby dokona detekcji języka (z zadania 7)
 
Wykonałem to trochę inaczej ze względu na wcześniejszą implementacje. Przy wejściu na stronę automatycznie tworzy się ciastko z językiem. Przy zmianie języka 
po prostu zmieniamy wartość tego ciastka. Mimo to przy wiebieraniu języka jest możliwość działania funkcjonalności z zadania 7. 

Hierarchia wyboru:

* id podane w linku
* ciastkeczko
* żądanie przeglądarki

``` PHP

    if (isset($_GET['id'])) {
    $id = $_GET['id'];
    if (isset($_GET['lang'])) {
        ChromePhp::log('Language chosen on $_GET');
        $lang = $_GET['lang'];
        if(!loadPage($id, $lang))
                echo 'nie wczytano pliku';
    } else if (isset($_COOKIE['language'])) {
        $lang = $_COOKIE['language'];
        ChromePhp::log('Language chosen on cookie');
        if(!loadPage($id, $lang))
                echo 'nie wczytano pliku';;
    } else {
        $lang_array = getLanguage();
        $lang = substr($lang_array[0][0], 0, 2);
        ChromePhp::log('Language chosen on browser');
        if(loadPage($id, $lang))
                echo 'nie wczytano pliku';
    }
```

```ChromePhp::log()``` to funkcja pozwalająca na testowanie php, którą dodałem w celu debugowania.

# Zadanie 9
## Treść
Używając przykładów ze strony http://getbootstrap.com/ zaimplementuj elementy 

Zadanie 09a - navbar
Zaimplementuj element navbar tak aby:
plik mod_menu.php  zawierający menu z zadania 06 formatowany był jak na przykładach.


Zadanie 09b - carousel 
Zaimplementuj element carousel tak aby:

* pojawił się jako element Twojego projektu (na 2)
* pojawiał się tylko na strone głównej (na 3)
* zawierał grafikę (zdjęcia) zamiast domyśllnego szarego tła (na 4)
* posiadał 4 lub więcej rotujących elementów (na 5)

Zadanie obowiązkowe na ocenę, czas wykonania 90 minut. Gotowe rozwiązanie prześlij na cichon@poczta.fm w postaci gotowej do przetestowania (samodzielony plik php).

## Rozwiązanie

### Navbar
Tak samo jak poprzedni + dodanie logowania i wylogowywania i dodanie flag do zmian języka. 

```PHP
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">PAI</a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.php">Strona główna <span class="sr-only">(current)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Podstrona 1 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Link 1.1</a></li>
                        <li><a href="#">Link 1.2</a></li>
                    </ul>
                </li>
                <li><a href="#">Podstrona 2</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ustawienia<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Zmień hasło</a></li>
                        <li><a href="#">Edytuj profil</a></li>
                    </ul>
                </li>
                <li><a href="index.php?id=contact">Kontakt</a></li>
            </ul>
            <?php
            if (isset($_SESSION['status'])) {
                if ($_SESSION['status'] == true)
                    include ROOT_PATH . '/parts/inc_form_logout.php';
            }
            else {
                include ROOT_PATH . '/parts/inc_form_login.php';
            }
            include ROOT_PATH . '/parts/mod_topbar.php';
            ?>
        </div><!--/.navbar-collapse -->
    </div>
</nav>
```

### Carousel
``` PHP
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="http://localhost/pai/images/carousel/1.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Piękne miasto nocą</h1>
                    <p>Nasza strona opowie ci wszystko o tej fotografii</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Czytaj więcej</a></p>
                </div>
            </div>
        </div>

        <div class="item">
            <img src="http://localhost/pai/images/carousel/2.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Piękne miasto nocą</h1>
                    <p>Nasza strona opowie ci wszystko o tej fotografii</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Czytaj więcej</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="http://localhost/pai/images/carousel/3.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Piękne miasto nocą</h1>
                    <p>Nasza strona opowie ci wszystko o tej fotografii</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Czytaj więcej</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="http://localhost/pai/images/carousel/4.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Piękne miasto nocą</h1>
                    <p>Nasza strona opowie ci wszystko o tej fotografii</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Czytaj więcej</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->
```

Załączenie karuzeli tylko na stronie głównej z 4 elementami - zdjęciami:

``` PHP
if (isset($_GET['id'])) {
    $id = $_GET['id'];
    if (isset($_GET['lang'])) {
        ChromePhp::log('Language chosen on $_GET');
        $lang = $_GET['lang'];
        if (!loadPage($id, $lang))
            echo 'nie wczytano pliku';
    } else if (isset($_COOKIE['language'])) {
        $lang = $_COOKIE['language'];
        ChromePhp::log('Language chosen on cookie');
        if (!loadPage($id, $lang))
            echo 'nie wczytano pliku';;
    } else {
        $lang_array = getLanguage();
        $lang = substr($lang_array[0][0], 0, 2);
        ChromePhp::log('Language chosen on browser');
        if (loadPage($id, $lang))
            echo 'nie wczytano pliku';
    }
} else {
    include ROOT_PATH . '/parts/mod_carousel.php';
}
```