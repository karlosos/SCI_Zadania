<?php
require_once __DIR__."/../libs/configuration.php";
require_once ROOT_PATH."/control/csv.php";
header("Content-Type: text/plain");
print_r(read_csv('../passwords.csv'));