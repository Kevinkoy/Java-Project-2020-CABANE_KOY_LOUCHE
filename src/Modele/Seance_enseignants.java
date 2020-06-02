package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignants {

    /// Attributs
    private Seance seance;
    private Enseignant enseignant;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Seance_enseignants() {
        this.seance = new Seance();
        this.enseignant = new Enseignant();
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param seance
     * @param enseignant
     */
    public Seance_enseignants(Seance seance, Enseignant enseignant) {
        this.seance = seance;
        this.enseignant = enseignant;
    }

    // METHODES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        return " seance: " + this.seance + ", enseignant: " + this.enseignant;
    }

    // GETTERS
    public Seance getSeance() {
        return this.seance;
    }

    public Enseignant getEnseignant() {
        return this.enseignant;
    }

    // SETTERS
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
