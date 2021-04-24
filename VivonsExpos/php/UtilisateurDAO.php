<?php
class UtilisateurDAO{
    
    public static function getLesUtilisateurs(){
        
        try{
            $sql = "select * from utilisateur where typeUtilisateur ='exposant' " ;
            
            $requetePrepa = DBConnex::getInstance()->prepare($sql);
            $requetePrepa->execute();
            $liste = $requetePrepa->fetchAll(PDO::FETCH_ASSOC);
        }catch(Exception $e){
            $liste = "";
        }
        return $liste;   
    }
}
?>