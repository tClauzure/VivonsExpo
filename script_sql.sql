#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: HALL
#------------------------------------------------------------

CREATE TABLE HALL(
        numH Varchar (1) NOT NULL
	,CONSTRAINT HALL_PK PRIMARY KEY (numH)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ALLEE
#------------------------------------------------------------

CREATE TABLE ALLEE(
        numH  Varchar (1) NOT NULL ,
        codeA Varchar (2) NOT NULL
	,CONSTRAINT ALLEE_PK PRIMARY KEY (numH,codeA)

	,CONSTRAINT ALLEE_HALL_FK FOREIGN KEY (numH) REFERENCES HALL(numH)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: UNIVERS
#------------------------------------------------------------

CREATE TABLE UNIVERS(
        codeU    Varchar (3) NOT NULL ,
        libelleU Varchar (25) ,
        numH     Varchar (1) NOT NULL
	,CONSTRAINT UNIVERS_PK PRIMARY KEY (codeU)

	,CONSTRAINT UNIVERS_HALL_FK FOREIGN KEY (numH) REFERENCES HALL(numH)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: SECTEUR
#------------------------------------------------------------

CREATE TABLE SECTEUR(
        codeS    Varchar (2) NOT NULL ,
        libelleS Varchar (25) ,
        codeU    Varchar (3) NOT NULL
	,CONSTRAINT SECTEUR_PK PRIMARY KEY (codeS)

	,CONSTRAINT SECTEUR_UNIVERS_FK FOREIGN KEY (codeU) REFERENCES UNIVERS(codeU)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRAVEE
#------------------------------------------------------------

CREATE TABLE TRAVEE(
        numH  Varchar (1) NOT NULL ,
        numT  Varchar (2) NOT NULL ,
        codeS Varchar (2) NOT NULL
	,CONSTRAINT TRAVEE_PK PRIMARY KEY (numH,numT)

	,CONSTRAINT TRAVEE_HALL_FK FOREIGN KEY (numH) REFERENCES HALL(numH)
	,CONSTRAINT TRAVEE_SECTEUR0_FK FOREIGN KEY (codeS) REFERENCES SECTEUR(codeS)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: UTILISATEUR
#------------------------------------------------------------

CREATE TABLE UTILISATEUR(
        login     Varchar (100) NOT NULL ,
        mdp       Varchar (100) NOT NULL ,
        nom       Varchar (50) NOT NULL ,
        prenom    Varchar (50) NOT NULL ,
        telephone Varchar (14) NOT NULL ,
        mail      Varchar (100) NOT NULL
	,CONSTRAINT UTILISATEUR_PK PRIMARY KEY (login)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: EXPOSANT
#------------------------------------------------------------

CREATE TABLE EXPOSANT(
        login            Varchar (100) NOT NULL ,
        raisonSociale    Varchar (40) ,
        activite         Varchar (25) ,
        anneeInscription Int ,
        siteInternet     Varchar (14) NOT NULL ,
        exposer          Bool NOT NULL ,
        mdp              Varchar (100) NOT NULL ,
        nom              Varchar (50) NOT NULL ,
        prenom           Varchar (50) NOT NULL ,
        telephone        Varchar (14) NOT NULL ,
        mail             Varchar (100) NOT NULL ,
        codeS            Varchar (2) NOT NULL
	,CONSTRAINT EXPOSANT_PK PRIMARY KEY (login)

	,CONSTRAINT EXPOSANT_UTILISATEUR_FK FOREIGN KEY (login) REFERENCES UTILISATEUR(login)
	,CONSTRAINT EXPOSANT_SECTEUR0_FK FOREIGN KEY (codeS) REFERENCES SECTEUR(codeS)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: DEMANDE
#------------------------------------------------------------

CREATE TABLE DEMANDE(
        numD  Varchar (4) NOT NULL ,
        dateD Date ,
        motif Varchar (40) ,
        login Varchar (100) NOT NULL
	,CONSTRAINT DEMANDE_PK PRIMARY KEY (numD)

	,CONSTRAINT DEMANDE_EXPOSANT_FK FOREIGN KEY (login) REFERENCES EXPOSANT(login)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: STAND
#------------------------------------------------------------

CREATE TABLE STAND(
        numH_HALL_ALLEE  Varchar (1) NOT NULL ,
        codeA            Varchar (2) NOT NULL ,
        numH_HALL_TRAVEE Varchar (1) NOT NULL ,
        numT             Varchar (2) NOT NULL ,
        numS             Varchar (3) NOT NULL ,
        login            Varchar (100) NOT NULL
	,CONSTRAINT STAND_PK PRIMARY KEY (numH_HALL_ALLEE,codeA,numH_HALL_TRAVEE,numT,numS)

	,CONSTRAINT STAND_ALLEE_FK FOREIGN KEY (numH_HALL_ALLEE,codeA) REFERENCES ALLEE(numH,codeA)
	,CONSTRAINT STAND_TRAVEE0_FK FOREIGN KEY (numH_HALL_TRAVEE,numT) REFERENCES TRAVEE(numH,numT)
	,CONSTRAINT STAND_EXPOSANT1_FK FOREIGN KEY (login) REFERENCES EXPOSANT(login)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: STAFF
#------------------------------------------------------------

CREATE TABLE STAFF(
        login     Varchar (100) NOT NULL ,
        mdp       Varchar (100) NOT NULL ,
        nom       Varchar (50) NOT NULL ,
        prenom    Varchar (50) NOT NULL ,
        telephone Varchar (14) NOT NULL ,
        mail      Varchar (100) NOT NULL
	,CONSTRAINT STAFF_PK PRIMARY KEY (login)

	,CONSTRAINT STAFF_UTILISATEUR_FK FOREIGN KEY (login) REFERENCES UTILISATEUR(login)
)ENGINE=InnoDB;

