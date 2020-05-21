package DataAcessObject;

import Modele.Type_cours;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class Type_coursDAO extends DAO<Type_cours> {

    public Type_coursDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type_cours find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
