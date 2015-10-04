<?php
require_once __DIR__ . "/libs/configuration.php";

$language = "en";
if(in_array($language, $availableLangs))
	echo 'jest';
else
	echo 'nie ma';

?>