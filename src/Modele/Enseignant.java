package Modele;

/**
 *
 * @author KévinKOY
 */
public class Enseignant {

    /// Attributs
    private Utilisateur utilisateur;
    private Cours cours;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Enseignant() {
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param utilisateur
     * @param cours
     */
    public Enseignant(Utilisateur utilisateur, Cours cours) {
        this.utilisateur = utilisateur;
        this.cours = cours;
    }

    /// Methodes 
    // Getters
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public Cours getCours() {
        return this.cours;
    }

    // Setters
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
