package Modele;

/**
 *
 * @author KévinKOY
 */
public class Site 
{
     ///ATTRIBUTS
    protected int id;
    protected String nom;
    
    /// Constructor default
    public Site()
    {
        
    }
    
    // Constructor surchargé
    public Site(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
    // Methodes
        // toString : retourner le contenue d'objet sous forme de chaine
        @Override
        public String toString()
        {
        return "id: " + id + ", nom: " + nom;
        }
        
        // Getters
        public int getId()
        {
            return this.id;
        }
        
        public String getNom()
        {
            return this.nom;
        }

        // Setters
        public void setId(int id)
        {
            this.id = id;
        }
        
        public void setNom(String nom)
        {
            this.nom = nom;
        }
    
}
