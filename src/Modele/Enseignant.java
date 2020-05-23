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

    /**
     *
     * @param id
     * @param email
     * @param passwd
     * @param nom
     * @param prenom
     * @param cours
     */
    public Enseignant(int id, String email, String passwd, String nom, String prenom, Cours cours) {
        super(id, email, passwd, nom, prenom, 3);
        this.cours = cours;
    }

    // METHO0DES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        if(this.id==0)
        {
            return "ENSEIGNANT INTROUVABLE";
        }
        else
        return super.toString() + ", cours: " + this.cours;
    }

    // GETTERS
    public Cours getCours() {
        return this.cours;
    }

    // SETTERS
    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
