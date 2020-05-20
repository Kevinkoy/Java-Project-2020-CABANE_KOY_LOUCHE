package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_groupes {

    /// Attributs
    private Seance seance;
    private Groupe groupe;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Seance_groupes() {
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param seance
     * @param groupe
     */
    public Seance_groupes(Seance seance, Groupe groupe) {
        this.seance = seance;
        this.groupe = groupe;
    }

    ///METHODES
    // GETTERS
    public Seance getSeance() {
        return this.seance;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    // SETTERS
    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}
