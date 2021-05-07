<?php

class Inscrit {
    private $login;
    private $nom;
    private $prenom;
    private $mail;
    private $telephone;
    private $raisonSociale;
    private $activite;
    private $anneeInscription;
    private $siteInternet;
    private $libelleS;


    public function hydrate(array $donnees)
    {
        foreach ($donnees as $key => $value)
        {
            $method = 'set'.ucfirst($key);
            if (method_exists($this, $method))
            {
                $this->$method($value);
            }
        }
    }

    public function __construct($plogin=NULL){
        $this->login=$plogin;
    }

    public function setlogin($login){
        $this->login=$login;
    }

    public function getlogin(){
        return $this->login;
    }
}
