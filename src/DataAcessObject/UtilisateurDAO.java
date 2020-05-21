package DataAcessObject;

import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {

        Utilisateur utilisateur = new Utilisateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Utilisateur WHERE ID = " + id);
            if (result.first()) {
                utilisateur = new Utilisateur(
                        id,
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

}
