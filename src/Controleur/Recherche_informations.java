package Controleur;

import DataAcessObject.ConnectMySQL;
import DataAcessObject.EnseignantDAO;
import DataAcessObject.EtudiantDAO;
import DataAcessObject.SeanceDAO;
import DataAcessObject.Seance_enseignantsDAO;
import DataAcessObject.Seance_groupesDAO;
import DataAcessObject.UtilisateurDAO;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Seance;
import Modele.Seance_enseignants;
import Modele.Seance_groupes;
import Modele.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author KévinKOY
 */
public class Recherche_informations {

    //ATTRIBUTS 
    protected Utilisateur user;
    protected Etudiant student;
    protected Enseignant teacher;

    public Recherche_informations() {
    }

    /**
     * Constructeur surchargé (Loggin: Saisir email + passwd)
     *
     *  / Initialise l'utilisateur, si l'email et le password match dans la
     * DataBase.
     *
     * @param email
     * @param passwd
     */
    public Recherche_informations(String email, String passwd) {
        // Loggin: Find(email,passwd)
        UtilisateurDAO utilisateurdao = new UtilisateurDAO(ConnectMySQL.getInstance());
        // Initialisation de user
        this.user = utilisateurdao.find(email, passwd); // find: return Utilisateur NULL ou Trouvé!
        this.student = new Etudiant();
        this.teacher = new Enseignant();

        // Aucun utilisateur connecté... =====================================================================================
        if (this.user.getId() == 0) {
            System.out.println("Aucun utilisateur trouvé: " + user.toString());
        } // Utilisateur connecté ! ==========================================================================================
        else {
            System.out.println("Utilisateur connecté!: " + user.toString());
            // Quel type d'utilisateur connecté... ===========================================================================
            switch (this.user.getDroit()) {
                case 1:
                    System.out.println("Administrateur");
                    break;
                case 2:
                    System.out.println("Référent pédagogique");
                    break;
                case 3:
                    System.out.println("Enseignant");
                    this.teacher = new EnseignantDAO(ConnectMySQL.getInstance()).find(this.user.getId());
                    break;
                case 4:
                    System.out.println("Etudiant");
                    this.student = new EtudiantDAO(ConnectMySQL.getInstance()).find(this.user.getId());
                    break;
                default:;
            }
        } // ==================================================================================================================
    }

    public ArrayList<Etudiant> getAll_Etudiant() {
        ArrayList<Etudiant> ALL = new ArrayList();

        EtudiantDAO objetdao = new EtudiantDAO(ConnectMySQL.getInstance());
        for (int i = 0; i < 100; i++) {
            Etudiant find = objetdao.find(i);
            if (find.getId() != 0) {
                ALL.add(find);
            } else {

            }
        }

        return ALL;
    }

    public ArrayList<Enseignant> getAll_Enseignant() {
        ArrayList<Enseignant> ALL = new ArrayList();

        EnseignantDAO objetdao = new EnseignantDAO(ConnectMySQL.getInstance());
        for (int i = 0; i < 100; i++) {
            Enseignant find = objetdao.find(i);
            if (find.getId() != 0) {
                ALL.add(find);
            } else {

            }
        }

        return ALL;
    }

