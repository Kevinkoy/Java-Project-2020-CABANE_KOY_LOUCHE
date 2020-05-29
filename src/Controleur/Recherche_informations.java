/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DataAcessObject.ConnectMySQL;
import DataAcessObject.DAO;
import DataAcessObject.Seance_groupesDAO;
import Modele.Seance_groupes;
import java.sql.Connection;

/**
 *
 * @author KévinKOY
 */
public class Recherche_informations {
    
    public DAO<Seance_groupes> Seance_groupes()
    {
        Connection connection = ConnectMySQL.getInstance();
        DAO<Seance_groupes> objetdao = new Seance_groupesDAO(connection);
                
        return objetdao;
        
    }
}
