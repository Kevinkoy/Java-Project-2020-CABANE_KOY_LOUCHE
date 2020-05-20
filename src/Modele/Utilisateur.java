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
    
    /// Constructor default
    public Utilisateur()
    {   }
    
    // Constructor surchargé
    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit)
    {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
  
    public Utilisateur(Utilisateur utilisateur)
    {
        this.id = utilisateur.id;
        this.email = utilisateur.email;
        this.passwd = utilisateur.passwd;
        this.nom = utilisateur.nom;
        this.prenom = utilisateur.prenom;
        this.droit = utilisateur.droit;
    }
    
    // Methodes
        // toString (retourner le contenue d'objet sous forme de chaine
    @Override
        public String toString()
        {
        return "id: " + id + ", email: " + email + ", passwd: " + passwd  + ", nom: " + nom + ", prenom: " + prenom  + ", droit: " + droit ;
        }
        // Getters
        public int getId()
        {
            return this.id;
        }
        
        public String getEmail()
        {
            return this.email;
        }
        
        public String getPasswd()
        {
            return this.passwd;
        }

        public String getNom()
        {
            return this.nom;
        }
        
        public String getPrenom()
        {
            return this.prenom;
        }          
    
        public int getDroit()
        {
            return this.droit;
        }
        
        
        // Setters
        public void setId(int id)
        {
            this.id = id;
        }
        
        public void setEmail(String email)
        {
            this.email = email;
        }
        
        public void setPasswd(String passwd)
        {
            this.passwd = passwd;
        }

        public void setNom(String nom)
        {
            this.nom = nom;
        }
        
        public void setPrenom(String prenom)
        {
            this.prenom = prenom;
        }          
    
        public void setDroit(int droit)
        {
            this.droit = droit;
        }
}
