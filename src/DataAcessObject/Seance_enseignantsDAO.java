package DataAcessObject;

import Modele.Seance_enseignants;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {

    public Seance_enseignantsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_enseignants obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance_enseignants obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance_enseignants obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_enseignants find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
