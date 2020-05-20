package projet_java;

import Modele.*;
import Modele.MaDate;

//import java.util.*;
import java.sql.*;
// TEST

/**
 *
 * @author KévinKOY, AliceCABANE, SylvainLOUCHE, Student at ECE PARIS, PROJET
 * JAVA 2020 ING3_TD4
 */
public class Tester {

    public static void main(String[] args) {
        // DECLARATION && INITIALISATION
        int id_seance = 1;

        int jour = 20;
        int mois = 05;
        int annee = 2020;
        MaDate date = new Modele.MaDate(jour, mois, annee);

        Time heure_debut = new Time(0, 0, 0);
        Time heure_fin = new Time(1, 30, 0);
        int etat = 0; // 0 default en cours de validation | 1 valide

        int id_cours = 1;
        String nom_cours = "Mathematiques";
        Cours cours = new Modele.Cours(id_cours, nom_cours);

        int id_type = 1;
        String nom_type = "Cours Magistral";
        Type_cours type_cours = new Modele.Type_cours(id_type, nom_type);

        Seance maSeance = new Modele.Seance(id_seance, date, heure_debut, heure_fin, etat, cours, type_cours);

        /// Display
        System.out.print(maSeance.toString());

    }
}
