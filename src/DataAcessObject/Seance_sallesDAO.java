package DataAcessObject;

import Modele.Cours;
import Modele.Salle;
import Modele.Seance;
import Modele.Seance_salles;
import Modele.Site;
import Modele.Type_cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class Seance_sallesDAO extends DAO<Seance_salles> {

    public Seance_sallesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_salles obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `seance_salles`(`ID_Seance`, `ID_Salle`) VALUES ('" + obj.getSeance().getId() + "','" + obj.getSalle().getId() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // Afficher de l'objet created (id updated)
                System.out.println("INSERTION Success:" + obj.toString());
                return true;
            } /// Duplicata sur clef UNIQUE, il existe déjà!
            else {
                throw new java.sql.SQLIntegrityConstraintViolationException();
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Seance_salles obj) {
        // Copie en cas de delete réussi
        Seance_salles copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `seance_salles` WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Salle` ='" + obj.getSalle().getId() + "' ;";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT   
            if (result == 1) {
                // Affichage de l'objet deleted
                System.out.println("DELETE Success:" + copie.toString());
                return true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;

    }

    @Override
    public boolean update(Seance_salles obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `seance_salles` SET `ID_Seance`='" + obj.getSeance().getId() + "',`ID_Salle`='" + obj.getSalle().getId() + "' WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Salle` ='" + obj.getSalle().getId() + "' ;";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // Affichage de l'objet updated
                System.out.println("UPDATE Success:" + obj.toString());
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        return false;
    }

    @Override
    public Seance_salles find(int id_seance) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_salles returned = new Seance_salles();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_salles`\n"
                    + "INNER JOIN `seance`ON seance_salles.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"
                    + "INNER JOIN `salle`ON seance.ID_Salle = salle.ID\n"
                    + "INNER JOIN `site`ON salle.ID_Site = site.ID\n"
                    + "WHERE seance_salles.ID_Seance ='" + id_seance + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_salles.ID_Seance"));
                seance.setSemaine(result.getInt("seance.Semaine"));
                seance.setDate(result.getDate("seance.Date"));
                seance.setHeure_debut(result.getTime("seance.Heure_Debut"));
                seance.setHeure_fin(result.getTime("seance.Heure_Fin"));
                seance.setEtat(result.getInt("seance.Etat"));
                /// ***
                Cours cours = new Cours();
                cours.setId(result.getInt("seance.ID_Cours"));
                cours.setNom(result.getString("cours.Nom"));
                /// *** 
                seance.setCours(cours);

                ///***
                Type_cours type_cours = new Type_cours();
                type_cours.setId(result.getInt("seance.ID_Type"));
                type_cours.setNom("type_cours.Nom");
                ///*** 
                seance.setType_cours(type_cours);

                ///***
                Salle salle = new Salle();
                salle.setId(result.getInt("seance_salles.ID_Salle"));
                salle.setNom(result.getString("salle.Nom"));
                salle.setCapacite(result.getInt("salle.Capacite"));

                ///***
                Site site = new Site();
                site.setId(result.getInt("salle.ID_Site"));
                site.setNom("site.Nom");

                salle.setSite(site);

                returned = new Seance_salles(seance, salle);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Seance_salles find_by_id_salle(int id_salle) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_salles returned = new Seance_salles();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_salles`\n"
                    + "INNER JOIN `seance`ON seance_salles.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"
                    + "INNER JOIN `salle`ON seance.ID_Salle = salle.ID\n"
                    + "INNER JOIN `site`ON salle.ID_Site = site.ID\n"
                    + "WHERE seance_salles.ID_Salle ='" + id_salle + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_salles.ID_Seance"));
                seance.setSemaine(result.getInt("seance.Semaine"));
                seance.setDate(result.getDate("seance.Date"));
                seance.setHeure_debut(result.getTime("seance.Heure_Debut"));
                seance.setHeure_fin(result.getTime("seance.Heure_Fin"));
                seance.setEtat(result.getInt("seance.Etat"));
                /// ***
                Cours cours = new Cours();
                cours.setId(result.getInt("seance.ID_Cours"));
                cours.setNom(result.getString("cours.Nom"));
                /// *** 
                seance.setCours(cours);

                ///***
                Type_cours type_cours = new Type_cours();
                type_cours.setId(result.getInt("seance.ID_Type"));
                type_cours.setNom("type_cours.Nom");
                ///*** 
                seance.setType_cours(type_cours);

                ///***
                Salle salle = new Salle();
                salle.setId(result.getInt("seance_salles.ID_Salle"));
                salle.setNom(result.getString("salle.Nom"));
                salle.setCapacite(result.getInt("salle.Capacite"));

                ///***
                Site site = new Site();
                site.setId(result.getInt("salle.ID_Site"));
                site.setNom("site.Nom");

                salle.setSite(site);

                returned = new Seance_salles(seance, salle);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

}
