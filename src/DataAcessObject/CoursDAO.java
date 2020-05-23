package DataAcessObject;

import Modele.Cours;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class CoursDAO extends DAO<Cours>{

    public CoursDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
