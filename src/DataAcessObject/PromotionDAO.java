package DataAcessObject;

import Modele.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class PromotionDAO extends DAO<Promotion> {

    public PromotionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Promotion obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `promotion`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + obj.getNom() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // On récupère ID Auto Incrementé, en recherchant par son nom
                int id = this.find(obj.getNom()).getId();
                obj.setId(id); // => et on adapte son ID;
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
    public boolean delete(Promotion obj) {
        // Copie en cas de delete réussi
        Promotion copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `promotion` WHERE ID ='" + obj.getId() + "' AND Nom ='" + obj.getNom() + "'";
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
    public boolean update(Promotion obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `promotion` SET `ID`='" + obj.getId() + "',`Nom`='" + obj.getNom() + "' WHERE ID='" + obj.getId() + "'";
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
    public Promotion find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Promotion returned = new Promotion();
        try {
            // REQUETE
            String sql = "SELECT * FROM `promotion` WHERE ID ='" + id + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Promotion(result.getInt("ID"), result.getString("Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Promotion find(String nom) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Promotion returned = new Promotion();
        try {
            // REQUETE
            String sql = "SELECT * FROM `promotion` WHERE Nom ='" + nom + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Promotion(result.getInt("ID"), result.getString("Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

    public Promotion find(Promotion obj) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Promotion returned = new Promotion();
        try {
            // REQUETE
            String sql = "SELECT * FROM `promotion` WHERE ID ='" + obj.getId() + "' AND Nom='" + obj.getNom() + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Promotion(result.getInt("ID"), result.getString("Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

}
