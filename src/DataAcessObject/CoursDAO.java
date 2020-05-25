package DataAcessObject;

import Modele.Cours;
import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            ///  ETAPE 1 - Vérification si il existe... par id
            Cours u_create_id = this.find(cours.getId());

            // Il n'existe pas encore alors (ID et EMAIL dispo)
            if (u_create_id.getId() == 0) {
                /// ETAPE 2 : CREATE (ID value NULL, Auto-incrémentation)
                // REQUETE SQL
                String sql = "INSERT INTO `utilisateur`(`ID`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES(" + "NULL" + ",'" + cours.getEmail() + "','" + cours.getPasswd() + "'  ,'" + cours.getNom() + "','" + cours.getPrenom() + "' ,'" + cours.getDroit() + "'  )";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    System.out.println("INSERTION Sucess: " + this.find(cours.getEmail()).toString()); // On le recherche par EMAIL car id auto-incremented, et on l'affiche (***)
                    // On récupère ID Auto Incrementé => et on change son ID;
                    cours.setId(this.find(cours.getEmail()).getId());
                    return true;
                }
                // UTILISATEUR DEJA EXISTANT!
            } else {
                System.out.println("INSERTION Fail!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // System.out.println("Base de donnée introuvable");
        }
        return false;

    }

    @Override
    public boolean delete(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
