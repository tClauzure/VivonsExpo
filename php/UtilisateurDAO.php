<?php
class UtilisateurDAO{
	public static function authentification($login , $mdp){
		try{
			$sql = "select nom , prenom , typeUtilisateur, mail ,telephone 
			from utilisateur 
			where login = :login and mdp = :mdp " ;
			$requetePrepa = DBConnex::getInstance()->prepare($sql);
			$mdp =  md5($mdp);
			$requetePrepa->bindParam("login", $login);
			$requetePrepa->bindParam("mdp", $mdp);
			$requetePrepa->execute();
			$reponse = $requetePrepa->fetch(PDO::FETCH_ASSOC);
		}catch(Exception $e){
			$reponse = "";
		}
		return $reponse;
	}
}

