package DataAcessObject;

import Modele.Groupe;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class GroupeDAO extends DAO<Groupe> {

    public GroupeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