    public ArrayList<Seance> getAll_Seance(Utilisateur utilisateur, int semaine) {
        ArrayList<Seance> ALL = new ArrayList();
        SeanceDAO seancedao = new SeanceDAO(ConnectMySQL.getInstance());

        // Si Utilisateur = Etudiant
        if (utilisateur instanceof Etudiant) {
            Seance_groupesDAO sgdao = new Seance_groupesDAO(ConnectMySQL.getInstance());

            // PARCOURS DE LA TABLE
            for (int i = 0; i < 100; i++) {
                Seance_groupes find_by_id_groupe = sgdao.find_by_id_groupe(i);
                // SI le groupe correspond a celui de l'étudiant
                if (find_by_id_groupe.getGroupe().getId() == ((Etudiant) utilisateur).getGroupe().getId()) {
                    // On va verifier sa semaine
                    Seance find = seancedao.find(i);
                    {
                        // La semaine correspondante
                        if (find.getSemaine() == semaine) {
                            // On le rajoute au tableau de seance
                            ALL.add(find);
                        } // N'appartient pas a la semaine
                        else {
                        }
                    }

                } // n'Appartient pas au groupe
                else {
                }

            }
            /// Si Utilisateur = Enseignant
        } else if (utilisateur instanceof Enseignant) {
            Seance_enseignantsDAO sgdao = new Seance_enseignantsDAO(ConnectMySQL.getInstance());
            // PARCOURS DE LA TABLE
            for (int i = 0; i < 100; i++) {
                Seance_enseignants find_by_id_enseignant = sgdao.find_by_id_enseignant(i);
                // SI le groupe correspond a celui de l'étudiant
                if (find_by_id_enseignant.getEnseignant().getId() == ((Enseignant) utilisateur).getId()) {
                    // On va verifier sa semaine
                    Seance find = seancedao.find(i);
                    {
                        // La semaine correspondante
                        if (find.getSemaine() == semaine) {
                            // On le rajoute au tableau de seance
                            ALL.add(find);
                        } // N'appartient pas a la semaine
                        else {
                        }
                    }

                } // n'Appartient pas au groupe
                else {
                }

            }
        } /// Sinon admin ou ref on affiche tout pour une semaine donnée
        else {
            for (int i = 0; i < 100; i++) {
                Seance find = seancedao.find(i);
                // On va verifier sa semaine
                if (find.getSemaine() == semaine) {
                    ALL.add(find);
                } else {

                }
            }

        }

        return ALL;
    }
// Getters /////////////////////////////////////////////////////////////////////

    /**
     * Methode qui retourne l'Utilisateur Connecté (Utilisateur OU Enseignant OU
     * Etudiant)
     *
     * @return Utilisateur | Enseignant | Etudiant
     */
    public Utilisateur getUser() {
        switch (this.user.getDroit()) {
            case 1:
                return this.user;
            case 2:
                return this.user;
            case 3:
                return this.teacher;
            case 4:
                return this.student;
            default:
                return this.user;
        }
    }

    /**
     * Methode pour récuperer id utilisateur connecté
     *
     * @return id utilisateur
     */
    public int getId() {
        return this.user.getId();
    }

    /**
     * Methode pour récuperer email utilisateur connecté
     *
     * @return email utilisateur
     */
    public String getEmail() {
        return this.user.getEmail();
    }

    /**
     * Methode pour récuperer passwd utilisateur connecté
     *
     * @return passwd utilisateur
     */
    public String getPasswd() {
        return this.user.getPasswd();
    }

    /**
     * Methode pour récuperer nom utilisateur connecté
     *
     * @return nom utilisateur
     */
    public String getNom() {
        return this.user.getNom();
    }

    /**
     * Methode pour récuperer prenom utilisateur connecté
     *
     * @return prenom utilisateur
     */
    public String getPrenom() {
        return this.user.getPrenom();
    }

    /**
     * Methode pour récuperer STRING droit (statut) de utilisateur connecté
     *
     * @return String du Droit utilisateur connecté
     */
    public String getDroit() {
        switch (this.user.getDroit()) {
            case 1:
                return "Administrateur";
            case 2:
                return "Référent pédagogique";
            case 3:
                return "Enseignant";
            case 4:
                return "Etudiant";
            default:
                return "";
        }
    }

    /// UTILISATEUR CONNECTED = ETUDIANT ================================================================================================================
    /**
     * Si Utilisateur connecté = ETUDIANT Methode pour récuperer le numero de
     * l'étudiant connecté
     *
     * @return Numero Etudiant, sinon 0
     */
    public int getNumero() {
        return this.student.getNumero();
    }

    /**
     * Si Utilisateur connecté = ETUDIANT; Methode pour récuperer le nom du
     * groupe de l'étudiant connecté
     *
     * @return Nom du Groupe, sinon null
     */
    public String getGroupe() {
        return this.student.getGroupe().getNom();
    }

    /**
     * Si Utilisateur connecté = ETUDIANT; Methode pour récuperer le nom de la
     * promotion de l'étudiant connecté
     *
     * @return Nom de la Promotion, sinon null
     */
    public String getPromotion() {
        return this.student.getGroupe().getPromotion().getNom();
    }
    // ===============================================================================================================================================

    /// UTILISATEUR CONNECTED = Enseignant  ==========================================================================================================
    /**
     * Si Utilisateur connecté = Enseignant; Methode pour récuperer le nom du
     * cours de l'enseignant connecté
     *
     * @return Nom du cours, sinon null
     */
    public String getCours() {
        return this.teacher.getCours().getNom();
    }
    /// ==============================================================================================================================================
}
