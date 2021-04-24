<?php 
require_once 'param.php';
require_once 'connexion.php';

print(json_encode(vivonsexpoDAO::authentification($_POST['login'], $_POST['mdp'])));
?>
