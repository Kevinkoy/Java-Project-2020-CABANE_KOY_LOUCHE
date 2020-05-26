package DataAcessObject;

import Modele.Groupe;
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
public class GroupeDAO extends DAO<Groupe> {

    public GroupeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Groupe obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `groupe`(`ID`,`Nom`,`ID_Promotion`) VALUES(" + "NULL" + ",'" + obj.getNom() + "','"+ obj.getPromotion()+  "');";
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
    public boolean delete(Groupe obj) {
        // Copie en cas de delete réussi
        Groupe copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `groupe` WHERE ID ='" + obj.getId() + "' AND Nom ='" + obj.getNom() + "' AND ID_Promotion = '"+ obj.getPromotion()+"'";
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
    public boolean update(Groupe obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `groupe` SET `ID`='" + obj.getId() + "',`Nom`='" + obj.getNom() +"',`ID_Promotion`='" + obj.getPromotion() + "' WHERE ID='" + obj.getId() + "'";
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
    public Groupe find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Groupe returned = new Groupe();
        try {
            // REQUETE
            String sql = "SELECT * FROM `Groupe`INNER JOIN `Promotion` ON Groupe.ID_Promotion = Promotion.ID WHERE Groupe.ID ='" + id + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Groupe(result.getInt("Groupe.ID"), result.getString("Groupe.Nom"), new Promotion(result.getInt("Groupe.ID_Promotion"), result.getString("Promotion.Nom"))) ;
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Groupe find(String nom) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Groupe returned = new Groupe();
        try {
            // REQUETE
            String sql = "SELECT * FROM `Groupe`INNER JOIN `Promotion` ON Groupe.ID_Promotion = Promotion.ID WHERE Groupe.Nom ='" + nom + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned =  new Groupe(result.getInt("Groupe.ID"), result.getString("Groupe.Nom"), new Promotion(result.getInt("Groupe.ID_Promotion"), result.getString("Promotion.Nom"))) ;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

    public Groupe find(Groupe obj) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Groupe returned = new Groupe();
        try {
            // REQUETE
           String sql =  "SELECT * FROM `groupe`INNER JOIN `Promotion` ON Groupe.ID_Promotion = Promotion.ID WHERE Groupe.ID ='" + obj.getId() + "', Groupe.Nom='"+ obj.getNom()+"' AND, Groupe.ID_Promotion='" + obj.getPromotion().getId()+"';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned =  new Groupe(result.getInt("Groupe.ID"), result.getString("Groupe.Nom"), new Promotion(result.getInt("Groupe.ID_Promotion"), result.getString("Promotion.Nom"))) ;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }

}
