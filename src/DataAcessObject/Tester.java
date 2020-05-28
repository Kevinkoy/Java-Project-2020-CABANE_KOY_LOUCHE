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
        DAO<Utilisateur> utilisateurdao = new UtilisateurDAO(connection);
        // ObjetDao Unitaire
        //CoursDAO objetdao = new CoursDAO(connection);
    
        // On crée un objet pour manipuler 
        Utilisateur user = new Utilisateur();
        // Configuration setter
        user.setId(23);
        user.setEmail("temail");
        user.setPasswd("tpasswd");
        user.setNom("tnom");
        user.setPrenom("tprenom");
        user.setDroit(0);


        // TEST des fonctions CREATE, DELETE, UPDATE, FIND
        boolean create = utilisateurdao.delete(user);
        System.out.println(create);
        
        //UtilisateurDAO userdao = new UtilisateurDAO(connection);
        //userdao.delete(objet);
        // FIND
        //Etudiant find = objetdao.find(11);
        //System.out.println(find.toString());
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
