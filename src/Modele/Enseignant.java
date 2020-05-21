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

    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        return "id: " + id
                + ", email: " + email
                + ", passwd: " + passwd
                + ", nom: " + nom
                + ", prenom: " + prenom
                + ", droit: " + droit
                + ", cours: " + this.cours.getNom()
                ;
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
