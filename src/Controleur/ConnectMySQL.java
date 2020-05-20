package Controleur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectMySQL {

    ///  ATTRIBUTS
    static Connection cnx;
    static Statement st;
    static ResultSet rst;
    static boolean accepted;
    private String user;
    private String password;
    private String NomTable;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public ConnectMySQL() {
        user = "";
        password = "";
        NomTable = "";
    }

    /**
     * Constructeur surchargé
     *
     * @param user String
     * @param password String
     * @param NomTable String
     */
    public ConnectMySQL(String user, String password, String NomTable) {
        this.user = user;
        this.password = password;
        this.NomTable = NomTable;
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     *
     * @return NomTable
     */
    public String getNomTable() {
        return NomTable;
    }

    /**
     *
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     *
     * @param NomTable
     */
    public void setNomTable(String NomTable) {
        this.NomTable = NomTable;
    }
}
