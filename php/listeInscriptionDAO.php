<?php
class listeInscriptionDAO{
	public static function listeInscrit(){
		try{
			$listeInscrit = array();
			$sql = "select login, nom , prenom , mail ,telephone, raisonSociale, activite, anneeInscription, siteInternet, libelleS
			from utilisateur, secteur
			where typeUtilisateur = 'exposant'
            AND InscriptionValider = 0
            AND utilisateur.codeS = secteur.codeS" ;
			$requetePrepa = DBConnex::getInstance()->prepare($sql);
			
			$requetePrepa->execute();
			$reponse = $requetePrepa->fetchAll(PDO::FETCH_ASSOC);
			if(!empty($reponse)){
                foreach($reponse as $inscrit){
                    $unInscrit = new Inscrit();
                    $unInscrit->hydrate($inscrit);
                    array_push($listeInscrit, $inscrit);
                }

            }
		}catch(Exception $e){
			$listeInscrit = "";
		}
		return $listeInscrit;
	}
}

require_once 'Inscrit.php';