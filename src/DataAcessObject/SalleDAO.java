package DataAcessObject;

import Modele.Salle;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class SalleDAO extends DAO<Salle> {

    public SalleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
