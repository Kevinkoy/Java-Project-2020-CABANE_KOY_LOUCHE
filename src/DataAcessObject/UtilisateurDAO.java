package DataAcessObject;

import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    public UtilisateurDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Utilisateur obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `utilisateur`(`ID`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES(" + "NULL" + ",'" + obj.getEmail() + "','" + obj.getPasswd() + "'  ,'" + obj.getNom() + "','" + obj.getPrenom() + "' ,'" + obj.getDroit() + "'  )";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // On récupère ID Auto Incrementé, en recherchant par son nom
                int id = this.find(obj.getEmail()).getId();
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
    public boolean delete(Utilisateur obj) {
        // Copie en cas de delete réussi
        Utilisateur copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM utilisateur WHERE utilisateur.ID = " + obj.getId();
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
    public boolean update(Utilisateur obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `utilisateur` SET `ID`= '" + obj.getId() + "' ,`Email`= '" + obj.getEmail() + "' ,`Passwd`= '" + obj.getPasswd() + "' ,`Nom`= '" + obj.getNom() + "' ,`Prenom`= '" + obj.getPrenom() + "' ,`Droit`= '" + obj.getDroit() + "' WHERE ID = '" + obj.getId() + "'";
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
    public Utilisateur find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Utilisateur returned = new Utilisateur();
        try {
            // REQUETE
            String sql = "SELECT * FROM Utilisateur WHERE ID = '" + id + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Utilisateur(
                        result.getInt("ID"), // id,
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Utilisateur find(String email) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Utilisateur returned = new Utilisateur();
        try {
            // REQUETE
            String sql = "SELECT * FROM Utilisateur WHERE Email = '" + email + "'";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Utilisateur(
                        result.getInt("ID"),
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

}
