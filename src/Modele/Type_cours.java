package Modele;

/**
 *
 * @author KévinKOY
 */
public class Type_cours {
    ///ATTRIBUTS

    private int id;
    private String nom;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Type_cours() {
        this.id = 0;
        this.nom = "";
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param nom
     */
    public Type_cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // METHODES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        if (this.id == 0) {
            return "Type_cours introuvable";
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
