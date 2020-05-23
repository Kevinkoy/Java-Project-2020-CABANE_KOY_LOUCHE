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
            ///  ETAPE 1 - FIND - savoir si il existe + COPIE
            Utilisateur create = this.find(utilisateur.getId());

            // Il n'existe pas encore alors on peut créer 
            if (create.getId() == 0) {
                /// ETAPE 2 : CREATE
                // REQUETE SQL
                // INSERT INTO `utilisateur`(`ID`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
                String sql = "INSERT INTO `utilisateur`(`Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) "
                        + "VALUES ("
                        + utilisateur.getEmail() + ","
                        + utilisateur.getPasswd() + ","
                        + utilisateur.getNom() + ","
                        + utilisateur.getPrenom() + ","
                        + utilisateur.getDroit() + ")";

                // PrepareStatement
                PreparedStatement preparedstatement = this.connection.prepareStatement(sql);

                // ResultSet (result)
                int result = preparedstatement.executeUpdate(sql);

                // SI RESULTAT
                if (result == 1) {
                    System.out.println("INSERTION Sucess: " + utilisateur.toString());
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
            ///  ETAPE 1 - FIND - savoir si il existe
            // COPIER l'utilisateur_delete pour ensuite l'afficher (en cas de DELETE Succès)     
            Utilisateur delete = this.find(utilisateur.getId());

            // Si return user NULL
            if (delete.getId() == 0) {
                System.out.print(delete.toString()); // AFFICHAGE "Utilisateur Introuvable"
                return false; // return false et on quitte la fonction delete();
            }

            /// ETAPE 2 : DELETE car elle existe dans la BDD après find
            // REQUETE SQL
            String sql = "DELETE FROM utilisateur WHERE utilisateur.ID = " + utilisateur.getId();

            // Statement : DECLARATION + INITIALIZED to the connection
            Statement statement = this.connection.createStatement();

            // RESULTAT (ResultSet) : EXECUTER SQL
            int result = statement.executeUpdate(sql);

            // SI RESULTAT
            if (result == 1) {
                System.out.println("DELETE Sucess: " + delete.toString());
                return true;
                // SINON AUCUN RESULTAT
            }
            /*else {
                System.out.println("AUCUN DELETE EFFECTUE!");
            }*/
        } catch (SQLException e) {
            e.printStackTrace(); // System.out.println("Base de donnée introuvable");
        }
        return false;

    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {

        /// UTILISATEUR NULL PAR DEFAUT
        Utilisateur utilisateur = new Utilisateur();

        // REQUETE
        String sql = "SELECT * FROM Utilisateur WHERE ID = " + id;

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
                        id,
                        result.getString("Email"),
                        result.getString("Passwd"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getInt("Droit"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // System.out.println("Base de donnée introuvable");
        }
        // SI AUCUN RESULTAT - return UTILISATEUR NULL
        return utilisateur;
    }

}
