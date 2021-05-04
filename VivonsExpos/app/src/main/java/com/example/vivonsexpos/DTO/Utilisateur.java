package com.example.vivonsexpos.DTO;

public class Utilisateur {
    private String login;
    private String mdp;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private String typeUtilisateur;
    private String raisonSociale;
    private String activite;
    private String anneeInscription;
    private String siteInternet;
    private  boolean exposer;
    private String codeS;
    private boolean InscriptionValider;


    public Utilisateur(String pLogin, String pmdp, String pnom, String pprenom, String ptelephone, String pmail, String pTypeUtilisateur, String pRaisonSocial, String pActivite,  String pAnneeInscription, String pSiteInternet,  String pCodeS, boolean pExposer, boolean pInscriptionValider){
        this.login =  pLogin;
        this.mdp = pmdp;
        this.nom = pnom;
        this.prenom= pprenom;
        this.telephone = ptelephone;
        this.mail = pmail;
        this.typeUtilisateur = pTypeUtilisateur;
        this.raisonSociale = pRaisonSocial;
        this.activite = pActivite;
        this.anneeInscription = pAnneeInscription;
        this.siteInternet = pSiteInternet;
        this.codeS = pCodeS;
        this.exposer = pExposer;
        this.InscriptionValider = pInscriptionValider;
    }



}
