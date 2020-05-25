package DataAcessObject;

import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KévinKOY
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    public UtilisateurDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Utilisateur utilisateur) {
        try {
            ///  ETAPE 1 - Vérification si il existe... par id
            Utilisateur u_create_id = this.find(utilisateur.getId());
            /// ETAPE 1 bis - Verification si son email est déjà utilisée.
            Utilisateur u_create_email = this.find(utilisateur.getEmail());

            // Il n'existe pas encore alors (ID et EMAIL dispo)
            if (u_create_id.getId() == 0 && u_create_email.getId() == 0) {
                /// ETAPE 2 : CREATE (ID value NULL, Auto-incrémentation)
                // REQUETE SQL
                String sql = "INSERT INTO `utilisateur`(`ID`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES(" + "NULL" + ",'" + utilisateur.getEmail() + "','" + utilisateur.getPasswd() + "'  ,'" + utilisateur.getNom() + "','" + utilisateur.getPrenom() + "' ,'" + utilisateur.getDroit() + "'  )";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    System.out.println("INSERTION Sucess: " + this.find(utilisateur.getEmail()).toString()); // On le recherche par EMAIL car id auto-incremented, et on l'affiche (***)
                    return true;
                }
                // UTILISATEUR DEJA EXISTANT!
            } else {
                System.out.println("INSERTION Fail!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // System.out.println("Base de donnée introuvable");
        }
        return false;

    }

    @Override
    public boolean delete(Utilisateur utilisateur) {
        try {
            ///  ETAPE 1 - VERIFICATION si il existe..
            // COPIE utilisateur pour afficher si deleted 
            Utilisateur u_delete_id = this.find(utilisateur.getId()); // return user NULL si il existe pas

            // Si il n'existe pas...
            if (u_delete_id.getId() == 0) {
                System.out.print(u_delete_id.toString()); // AFFICHAGE "Utilisateur Introuvable"
                return false; // return false et on quitte la fonction delete();
            }

            /// Il existe...
            /// ETAPE 2 : DELETE 
            // REQUETE SQL
            String sql = "DELETE FROM utilisateur WHERE utilisateur.ID = " + utilisateur.getId();

            // Statement : DECLARATION + INITIALIZED to the connection
            Statement statement = this.connection.createStatement();

            // RESULTAT (ResultSet) : EXECUTER SQL
            int result = statement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                System.out.println("DELETE Sucess: " + u_delete_id.toString()); // On affiche la copie du delete, car il n'existe plus(***)
                return true;
            }
        } catch (SQLException e) {
            // System.out.println("Base de donnée introuvable");
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(Utilisateur u) {
        try {
            ///  ETAPE 1 - Verification si il existe... par id
            Utilisateur u_update_id = this.find(u.getId());
            /// ETAPE 1 bis - Verification si il existe... par email
            Utilisateur u_update_email = this.find(u.getEmail());

            // Si il existe alors...
            if (u_update_id.getId() != 0 && u_update_email.getId() != 0) {
                /// ETAPE 2 : UPDATE

                // REQUETE SQL
                String sql = "UPDATE `utilisateur` SET `ID`= '" + u.getId() + "' ,`Email`= '" + u.getEmail() + "' ,`Passwd`= '" + u.getPasswd() + "' ,`Nom`= '" + u.getNom() + "' ,`Prenom`= '" + u.getPrenom() + "' ,`Droit`= '" + u.getDroit() + "' WHERE ID = '" + u.getId() + "'";
                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    System.out.println("UPDATE Sucess: " + this.find(u.getId()).toString()); // on le recherche par id, et on l'affiche (***)
                    return true;
                }
                // Sinon il existe pas...
            } else {
                System.out.println("UPDATE Fail!");
                return false;
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");        
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Utilisateur find(int id) {

        /// UTILISATEUR NULL PAR DEFAUT
        Utilisateur utilisateur = new Utilisateur();

        // REQUETE
        String sql = "SELECT * FROM Utilisateur WHERE ID = '" + id + "'";

        try {
            // VERSION OPENCLASSROOM : resultset = connection.createStatement.execute(sql);
            /*ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(sql);*/

            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);

            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT
            if (result.next()) {
                /// COPIER UtilisateurDao trouvé
                utilisateur = new Utilisateur(
                        result.getInt("ID"), // id,
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter");
            e.printStackTrace();
        }
        // SI AUCUN RESULTAT - return UTILISATEUR NULL
        return utilisateur;
    }

    public Utilisateur find(String email) {

        /// UTILISATEUR NULL (PAR DEFAUT)
        Utilisateur utilisateur = new Utilisateur();

        // REQUETE
        String sql = "SELECT * FROM Utilisateur WHERE Email = '" + email + "'";

        try {
            // PrepareStatement
            PreparedStatement preparestatement = this.connection.prepareStatement(sql);

            // ResultSet
            ResultSet result = preparestatement.executeQuery(sql);

            // SI RESULTAT...
            if (result.next()) {
                /// COPIER UtilisateurDao trouvé
                utilisateur = new Utilisateur(
                        result.getInt("ID"),
                        result.getString("Email"), // email,
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            //System.out.println("Impossible de se connecter!");        
            e.printStackTrace();
        }
        // return soit NULL soit resultat....
        return utilisateur;
    }

}
