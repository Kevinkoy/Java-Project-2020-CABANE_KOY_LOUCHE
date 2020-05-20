package Modele;

/**
 *
 * @author KévinKOY
 */
public class Enseignant extends Utilisateur {

    /// Attributs
    private Cours cours;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Enseignant() {
        super();
        this.droit = 3; // 3 enseignant
    }

    public Enseignant(int id, String email, String passwd, String nom, String prenom, Cours cours) {
        super(id, email, passwd, nom, prenom, 3);
        this.cours = cours;
    }

    /// METHODES
    public Cours getCours() {
        return this.cours;
    }

    // Setters
    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
