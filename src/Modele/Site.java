package Modele;

/**
 *
 * @author KévinKOY
 */
public class Site {
    ///ATTRIBUTS

    protected int id;
    protected String nom;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Site() {

    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param nom
     */
    public Site(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // METHODES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        if(this.id == 0)
        {
          return "Site introuvable";
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
