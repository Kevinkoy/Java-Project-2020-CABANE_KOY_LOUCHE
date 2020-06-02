package DataAcessObject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author OpenClassRoom
 */
public class ConnectMySQL {

    /// ATTRIBUTS //////////////////////////////////////////////////////////////
    private static Connection connect;

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

    }

    /// METHODES ///////////////////////////////////////////////////////////////
    /**
     * Méthode qui va retourner notre instance et la créer si elle n'existe
     * pas...
     *
     * @return - connect
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
     * @return connect
     */
    public static Connection getConnect() {
        return connect;
    }

    /**
     *
     * @return url
     */
    public static String getUrl() {
        return url;
    }

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

    ////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param connect
     */
    public static void setConnect(Connection connect) {
        ConnectMySQL.connect = connect;
    }

    /**
     *
     * @param url
     */
    public static void setUrl(String url) {
        ConnectMySQL.url = url;
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
