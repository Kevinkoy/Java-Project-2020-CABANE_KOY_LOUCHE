package DataAcessObject;

import Modele.Cours;
import Modele.Seance;
import Modele.Type_cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KÃ©vinKOY
 */
public class SeanceDAO extends DAO<Seance> {

    public SeanceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrÃ©mentation)
            String sql = "INSERT INTO `seance`(`ID`, `Semaine`, `Date`, `Heure_Debut`, `Heure_Fin`, `Etat`, `ID_Cours`, `ID_Type`) VALUES ("
                    + "NULL" + ",'"
                    + obj.getSemaine() + "','"
                    + obj.getDate() + "','"
                    + obj.getHeure_debut() + "','"
                    + obj.getHeure_fin() + "','"
                    + obj.getEtat() + "','"
                    + obj.getCours().getId() + "','"
                    + obj.getType_cours().getId() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // Afficher de l'objet created (id updated)
                System.out.println("INSERTION Success:" + obj.toString());
                return true;
            } /// Duplicata sur clef UNIQUE, il existe dÃ©jÃ !
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
    public boolean delete(Seance obj) {
        // Copie en cas de delete rÃ©ussi
        Seance copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `seance` WHERE `ID` ='" + obj.getId() + "';";
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
    public boolean update(Seance obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `seance` SET "
                    + "`ID`='" + obj.getId()
                    + "',`Semaine`='" + obj.getSemaine()
                    + "',`Date`='" + obj.getDate()
                    + "',`Heure_debut`='" + obj.getHeure_debut()
                    + "',`Heure_fin`='" + obj.getHeure_fin()
                    + "',`Etat`='" + obj.getEtat()
                    + "',`ID_Cours`='" + obj.getCours().getId()
                    + "',`ID_Type`='" + obj.getType_cours().getId()
                    + "');";
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
    public Seance find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance returned = new Seance();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance` "
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID "
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID "
                    + "WHERE seance.ID ='" + id + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance.ID"));
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

                returned = seance;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }
}
