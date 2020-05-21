package DataAcessObject;

import Modele.Site;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class SiteDAO extends DAO<Site> {

    public SiteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Site find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
