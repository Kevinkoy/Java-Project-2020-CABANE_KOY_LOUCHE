package DataAcessObject;

import Modele.Cours;
import Modele.Utilisateur;
import java.sql.Connection;

public class Tester {

    public static void main(String[] args) {
        // Declaration et initialisation
        // On crée une connection, specifique à notre base de donnée
        Connection connection = ConnectMySQL.getInstance();

        // On crée un objetDao (recuperer/stocker les donnees), avec passage de la connection crée
        DAO<Cours> objetdao = new CoursDAO(connection);

        // On crée un objet pour manipuler 
        Cours objet = new Cours();
        // Configuration setter
        objet.setId(1);
        objet.setNom("Java");
        // TEST des fonctions CREATE, DELETE, UPDATE, FIND
        //boolean create = objetdao.create(objet);

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
