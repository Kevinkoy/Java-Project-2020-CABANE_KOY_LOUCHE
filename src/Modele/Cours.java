package Modele;

/**
 *
 * @author KévinKOY
 */
public class Cours {

    ///ATTRIBUTS
    private int id;
    private String nom;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Cours() {
        this.id = 0;
        this.nom = "";
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param nom
     */
    public Cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // METHODES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        if (this.id == 0) {
            return "Cours introuvable";
        }
        return " id: " + this.id + ", nom: " + this.nom;
    }

    // GETTERS
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
