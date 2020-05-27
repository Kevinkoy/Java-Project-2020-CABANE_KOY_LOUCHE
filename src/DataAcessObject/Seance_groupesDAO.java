package DataAcessObject;

import Modele.Seance_groupes;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class Seance_groupesDAO extends DAO<Seance_groupes> {

    public Seance_groupesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_groupes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance_groupes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance_groupes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_groupes find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
