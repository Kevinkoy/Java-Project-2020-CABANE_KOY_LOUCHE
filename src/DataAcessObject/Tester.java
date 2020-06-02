package DataAcessObject;

import Controleur.Recherche_informations;
import Modele.*;
import Vue.*;

public class Tester {

    public static void main(String[] args) {

        // LOGGIN
        /*String email = "enseignant@edu.ece.fr";
        String passwd = "mdpE";

        // BOUTTON: CONNEXION....
        // =>DAO: Data Acess Object, on va chercher dans la BDD
        UtilisateurDAO objetdao = new UtilisateurDAO(ConnectMySQL.getInstance());
        Utilisateur find = objetdao.find(email, passwd);

        /// Si on trouve pas dans la DataBase...
        if (find.getId() == 0) {
            System.out.println("Email ou mot de passe incorrect");
        } /// On trouve l'utilisateur dans la DataBase...
        // On appelle le constructeur de recherche_informations (initialisation).
        else {
            Recherche_informations search = new Recherche_informations(email, passwd);
            System.out.println("Informations sur l'utilisateur:" + search.getUser().toString());
            System.out.println("Id:" + search.getId());
            System.out.println("Email:" + search.getEmail());
            System.out.println("Mot de passe:" + search.getPasswd());
            System.out.println("Nom:" + search.getNom());
            System.out.println("Prenom:" + search.getPrenom());
            System.out.println("Droit:" + search.getDroit());
            System.out.println("Numero:" + search.getNumero());
            System.out.println("Groupe:" + search.getGroupe());
            System.out.println("Promotion:" + search.getPromotion());
            System.out.println("Cours:" + search.getCours());
        }*/
        
        /*ResultaRecherche page = new ResultaRecherche();
        
        page.setVisible(true);*/
        Utilisateur utilisateur = new Utilisateur();
        
        
        EmploiDuTemps head = new EmploiDuTemps(utilisateur);
        head.setVisible(true);
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
