package DataAcessObject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author OpenClassRoom
 */
public class ConnectMySQL {

    /// ATTRIBUTS //////////////////////////////////////////////////////////////
    private static Connection connect;
    private static Statement st;
    private static ResultSet rst;

    /**
     * phpMyAdmin: URL de connection
     */
    private static String url = "jdbc:mysql://localhost:3306/eceplanning";
    /**
     * phpMyAdmin: Utilisateur
     */
    private static String user = "root";
    /**
     * phpMyAdmin: Mot de passe
     */
    private static String passwd = "";

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public ConnectMySQL() {
        ConnectMySQL.user = "";
        ConnectMySQL.passwd = "";
    }

    /**
     * Constructeur surchargé
     *
     * @param user String
     * @param password String
     */
    public ConnectMySQL(String user, String password) {
        ConnectMySQL.user = user;
        ConnectMySQL.passwd = password;
    }

    /// METHODES ///////////////////////////////////////////////////////////////
    /**
     * Méthode qui va retourner notre instance et la créer si elle n'existe
     * pas...
     *
     * @return
     */
    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
            }
        }
        return connect;
    }

    /// ACCESSEURS : GETTERS & SETTERS /////////////////////////////////////////
    /**
     *
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     *
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     *
     *
     * @param user
     */
    public void setUser(String user) {
        ConnectMySQL.user = user;
    }

    /**
     *
     *
     * @param passwd
     */
    public void setPasswd(String passwd) {
        ConnectMySQL.passwd = passwd;
    }

}
