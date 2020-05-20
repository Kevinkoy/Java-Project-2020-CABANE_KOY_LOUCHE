package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_salles {

    /// Attributs
    private Seance seance;
    private Salle salle;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Seance_salles() {
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param seance
     * @param salle
     */
    public Seance_salles(Seance seance, Salle salle) {
        this.seance = seance;
        this.salle = salle;
    }

    /// Methodes 
    // Getters
    public Seance getSeance() {
        return this.seance;
    }

    public Salle getSalle() {
        return this.salle;
    }

    // Setters
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
