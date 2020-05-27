package DataAcessObject;

import Modele.Etudiant;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class EtudiantDAO extends DAO<Etudiant> {

    public EtudiantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
