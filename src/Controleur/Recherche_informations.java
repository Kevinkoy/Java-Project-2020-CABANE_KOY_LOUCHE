/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DataAcessObject.ConnectMySQL;
import DataAcessObject.CoursDAO;
import DataAcessObject.DAO;
import DataAcessObject.EnseignantDAO;
import DataAcessObject.EtudiantDAO;
import DataAcessObject.Seance_groupesDAO;
import DataAcessObject.UtilisateurDAO;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Seance_groupes;
import Modele.Utilisateur;
import java.sql.Connection;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author KévinKOY
 */
public class Recherche_informations {

    public Recherche_informations() {
    }

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
    }

    
    
    
    
    
    public DAO<Seance_groupes> Seance_groupes(Etudiant obj) {
        Connection connection = ConnectMySQL.getInstance();
        DAO<Seance_groupes> objetdao = new Seance_groupesDAO(connection);

        Seance_groupes find = objetdao.find(obj.getGroupe().getId());

        return objetdao;

    }

    /**
     * Verifie le droit, d'un utilisateur passé en paramètre.
     *
     * @param obj
     * @return 1 2 3 4
     */
    public int verifier_Droit(Utilisateur obj) {
        switch (obj.getDroit()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }
}
