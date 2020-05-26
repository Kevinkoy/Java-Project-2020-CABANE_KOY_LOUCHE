package Modele;

/**
 *
 * @author KévinKOY
 *
 */
public class Utilisateur {

    ///ATTRIBUTS
    protected int id;
    protected String email;
    protected String passwd;
    protected String nom;
    protected String prenom;
    /**
     * 1 administrateur | 2 référent pédagogique | 3 enseignant | 4 étudiant
     */
    protected int droit;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Utilisateur() {
        id = 0;
        email = "";
        passwd = "";
        nom = "";
        prenom = "";
        droit = 0;
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param email
     * @param passwd
     * @param nom
     * @param prenom
     * @param droit
     */
    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit) {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param utilisateur
     */
    public Utilisateur(Utilisateur utilisateur) {
        this.id = utilisateur.id;
        this.email = utilisateur.email;
        this.passwd = utilisateur.passwd;
        this.nom = utilisateur.nom;
        this.prenom = utilisateur.prenom;
        this.droit = utilisateur.droit;
    }

// Methodes ////////////////////////////////////////////////////////////////////
// toString : retourner le contenue d'objet sous forme de chaine
    // droit : 1 administrateur | 2 référent pédagogique | 3 enseignant | 4 étudiant
    @Override
    public String toString() {
        if (this.id == 0) {
            return "Utilisateur introuvable!";
        } else {
            switch (this.droit) {
                case 1:
                    return " id: " + this.id + ", email: " + this.email + ", passwd: " + this.passwd + ", nom: " + this.nom + ", prenom: " + this.prenom + ", droit: " + "administrateur";
                case 2:
                    return " id: " + this.id + ", email: " + this.email + ", passwd: " + this.passwd + ", nom: " + this.nom + ", prenom: " + this.prenom + ", droit: " + "référent pédagogique";
                case 3:
                    return " id: " + this.id + ", email: " + this.email + ", passwd: " + this.passwd + ", nom: " + this.nom + ", prenom: " + this.prenom + ", droit: " + "enseignant";
                case 4:
                    return " id: " + this.id + ", email: " + this.email + ", passwd: " + this.passwd + ", nom: " + this.nom + ", prenom: " + this.prenom + ", droit: " + "étudiant";
                default:
                    return " id: " + this.id + ", email: " + this.email + ", passwd: " + this.passwd + ", nom: " + this.nom + ", prenom: " + this.prenom + ", droit: " + this.droit;

            }
        }
    }

// Getters /////////////////////////////////////////////////////////////////////
    /**
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return passwd
     */
    public String getPasswd() {
        return this.passwd;
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     *
     * @return prenom
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     *
     * @return droit
     */
    public int getDroit() {
        return this.droit;
    }

// Setters /////////////////////////////////////////////////////////////////////
    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @param droit
     */
    public void setDroit(int droit) {
        this.droit = droit;
    }
}
