/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DataAcessObject.ConnectMySQL;
import DataAcessObject.UtilisateurDAO;
import Modele.Utilisateur;

/**
 *
 * @author KévinKOY
 */
public class Recherche_informations {

    //ATTRIBUTS 
    protected Utilisateur user;

    public Recherche_informations() {
    }

    /**
     * CONSTRUCTEUR Surcharge (PAGE LOGGIN: SAISIE du email+passwd)
     * Initialisation de l'utilisateur connecté
     *
     * @param email
     * @param passwd
     */
    public Recherche_informations(String email, String passwd) {

        // FIND(email,passwd) DE LA PAGE LOGGIN
        UtilisateurDAO objetdao = new UtilisateurDAO(ConnectMySQL.getInstance());
        Utilisateur find = objetdao.find(email, passwd); // return Utilisateur NULL ou Trouvé!
        // Initialisation de user
        this.user = find;

        // Aucun utilisateur connecté...
        if (this.user.getId() == 0) {
            System.out.println("Aucun utilisateur connecté: " + user.toString());
        } // Utilisateur connecté !
        else {
            System.out.println("Utilisateur connecté!: " + user.toString());
            switch (this.user.getDroit()) {
                case 1:
                    System.out.println("Administrateur");
                case 2:
                    System.out.println("Référent pédagogique");
                case 3:
                    System.out.println("Enseignant");
                    
                case 4:
                    System.out.println("Etudiant");
                default:
                    System.out.println("");
            }
        }
    }
    
    
    // Getters /////////////////////////////////////////////////////////////////////
    /**
     *
     * @return id
     */
    public int getId() {
        return this.user.getId();
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return this.user.getEmail();
    }

    /**
     *
     * @return passwd
     */
    public String getPasswd() {
        return this.user.getPasswd();
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return this.user.getNom();
    }

    /**
     *
     * @return prenom
     */
    public String getPrenom() {
        return this.user.getPrenom();
    }

    /**
     *
     * @return int droit
     */
    public int getDroit() {
        return this.user.getDroit();
    }


    /**
     *
     * @return String du Droit utilisateur connecté
     */
    public String getStringDroit() {
        switch (this.user.getDroit()) {
            case 1:
                return "Administrateur";
            case 2:
                return "Référent pédagogique";
            case 3:
                return "Enseignant";
            case 4:
                return "Etudiant";
            default:
                return "";
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}






/*
    public Object by_ID(Object obj) {
        // OBJECT NULL PAR DEFAUT
        Object returned = null;
        // INSTANCE OF ? 
        if (obj instanceof Utilisateur) {
            Utilisateur find = new UtilisateurDAO(ConnectMySQL.getInstance()).find(((Utilisateur) obj).getId());
            returned = find;

        } else if (obj instanceof Etudiant) {
            Etudiant find = new EtudiantDAO(ConnectMySQL.getInstance()).find(((Etudiant) obj).getId());
            returned = find;

        } else if (obj instanceof Enseignant) {
            Enseignant find = new EnseignantDAO(ConnectMySQL.getInstance()).find(((Enseignant) obj).getId());
            returned = find;
        } else if (obj instanceof Cours) {
            Cours find = new CoursDAO(ConnectMySQL.getInstance()).find(((Cours) obj).getId());
            returned = find;
        }

        return returned;
    }*/
