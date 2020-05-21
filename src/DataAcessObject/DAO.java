package DataAcessObject;

import java.sql.Connection;
//import com.sdz.connection.SdzConnection;

/**
 * Pattern DAO: Ce pattern permet de faire le lien entre la couche d'accès aux
 * données et la couche métier d'une application (vos classes). Il s'agit ni
 * plus ni moins de faire en sorte qu'un type d'objet (objetDAO) se charge de
 * récupérer les données dans la base et qu'un autre type d'objet (souvent des
 * POJO: Plain Old Java Object)(=nos classes dans le package MODELE) soit
 * utilisé pour manipuler ces données.
 *
 * ___ Les ObjetsDAO auront des methodes CREATE,INSERT,DELETE,SELECT
 *
 *
 * @author KévinKOY
 * @param <T>
 */
public abstract class DAO<T> {

    protected Connection connection = null;

    public DAO(Connection connection) {

        this.connection = connection;
    }

    /**
     * Méthode de création
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode de suppression
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour des données
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations
     *
     * @param id
     * @return T
     */
    public abstract T find(int id);
}
