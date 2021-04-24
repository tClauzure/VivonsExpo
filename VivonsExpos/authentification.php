<?php 
require_once 'param.php';
require_once 'connexion.php';

print(json_encode(UtilisateurDAO::authentification($_POST['login'], $_POST['mdp'])));
?>
