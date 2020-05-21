package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        ///************************* A CHANGERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr
        Enseignant enseignant = new Enseignant();

        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignant WHERE ID = " + id);
            if (result.first()) {
                enseignant = new Enseignant(
                        id,
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        new Modele.Cours()
                        //result.getInt("ID_Cours")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }

}
