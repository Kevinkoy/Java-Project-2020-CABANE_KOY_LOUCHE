package DataAcessObject;

import Modele.Cours;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        // ETAPE 1: VERIFICATION si il existe...
        Cours find = this.find(obj);

        // Il n'existe pas!
        if (find.getId() == 0) {
            try {

                // ETAPE 2 : CREATE (ID value NULL pour Auto-incrémentation)
                // REQUETE SQL
                String sql = "INSERT INTO `cours`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + obj.getNom() + "');";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    // On récupère ID Auto Incrementé => et on adapte son ID;
                    obj.setId(this.find(obj).getId());
                    System.out.println("INSERTION Success:" + obj.toString()); // ID mis à jour, on affiche ses infos
                    return true;
                } else {
                    throw new java.sql.SQLIntegrityConstraintViolationException();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
                //e.printStackTrace();
                //System.out.println("Impossible de se connecter!");
            }

        } // déjà existant...
        System.out.println(find.toString()); // toString id=0 ("INTROUVABLE")
        return false;
    }

    @Override
    public boolean delete(Cours obj) {
        try {
            // ETAPE 1: VERIFICATION si il existe...
            Cours find = this.find(obj);

            // Il existe!
            if (find.getId() != 0) {
                // ETAPE 2 : DELETE
                // REQUETE SQL
                String sql = "DELETE FROM `cours` WHERE cours.ID ='" + obj.getId() + "' AND cours.Nom ='" + obj.getNom() + "'";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT   
                if (result == 1) {
                    System.out.println("DELETE Success:" + find.toString()); // Affichage de l'objet supprimé
                    return true;
                }
                // Il n'existe pas
            } else {
                System.out.println(find.toString()); // toString id=0 ("INTROUVABLE")
                return false;
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Cours obj) {
        try {
            // ETAPE 1: VERIFICATION si il existe...
            Cours find = this.find(obj);

            // Il existe!
            if (find.getId() != 0) {
                // ETAPE 2 : UPDATE
                // REQUETE SQL
                String sql = "UPDATE `cours` SET `ID`='" + obj.getId() + "',`Nom`='" + obj.getNom() + "' WHERE ID='" + obj.getId() + "'";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    System.out.println("UPDATE Success:" + obj.toString()); // Affichage update
                    return true;
                }
                // Il n'existe pas
            } else {
                System.out.println(find.toString()); // toString id=0 ("INTROUVABLE")
                return false;
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cours find(int id) {

        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Cours obj_returned = new Cours();

        // REQUETE
        String sql = "SELECT * FROM `cours` WHERE cours.ID ='" + id + "'";

        try {
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);

            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// Récupérer le resultat trouvé...
                obj_returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");        
            e.printStackTrace();
        }
        // return soit NULL || soit resultat....
        return obj_returned;
    }

    public Cours find(Cours obj) {

        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Cours obj_returned = new Cours();

        // REQUETE
        String sql = "SELECT * FROM `cours` WHERE cours.ID ='" + obj.getId() + "' AND cours.Nom='" + obj.getNom() + "'";

        try {
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);

            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// Récupérer le resultat trouvé...
                obj_returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");        
            e.printStackTrace();
        }
        // return soit NULL || soit resultat....
        return obj_returned;
    }

}
