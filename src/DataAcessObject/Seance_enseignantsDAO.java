package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import Modele.Seance;
import Modele.Seance_enseignants;
import Modele.Type_cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {

    public Seance_enseignantsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Seance_enseignants obj) {
        try {
            // REQUETE SQL (INSERT, ID value NULL pour Auto-incrémentation)
            String sql = "INSERT INTO `seance_enseignants`(`ID_Seance`, `ID_Enseignant`) VALUES ('" + obj.getSeance().getId() + "','" + obj.getEnseignant().getId() + "');";
            // PrepareStatement
            PreparedStatement preparedstatement = this.connection.prepareStatement(sql);
            // ResultSet (result)
            int result = preparedstatement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
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
    public boolean delete(Seance_enseignants obj) {
        // Copie en cas de delete réussi
        Seance_enseignants copie = obj;
        try {
            // REQUETE SQL : DELETE
            String sql = "DELETE FROM `seance_enseignants` WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Enseignant` ='" + obj.getEnseignant().getId() + "' ;";
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
    public boolean update(Seance_enseignants obj) {
        try {
            // REQUETE SQL : UPDATE
            String sql = "UPDATE `seance_enseignants` SET `ID_Seance`='" + obj.getSeance().getId() + "',`ID_Enseignant`='" + obj.getEnseignant().getId() + "' WHERE `ID_Seance` ='" + obj.getSeance().getId() + "' AND `ID_Enseignant` ='" + obj.getEnseignant().getId() + "' ;";
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
    public Seance_enseignants find(int id_seance) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_enseignants returned = new Seance_enseignants();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_enseignants`\n"
                    + "INNER JOIN `seance`ON seance_groupes.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"
                    + "INNER JOIN `utilisateur`ON seance_enseignants.ID_Enseignant = utilisateur.ID\n"
                    + "INNER JOIN `enseignant`ON seance_enseignants.ID_Enseignant = enseignant.ID_Utilisateur\n"
                    + "WHERE seance_enseignants.ID_Seance ='" + id_seance + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_enseignants.ID_Seance"));
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

                ///***
                Enseignant enseignant = new Enseignant();
                enseignant.setId(result.getInt("seance_enseignants.ID_Enseignant"));
                enseignant.setEmail(result.getString("utilisateur.Email"));
                enseignant.setPasswd(result.getString("utilisateur.Passwd"));
                enseignant.setNom(result.getString("utilisateur.Nom"));
                enseignant.setPrenom(result.getString("utilisateur.Prenom"));
                enseignant.setDroit(result.getInt("utilisateur.Droit"));

                Cours cours2 = new Cours();
                cours2.setId(result.getInt("Enseignant.ID_Cours"));
                cours2.setNom(result.getString("cours.Nom"));
                enseignant.setCours(cours2);

                returned = new Seance_enseignants(seance, enseignant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }
    
      public Seance_enseignants find_by_id_enseignant(int id_enseignant) {
        /// CONSTRUCTEUR NULL (PAR DEFAUT)
        Seance_enseignants returned = new Seance_enseignants();
        try {
            // REQUETE
            String sql = "SELECT * FROM `seance_enseignants`\n"
                    + "INNER JOIN `seance`ON seance_groupes.ID_Seance = seance.ID\n"
                    + "INNER JOIN `cours`ON seance.ID_Cours = cours.ID\n"
                    + "INNER JOIN `type_cours`ON seance.ID_Type = type_cours.ID\n"
                    + "INNER JOIN `utilisateur`ON seance_enseignants.ID_Enseignant = utilisateur.ID\n"
                    + "INNER JOIN `enseignant`ON seance_enseignants.ID_Enseignant = enseignant.ID_Utilisateur\n"
                    + "WHERE seance_enseignants.ID_Enseignant ='" + id_enseignant + "';";
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);
            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// return = RESULTAT
                Seance seance = new Seance();
                seance.setId(result.getInt("seance_enseignants.ID_Seance"));
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

                ///***
                Enseignant enseignant = new Enseignant();
                enseignant.setId(result.getInt("seance_enseignants.ID_Enseignant"));
                enseignant.setEmail(result.getString("utilisateur.Email"));
                enseignant.setPasswd(result.getString("utilisateur.Passwd"));
                enseignant.setNom(result.getString("utilisateur.Nom"));
                enseignant.setPrenom(result.getString("utilisateur.Prenom"));
                enseignant.setDroit(result.getInt("utilisateur.Droit"));

                Cours cours2 = new Cours();
                cours2.setId(result.getInt("Enseignant.ID_Cours"));
                cours2.setNom(result.getString("cours.Nom"));
                enseignant.setCours(cours2);

                returned = new Seance_enseignants(seance, enseignant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        // return soit NULL || soit RESULTAT...
        return returned;
    }
}
