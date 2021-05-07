<?php
class listeUniversDAO{
	public static function listeUnivers(){
		try{
			$listeUnivers = array();
            $sql = "select libelleU, numH
			from univers
            order by libelleU" ;
			$requetePrepa = DBConnex::getInstance()->prepare($sql);
			
			$requetePrepa->execute();
			$reponse = $requetePrepa->fetchAll(PDO::FETCH_ASSOC);
            if(!empty($reponse)){
                foreach($reponse as $univers){
                    $unUnivers = new Univers();
                    $unUnivers->hydrate($univers);
                    array_push($listeUnivers, $univers);
                }

            }
		}catch(Exception $e){
			$listeUnivers = "";
		}
		return $listeUnivers;
	}
}

require 'Univers.php';
