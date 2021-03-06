package Modele;

/**
 *
 * @author KévinKOY
 */
public class Groupe {

    /// ATTRIBUTS
    private int id;
    private String nom;
    private Promotion promotion;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Groupe() {
        this.id = 0;
        this.nom = "";
        this.promotion = new Promotion();
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param nom
     * @param promotion
     */
    public Groupe(int id, String nom, Promotion promotion) {
        this.id = id;
        this.nom = nom;
        this.promotion = promotion;
    }

    /// METHODES
    // toString
    @Override
    public String toString() {
        if (this.id == 0) {
            return "Groupe introuvable";
        }
        return " id: " + this.id + ",nom: " + this.nom + ", promotion: " + this.promotion;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public Promotion getPromotion() {
        return this.promotion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
