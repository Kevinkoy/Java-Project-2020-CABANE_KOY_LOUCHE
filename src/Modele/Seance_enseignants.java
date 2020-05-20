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

    /// Methodes 
    // Getters
    public Seance getSeance() {
        return this.seance;
    }

    public Enseignant getEnseignant() {
        return this.enseignant;
    }

    // Setters
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
