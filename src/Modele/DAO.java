package Modele;

import java.sql.Connection;
//import com.sdz.connection.SdzConnection;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection connection){
    this.connect = connection;
  }

  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode de suppression
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour des données
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
}
