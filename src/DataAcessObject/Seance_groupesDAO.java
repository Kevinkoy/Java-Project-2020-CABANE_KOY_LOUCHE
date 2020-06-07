package DataAcessObject;

import Modele.Cours;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Seance;
import Modele.Seance_groupes;
import Modele.Type_cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KÃ©vinKOY
 */
public class Seance_groupesDAO extends DAO<Seance_groupes> {

    public Seance_groupesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_groupes obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrÃ©mentation)
            String sql = "INSERT INTO `seance_groupes`(`ID_Seance`, `ID_Groupe`) VALUES ('" + obj.getSeance().getId() + "','" + obj.getGroupe().getId() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                // Afficher de l'objet created (id updated)
                System.out.println("INSERTION Success:" + obj.toString());
                return true;
            } /// Duplicata sur clef UNIQUE, il existe dÃ©jÃ !
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
    public boolean delete(Seance_groupes obj) {
        // Copie en cas de delete rÃ©ussi
        Seance_groupes copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `seance_groupes` WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Groupe` ='" + obj.getGroupe().getId() + "' ;";
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
    public boolean update(Seance_groupes obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `seance_groupes` SET `ID_Seance`='" + obj.getSeance().getId() + "',`ID_Groupe`='" + obj.getGroupe().getId() + "' WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Groupe` ='" + obj.getGroupe().getId() + "' ;";
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
    public Seance_groupes find(int id_seance) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_groupes returned = new Seance_groupes();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_groupes`\n"
                    + "INNER JOIN `seance`ON seance_groupes.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"                  
                    + "INNER JOIN `groupe`ON seance_groupes.ID_Groupe = groupe.ID\n"
                    + "INNER JOIN `promotion`ON groupe.ID_Promotion = promotion.ID\n"
                    + "WHERE seance_groupes.ID_Seance ='" + id_seance + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_groupes.ID_Seance"));
                seance.setSemaine(result.getInt("seance.Semaine"));
                seance.setDate(result.getDate("seance.Date"));
                seance.setHeure_debut(result.getTime("seance.Heure_Debut"));
                seance.setHeure_fin(result.getTime("seance.Heure_Fin"));
                seance.setEtat(result.getInt("seance.Etat"));
                /// ***
                Cours cours = new Cours();
                cours.setId(result.getInt("seance.ID_Cours"));
                cours.setNom(result.getString("cours.Nom"));
                /// *** 
                seance.setCours(cours);

                ///***
                Type_cours type_cours = new Type_cours();
                type_cours.setId(result.getInt("seance.ID_Type"));
                type_cours.setNom("type_cours.Nom");
                ///*** 
                seance.setType_cours(type_cours);

                Groupe groupe = new Groupe();
                groupe.setId(result.getInt("seance_groupes.ID_Groupe"));
                groupe.setNom(result.getString("groupe.Nom"));
                
                Promotion promotion = new Promotion();
                promotion.setId(result.getInt("groupe.ID_Promotion"));
                promotion.setNom(result.getString("promotion.Nom"));
                
                groupe.setPromotion(promotion);

                returned = new Seance_groupes(seance, groupe);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }
    
     public Seance_groupes find_by_id_groupe(int id_groupe) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_groupes returned = new Seance_groupes();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_groupes`\n"
                    + "INNER JOIN `seance`ON seance_groupes.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"                  
                    + "INNER JOIN `groupe`ON seance_groupes.ID_Groupe = groupe.ID\n"
                    + "INNER JOIN `promotion`ON groupe.ID_Promotion = promotion.ID\n"
                    + "WHERE seance_groupes.ID_Groupe ='" + id_groupe + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_groupes.ID_Seance"));
                seance.setSemaine(result.getInt("seance.Semaine"));
                seance.setDate(result.getDate("seance.Date"));
                seance.setHeure_debut(result.getTime("seance.Heure_Debut"));
                seance.setHeure_fin(result.getTime("seance.Heure_Fin"));
                seance.setEtat(result.getInt("seance.Etat"));
                /// ***
                Cours cours = new Cours();
                cours.setId(result.getInt("seance.ID_Cours"));
                cours.setNom(result.getString("cours.Nom"));
                /// *** 
                seance.setCours(cours);

                ///***
                Type_cours type_cours = new Type_cours();
                type_cours.setId(result.getInt("seance.ID_Type"));
                type_cours.setNom("type_cours.Nom");
                ///*** 
                seance.setType_cours(type_cours);

                Groupe groupe = new Groupe();
                groupe.setId(result.getInt("seance_groupes.ID_Groupe"));
                groupe.setNom(result.getString("groupe.Nom"));
                
                Promotion promotion = new Promotion();
                promotion.setId(result.getInt("groupe.ID_Promotion"));
                promotion.setNom(result.getString("promotion.Nom"));
                
                groupe.setPromotion(promotion);

                returned = new Seance_groupes(seance, groupe);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }

}
