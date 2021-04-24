<?php
class lesUtilisateurs{
    private $utilisateurs=[];
    public function __construct($array){
        if(is_array($array)){
            $this->utilisateurs=$array;
        }
    }
    public function getUtilisateurs(){
        return $this->utilisateurs;
    }
    public function chercheUtilisateurs($login){
        $i=0;
        while ($login != $this->utilisateurs[$i]->getLogin()&& $i<count($this->utilisateurs)-1){
            $i++;
        }
        if($login==$this->utilisateurs[$i]->getLogin()){
            return $this->utilisateurs[$i];
        }
    }
}