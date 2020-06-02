package DataAcessObject;

import Modele.Seance_enseignants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {

    public Seance_enseignantsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_enseignants obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `seance_enseignants`(`ID_Seance`, `ID_Enseignant`) VALUES ('" + obj.getSeance().getId() + "','" + obj.getEnseignant().getId() + "');";
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
    public boolean delete(Seance_enseignants obj) {
        // Copie en cas de delete réussi
        Seance_enseignants copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `seance_enseignants` WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Enseignant` ='" + obj.getEnseignant().getId() + "' ;";
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
    public boolean update(Seance_enseignants obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `seance_enseignants` SET `ID_Seance`='" + obj.getSeance().getId() + "',`ID_Enseignant`='" + obj.getEnseignant().getId() + "' WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Enseignant` ='" + obj.getEnseignant().getId() + "' ;";
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
    public Seance_enseignants find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
