package DataAcessObject;

import Modele.Enseignant;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant find(int id) {

        Enseignant enseignant = new Enseignant();
        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `enseignant`INNER JOIN utilisateur ON enseignant.ID_Utilisateur = utilisateur.ID WHERE ID=" + id);

            // SI RESULTAT
            if (result.next()) {
                enseignant = new Enseignant(
                        id,
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Passwd"),
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        new Modele.Cours(result.getInt("enseignant.ID_Cours"), "vide")
                );
            } else {
                throw new IOException();
            }

        } catch (SQLException e) {
            //e.printStackTrace();

        } catch (IOException ex) {
            // System.out.print("ENSEIGNANT INTROUVABLE");
            //Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enseignant;
    }

}
