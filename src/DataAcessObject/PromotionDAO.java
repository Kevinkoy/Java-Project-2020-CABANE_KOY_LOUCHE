package DataAcessObject;

import Modele.Promotion;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class PromotionDAO extends DAO<Promotion> {

    public PromotionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Promotion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Promotion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Promotion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Promotion find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
