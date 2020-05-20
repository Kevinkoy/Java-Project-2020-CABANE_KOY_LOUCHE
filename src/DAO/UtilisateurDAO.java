package DAO;

import Modele.Utilisateur;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class UtilisateurDAO extends DAO<Utilisateur>{

    public UtilisateurDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
