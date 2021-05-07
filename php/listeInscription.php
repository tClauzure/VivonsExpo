<?php
require_once 'param.php';
require_once 'DBConnex.php';
require_once 'listeInscriptionDAO.php';
require_once 'Inscrit.php';



print(json_encode(listeInscriptionDAO::listeInscrit()));
