package DataAcessObject;

import Controleur.Recherche_informations;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Utilisateur;
import java.sql.Connection;

public class Tester {

    public static void main(String[] args) {
        // ETAPE 1 - On crée une connection, specifique à notre base de donnée
        //Connection connection = ConnectMySQL.getInstance();

        // ETAPE 2 - On crée un objetDao (recuperer/stocker les donnees), avec passage de la connection crée
        //DAO<Etudiant> objetdao = new EtudiantDAO(connection);
        // ETAPE 2 - ObjetDao Unitaire
        //EnseignantDAO objetdao = new EnseignantDAO(connection);
        // ETAPE 3 - On crée un objet POJO pour manipuler 
        // Configuration setter
        // ETAPE 4 - TEST des fonctions CREATE, DELETE, UPDATE, FIND
        //boolean executed = objetdao.create(obj);
        //System.out.println(executed);
        // FIND
        //Seance_groupes find = objetdao.find(1);
        //System.out.println(find.toString());
        
        // LOGGIN
        String email = "kevin.koy@edu.ece.fr";
        String passwd = "123";
        // BOUTTON: CONNEXION....
        // =>DAO: Data Acess Object, on va chercher dans la BDD
        UtilisateurDAO objetdao = new UtilisateurDAO(ConnectMySQL.getInstance());
        Utilisateur find = objetdao.find(email, passwd); // return (Utilisateur NULL ou Trouvé...)
        /// Si pas trouvé...
        if (find.getId() == 0) {
            System.out.println("Email ou mot de passe incorrect");
        }
        /// Sinon résultat, on appelle le constructeur de recherche_informations (initialisation).
        else {
            Recherche_informations  search = new Recherche_informations(email, passwd);
            System.out.println("Informations sur l'utilisateur:" + search.getUser());
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
