<?php
require_once 'param.php';
require_once 'DBConnex.php';
require_once 'listeUniversDAO.php';
require_once 'Univers.php';



print(json_encode(listeUniversDAO::listeUnivers()));
