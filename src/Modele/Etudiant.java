package Modele;

/**
 *
 * @author KévinKOY
 */
public class Etudiant extends Utilisateur {

    // Attributs
    private int numero;
    private Groupe groupe;

    /**
     *
     */
    public Etudiant() {
        super();
        this.droit = 4; // 4 étudiant
        this.numero = 0;
        this.groupe = new Groupe();
    }

    /**
     *
     * @param id
     * @param email
     * @param passwd
     * @param nom
     * @param prenom
     * @param numero
     * @param groupe
     */
    public Etudiant(int id, String email, String passwd, String nom, String prenom, int numero, Groupe groupe) {
        super(id, email, passwd, nom, prenom, 4); // droit = 4 etudiant
        this.numero = numero;
        this.groupe = groupe;
    }

    // Methodes
    // toString
    @Override
    public String toString() {
        if(this.id==0)
        {
            return "Etudiant introuvable";
        }
        else
        return super.toString() + " numero: " + this.numero + ", groupe: " + this.groupe;
    }

    //Getters
    public int getNumero() {
        return this.numero;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    // Setters
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
