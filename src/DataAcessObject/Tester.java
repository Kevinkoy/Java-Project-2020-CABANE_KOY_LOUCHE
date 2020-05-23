package DataAcessObject;

import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Utilisateur;
import java.sql.Connection;

public class Tester {

    public static void main(String[] args) {
        // DECLARATION & INITIALISATION
        Connection connection = ConnectMySQL.getInstance();
        DAO<Utilisateur> utilisateurdao = new UtilisateurDAO(connection);

        for (int i = 1; i < 11; i++) {
            Utilisateur utilisateur = utilisateurdao.find(i);
            if (utilisateur.getId() == 0) {
                System.out.print("LOL");
            } else {
                System.out.println(utilisateur.toString());
            }

        }

        /*
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(4);
        utilisateur.setEmail("etudiant@gmail.com");
        utilisateur.setPasswd("mdpetu");
        utilisateur.setNom("koy");
        utilisateur.setPrenom("K2");
        utilisateur.setDroit(4);
        System.out.println(utilisateur.toString());*/
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
