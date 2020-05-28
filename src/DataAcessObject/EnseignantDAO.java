package DataAcessObject;

import Modele.Enseignant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class EnseignantDAO extends DAO<Enseignant> {

    public EnseignantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Enseignant obj) {
        // INSERT INTO 'utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        objetdao.create(obj); // obj.setID a été appelé, ID est auto incrémenté 
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `enseignant`(`ID_Utilisateur`, `ID_Cours`) VALUES('" + obj.getId() + "','" + obj.getCours().getId() + "');";
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
    public boolean delete(Enseignant obj) {
        // Delete en CASCADE FROM TABLE 'Utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        boolean delete = objetdao.delete(obj);

        // Copie en cas de delete réussi
        Enseignant copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `enseignant` WHERE `ID_Utilisateur` = " + obj.getId();
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
    public boolean update(Enseignant obj) {
        // UPDATE 'utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        objetdao.update(obj);
        
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `enseignant` SET `ID_Utilisateur`='" + obj.getId() + "',`ID_Cours`='" + obj.getCours().getId() + "' WHERE ID ='" + obj.getId() + "';";
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
    public Enseignant find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Enseignant returned = new Enseignant();
        try {
            // REQUETE
            String sql = "SELECT * FROM `enseignant` "
                    + " INNER JOIN `utilisateur` ON enseignant.ID_Utilisateur = utilisateur.ID "
                    + " INNER JOIN `cours` ON enseignant.ID_Cours = cours.ID "
                    + " WHERE enseignant.ID_Utilisateur = '" + id + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Enseignant(
                        result.getInt("enseignant.ID_Utilisateur"), // id
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Passwd"),
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        new Modele.Cours(result.getInt("enseignant.ID_Cours"), result.getString("cours.Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Enseignant find(String email) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Enseignant returned = new Enseignant();
        try {
            // REQUETE
            String sql = "SELECT * FROM `enseignant` "
                    + " INNER JOIN `utilisateur` ON enseignant.ID_Utilisateur = utilisateur.ID "
                    + " INNER JOIN `cours` ON enseignant.ID_Cours = cours.ID "
                    + " WHERE utilisateur.Email = '" + email + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Enseignant(
                        result.getInt("enseignant.ID_Utilisateur"), // id
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Passwd"),
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        new Modele.Cours(result.getInt("enseignant.ID_Cours"), result.getString("cours.Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

}
