package DataAcessObject;

import Modele.Etudiant;
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
public class EtudiantDAO extends DAO<Etudiant> {

    public EtudiantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Etudiant obj) {
        // INSERT INTO 'utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        objetdao.create(obj); // obj.setID a été appelé, ID est auto incrémenté 
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `etudiant`(`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES('" + obj.getId() + "','" + obj.getNumero() + "','" + obj.getGroupe().getId() + "');";
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
    public boolean delete(Etudiant obj) {
        // Delete en CASCADE FROM TABLE 'Utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        boolean delete = objetdao.delete(obj);
        return delete;
        /*
        // Copie en cas de delete réussi
        Etudiant copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `etudiant` WHERE `ID_Utilisateur` = " + obj.getId();
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
        return false;*/
    }

    @Override
    public boolean update(Etudiant obj) {
        // UPDATE 'utilisateur'
        UtilisateurDAO objetdao = new UtilisateurDAO(this.connection);
        objetdao.update(obj);

        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `etudiant` SET `ID`= '" + obj.getId() + "',`Numero`= '" + obj.getNumero() + "',`ID_Groupe`= '" + obj.getGroupe().getId() + "' WHERE ID_Utilisateur = '" + obj.getId() + "'";
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
    public Etudiant find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Etudiant returned = new Etudiant();
        try {
            // REQUETE
            String sql = "SELECT * FROM `etudiant` INNER JOIN `utilisateur` ON etudiant.ID_Utilisateur = utilisateur.ID INNER JOIN `groupe` ON etudiant.ID_Groupe = groupe.ID INNER JOIN `promotion` ON groupe.ID_Promotion = promotion.ID WHERE etudiant.ID_Utilisateur ='" + id + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Etudiant(
                        result.getInt("etudiant.ID_Utilisateur"), // id,
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Passwd"),
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        result.getInt("etudiant.Numero"),
                        new Groupe(result.getInt("etudiant.ID_Groupe"), result.getString("groupe.Nom"), new Promotion(result.getInt("groupe.ID_Promotion"), result.getString("Promotion.Nom"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Etudiant find(String email) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Etudiant returned = new Etudiant();
        try {
            // REQUETE
            String sql = "SELECT * FROM `etudiant` INNER JOIN `utilisateur` ON etudiant.ID_Utilisateur = utilisateur.ID INNER JOIN `groupe` ON etudiant.ID_Groupe = groupe.ID INNER JOIN `promotion` ON groupe.ID_Promotion = promotion.ID WHERE utilisateur.Email ='" + email + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Etudiant(
                        result.getInt("etudiant.ID_Utilisateur"), // id,
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Passwd"),
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        result.getInt("etudiant.Numero"),
                        new Groupe(result.getInt("etudiant.ID_Groupe"), result.getString("groupe.Nom"), new Promotion(result.getInt("groupe.ID_Promotion"), result.getString("Promotion.Nom"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }
}
