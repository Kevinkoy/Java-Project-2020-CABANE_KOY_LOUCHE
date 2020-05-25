package DataAcessObject;

import Modele.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KévinKOY
 */
public class CoursDAO extends DAO<Cours> {

    public CoursDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Cours cours) {
        try {
            // ETAPE 1: VERIFICATION si il existe...
            Cours create = this.find(cours);

            // Il n'existe pas!
            if (create.getId() == 0) {
                // ETAPE 2 : CREATE (ID value NULL pour Auto-incrémentation)
                // REQUETE SQL
                String sql = "INSERT INTO `utilisateur`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + cours.getNom() + "');";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    // On récupère ID Auto Incrementé => et on adapte son ID;
                    cours.setId(this.find(cours).getId());
                    System.out.println("INSERTION Success:" + cours.toString()); // ID mis à jour, on affiche ses infos
                    return true;
                }
                // déjà existant...
            } else {
                System.out.println(create.toString()); // toString id=0 ("INTROUVABLE")
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // System.out.println("Base de donnée introuvable");
        }
        return false;

    }

    @Override
    public boolean delete(Cours cours) {
        try {
            // ETAPE 1: VERIFICATION si il existe...
            Cours delete = this.find(cours);

            // Il existe!
            if (delete.getId() != 0) {
                // ETAPE 2 : DELETE (INSERT INTO nomTable('ID') value (NULL) pour Auto-incrémentation)
                // REQUETE SQL
                String sql = "INSERT INTO `utilisateur`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + cours.getNom() + "');";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    // On récupère ID Auto Incrementé => et on adapte son ID;
                    cours.setId(this.find(cours).getId());
                    System.out.println("INSERTION Success:" + cours.toString()); // ID mis à jour, on affiche ses infos
                    return true;
                }
                // Il n'existe pas
            } else {
                System.out.println(delete.toString()); // toString id=0 ("INTROUVABLE")
                return false;
            }
        } catch (SQLException e) {
            // System.out.println("Base de donnée introuvable");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Cours obj) {
            try {
            // ETAPE 1: VERIFICATION si il existe...
            Cours update = this.find(obj);

            // Il existe!
            if (update.getId() != 0) {
                // ETAPE 2 : UPDATE ID Value NULL pour Auto-Incrementations
                // REQUETE SQL
                String sql = "UPDATE `utilisateur`(`ID`, `Nom`) VALUES(" + "NULL" + ",'" + obj.getNom() + "');";
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
                }
                // Il n'existe pas
            } else {
                System.out.println(update.toString()); // toString id=0 ("INTROUVABLE")
                return false;
            }
        } catch (SQLException e) {
            // System.out.println("Base de donnée introuvable");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cours find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cours find(Cours cours) {

        /// UTILISATEUR NULL (PAR DEFAUT)
        Cours cours_returned = new Cours();

        // REQUETE
        String sql = "SELECT * FROM `cours` WHERE cours.ID ='" + cours.getId() + "' AND cours.Nom='" + cours.getNom() + "'";

        try {
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);

            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// Récupérer le resultat trouvé...
                cours_returned = new Cours(result.getInt("cours.ID"), result.getString("cours.Nom"));
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");        
            e.printStackTrace();
        }
        // return soit NULL || soit resultat....
        return cours_returned;
    }

}
