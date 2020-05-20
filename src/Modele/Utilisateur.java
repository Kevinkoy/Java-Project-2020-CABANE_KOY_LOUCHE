package Modele;

/**
 *
 * @author KévinKOY
 * 
 */
public class Utilisateur 
{

 
    ///ATTRIBUTS
    protected int id;
    protected String email;
    protected String passwd;
    protected String nom;
    protected String prenom;
    protected int droit;
    
    /**
     * Constructeur par defaut
     */
    public Utilisateur()
    {   }
    
    /**
     * Constructeur surchargé
     * @param id
     * @param email
     * @param passwd
     * @param nom
     * @param prenom
     * @param droit
     */
    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit)
    {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
  
    /**
     * Constructeur surchargé
     * @param utilisateur
     */
    public Utilisateur(Utilisateur utilisateur)
    {
        this.id = utilisateur.id;
        this.email = utilisateur.email;
        this.passwd = utilisateur.passwd;
        this.nom = utilisateur.nom;
        this.prenom = utilisateur.prenom;
        this.droit = utilisateur.droit;
    }

    
// Methodes ////////////////////////////////////////////////////////////////////
    
// toString : retourner le contenue d'objet sous forme de chaine
    @Override
        public String toString()
        {
        return "id: " + id + ", email: " + email + ", passwd: " + passwd  + ", nom: " + nom + ", prenom: " + prenom  + ", droit: " + droit ;
        }

// Getters /////////////////////////////////////////////////////////////////////
    /**
     *
     * @return id
     */
        public int getId()
        {
            return this.id;
        }
        
    /**
     *
     * @return email
     */
    public String getEmail()
        {
            return this.email;
        }
        
    /**
     *
     * @return passwd
     */
    public String getPasswd()
        {
            return this.passwd;
        }

    /**
     *
     * @return nom
     */
    public String getNom()
        {
            return this.nom;
        }
        
    /**
     *
     * @return prenom
     */
    public String getPrenom()
        {
            return this.prenom;
        }          
    
    /**
     *
     * @return droit
     */
    public int getDroit()
        {
            return this.droit;
        }
        
        
// Setters /////////////////////////////////////////////////////////////////////
    
    /**
     *
     * @param id
     */
        public void setId(int id)
        {
            this.id = id;
        }
        
    /**
     *
     * @param email
     */
    public void setEmail(String email)
        {
            this.email = email;
        }
        
    /**
     *
     * @param passwd
     */
    public void setPasswd(String passwd)
        {
            this.passwd = passwd;
        }

    /**
     *
     * @param nom
     */
    public void setNom(String nom)
        {
            this.nom = nom;
        }
        
    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom)
        {
            this.prenom = prenom;
        }          
    
    /**
     *
     * @param droit
     */
    public void setDroit(int droit)
        {
            this.droit = droit;
        }
}
