package DataAcessObject;

import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Utilisateur;
import java.sql.Connection;

public class Tester {

    public static void main(String[] args) {
        // Declaration et initialisation
        // On crée une connection, specifique à notre base de donnée
        Connection connection = ConnectMySQL.getInstance();

        // On crée un objet utilisateurDataAcessObject (recuperer/stocker les donnees), avec passage de la connection crée
        DAO<Utilisateur> utilisateurdao = new UtilisateurDAO(connection);

        // On crée un objet Utilisateur (pour manipuler)
        Utilisateur kevin = new Utilisateur();
        //kevin.setId(25); // is AUTO INCREMENTED !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        kevin.setEmail("tester@edu.ece.fr");
        kevin.setPasswd("test_passwd");
        kevin.setNom("test_nom");
        kevin.setPrenom("test_prenom");
        kevin.setDroit(0);

        /// TEST DES FONCTIONS *******************************************************
        // On va supprimer l'utilisateurdao kevin de la BDD
        boolean deleted = utilisateurdao.delete(kevin);
        if (deleted) {
            //System.out.println("DELETED:" + kevin);
        }

        // **************************************************************************
        // On va créer l'utilisateurdao kevin
        boolean created = utilisateurdao.create(kevin);
        if (created) {
            // On le cherche par email car id auto increment, et on l'affiche
            //System.out.println("CREATED:" + utilisateurdao.find;
        }

        kevin.setPasswd("UPDATED_passwd");

        // On va update l'utilisateurdao par kevin
        boolean updated = utilisateurdao.update(kevin);

        // Si updated...
        if (updated) {
            // On le chercher par id, et on l'affiche avec ses changements
            //System.out.println("UPDATED:" + utilisateurdao.find(kevin.getId()).toString());
        }

    }
}

///////////////////////////////////////////////////////////////////////////////
/*
        // DECLARATION && INITIALISATION
        int id_seance = 1;

        int jour = 20;
        int mois = 05;
        int annee = 2020;
        MaDate date = new Modele.MaDate(jour, mois, annee);

        Time heure_debut = new Time(13, 45, 0);
        Time heure_fin = new Time(15, 15, 0); // ATTENTION JAI MODIFIER Heure_fin = heure_debut + 1H30 dans Seance par default
        int etat = 0; // 0 default en cours de validation | 1 valide

        int id_cours = 1;
        String nom_cours = "Mathematiques";
        Cours cours = new Modele.Cours(id_cours, nom_cours);

        int id_type = 1;
        String nom_type = "Cours Magistral";
        Type_cours type_cours = new Modele.Type_cours(id_type, nom_type);

        Seance maSeance = new Modele.Seance(id_seance, date, heure_debut, heure_fin, etat, cours, type_cours);

        /// DISPLAY
        System.out.print(maSeance.toString());
        System.out.print("\n");
 */
