<?php
class Utilisateur{
    private $login;
    private $mdp;
    private $nom;
    private $prenom;
    private $telephone;
    private $mail;
    private $typeUtilisateur;
    private $raisonSociale;
    private $activite;
    private $anneeInscription;
    private $siteInternet;
    private $exposer;
    private $codeS;

    public function getLogin(){
        return $this->login;
    }
    public function setLogin($login){
        $this->login=$login
    }
    public function getMdp(){
        return $this->mdp
    }
    public function setMdp($mdp){
        $this->mdp=$mdp;
    }
    public function getNom(){
        return $this->nom;
    }
    public function setNom($nom){
        $this->nom=$nom;
    }
    public function getPrenom(){
        return $this->prenom;
    }
    public function setPrenom($prenom){
        $this->prenom=$prenom;
    }
    public function getTelephone(){
        return $this->telephone;
    }
    public function setTelephone($telephone){
        $this->telephone=$telephone;
    }
    public function getMail(){
        return $this->mail;
    }
    public function setMail(){
        $this->mail=$mail;
    }
    public function getTypeUtilisateur(){
        return $this->typeUtilisateur;
    }
    public function setTypeUtilisateur($typeUtilisateur){
        $this->typeUtilisateur=$typeUtilisateur;
    }
    public function getRaisonSociale(){
        return $this->raisonSociale;
    }
    public function setRaisonSociale($raisonSociale){
        $this->raisonSociale=$raisonSociale;
    }
    public function getActivite(){
        return $this->activite;
    }
    public function setActivite($activite){
        $this->activite=$activite;
    }
    public function getAnneeInscription(){
        return $this->anneeInscription;
    }
    public function setAnneeInscription($anneeInscription){
        $this->anneeInscription=$anneeInscription;
    }
    public function getSiteInternet(){
        return $this->siteInternet;
    }
    public function setSiteInternet($siteInternet){
        $this->siteInternet=$siteInternet;
    }
    public function getExposer(){
        return $this->exposer;
    }
    public function setExposer($exposer){
        $this->exposer=$exposer;
    }
    public function getCodeS(){
        return $this->codeS;
    }
    public function setCodeS($codeS){
        $this->codeS=$codeS;
    }


}