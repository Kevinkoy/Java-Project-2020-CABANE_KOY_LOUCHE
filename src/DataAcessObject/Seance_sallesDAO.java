package DataAcessObject;

import Modele.Seance_salles;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class Seance_sallesDAO extends DAO<Seance_salles> {

    public Seance_sallesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_salles obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance_salles obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance_salles obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_salles find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
