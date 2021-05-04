package com.example.vivonsexpos.DTO;

import java.util.ArrayList;

public class Inscrits {

    private ArrayList<Utilisateur> lesInscrits = new ArrayList();

    public Inscrits(){
        this.lesInscrits  = null;
    }

    public void  setLesInscrits(ArrayList<Utilisateur> liste) {
        this.lesInscrits= liste;
    }

    public ArrayList<Utilisateur>  getLesInscrits(){
        return this.lesInscrits;
    }

    public Utilisateur chercheUtilisateur(String login){

        int i =0;
        while(login!= this.lesInscrits.get(i).getLogin() && i<this.lesInscrits.size()-1){
            i++;
        }
        if(login == this.lesInscrits.get(i).getLogin()){
            return this.lesInscrits.get(i);
        }
        return null;
    }
}
