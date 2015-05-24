<!DOCTYPE html>
<html>
    <head>
        <title>3c gr 1</title>



        <link rel="stylesheet" href="libs/bootstrap-3.3.2-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="libs/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">


        <style>
            body { padding-top: 70px; }
            navbar {
                border-bottom: 0px;
            }
        </style>
    </head>
    <body>

        <?php
// Report all PHP errors
        error_reporting(E_ALL);

//rozpoczęcie sesji
        session_start(); //DO ZROBIENIA: warunkowe uruchamianie sesji wtedy gdy jest potrzebna

        require_once __DIR__ . "/libs/configuration.php";


        include ROOT_PATH . '/parts/mod_menu.php';
        ?>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <?php
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
                    ?>
                </div>
            </div>
        </div>

    </body>
    <script src="libs/jquery-2.1.3.min.js"></script>
    <script src="libs/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script>
    </script>
</html>