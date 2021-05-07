<?php

class Univers {
    private $libelleU;
    private $numH;

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

    public function __construct($plibelleU=NULL){
        $this->libelleU=$plibelleU;
    }

    public function setLibelleU($plibelleU){
        $this->libelleU=$plibelleU;
    }

    public function getLibelleU(){
        return $this->libelleU;
    }
}
