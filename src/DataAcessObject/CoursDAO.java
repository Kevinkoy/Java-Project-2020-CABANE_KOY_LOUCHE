package DataAcessObject;

import Modele.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class CoursDAO extends DAO<Cours> {

    public CoursDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Cours obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `cours`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + obj.getNom() + "');";
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
    public boolean delete(Cours obj) {
        // Copie en cas de delete réussi
        Cours copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `cours` WHERE cours.ID ='" + obj.getId() + "' AND cours.Nom ='" + obj.getNom() + "'";
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
    public boolean update(Cours obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `cours` SET `ID`='" + obj.getId() + "',`Nom`='" + obj.getNom() + "' WHERE ID='" + obj.getId() + "'";
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
    public Cours find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Cours returned = new Cours();
        try {
            // REQUETE
            String sql = "SELECT * FROM `cours` WHERE cours.ID ='" + id + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Cours find(String nom) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Cours returned = new Cours();
        try {
            // REQUETE
            String sql = "SELECT * FROM `cours` WHERE cours.Nom ='" + nom + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

    public Cours find(Cours obj) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Cours returned = new Cours();
        try {
            // REQUETE
            String sql = "SELECT * FROM `cours` WHERE cours.ID ='" + obj.getId() + "' AND cours.Nom='" + obj.getNom() + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

}
