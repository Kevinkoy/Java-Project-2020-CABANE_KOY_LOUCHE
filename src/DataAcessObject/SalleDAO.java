package DataAcessObject;

import Modele.Cours;
import Modele.Salle;
import Modele.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class SalleDAO extends DAO<Salle> {

    public SalleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Salle obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `site`(`ID`, `Nom`,`Capacite`,`ID_Site`) VALUES(" + "NULL" + ",'" + obj.getNom() + "','" + obj.getCapacite() + "','" + obj.getSite().getId() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // On récupère ID Auto Incrementé, en recherchant par son nom
                int id = this.find(obj.getNom()).getId();
                obj.setId(id); // => et on adapte son ID;
                // Afficher de l'objet created (id updated)
                System.out.println("INSERTION Success:" + obj.toString());
                return true;
            } /// Duplicata sur clef UNIQUE, il existe déjà!
            else {
                throw new java.sql.SQLIntegrityConstraintViolationException();
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Salle obj) {
        // Copie en cas de delete réussi
        Salle copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `salle` WHERE ID ='" + obj.getId() + "';";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT   
            if (result == 1) {
                // Affichage de l'objet deleted
                System.out.println("DELETE Success:" + copie.toString());
                return true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Salle obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `salle` SET `ID`='" + obj.getId() + "',`Nom`='" + obj.getNom() + "',`Capacite`='" + obj.getCapacite() + "',`ID_Site`='" + obj.getSite().getId() + "' WHERE ID='" + obj.getId() + "'";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // Affichage de l'objet updated
                System.out.println("UPDATE Success:" + obj.toString());
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        return false;
    }

    @Override
    public Salle find(int id) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Salle returned = new Salle();
        try {
            // REQUETE
            String sql = "SELECT * FROM `salle` INNER JOIN site ON salle.ID_Site = site.ID WHERE salle.ID ='" + id + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Salle(result.getInt("salle.ID"), result.getString("salle.Nom"), result.getInt("salle.Capacite"), new Site(result.getInt("salle.ID_Site"), result.getString("site.Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Salle find(String nom) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Salle returned = new Salle();
        try {
            // REQUETE
            String sql = "SELECT * FROM `salle` INNER JOIN site ON salle.ID_Site = site.ID WHERE salle.Nom ='" + nom + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Salle(result.getInt("salle.ID"), result.getString("salle.Nom"), result.getInt("salle.Capacite"), new Site(result.getInt("salle.ID_Site"), result.getString("site.Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

    public Salle find(Salle obj) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Salle returned = new Salle();
        try {
            // REQUETE
            String sql = "SELECT * FROM `salle` INNER JOIN site ON salle.ID_Site = site.ID WHERE salle.ID ='" + obj.getId() + "' AND salle.Nom ='" + obj.getNom() + "' AND salle.Capacite ='" + obj.getCapacite() + "'AND salle.ID_Site = '" + obj.getSite().getId() + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                returned = new Salle(result.getInt("salle.ID"), result.getString("salle.Nom"), result.getInt("salle.Capacite"), new Site(result.getInt("salle.ID_Site"), result.getString("site.Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT....
        return returned;
    }
}
