package DataAcessObject;

import Modele.Seance;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class SeanceDAO extends DAO<Seance>{

    public SeanceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
