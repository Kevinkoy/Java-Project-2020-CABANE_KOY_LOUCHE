package Modele;

/**
 *
 * @author KévinKOY
 */
public class Groupe 
{
    /// ATTRIBUTS
    private int id;
    protected String nom;
    protected int id_promotion;
    
    /// Constructor default
    public Groupe()
    {
        
    }
    
    /// Constructor surcharge
    public Groupe(int id, String nom, int id_promotion)
    {
        this.id= id;
        this.nom=nom;
        this.id_promotion=id_promotion;
    }
    
    /// Methodes
       //ToString
        @Override
        public String toString()
        {
            return "id: " + this.id + ",nom: " + this.nom + ", id_promotion: " + this.id_promotion ;
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
        
        public int getId_promotion()
        {
        return this.id_promotion;
        }
        
        // Setters
        public void setId(int id)
        {
            this.id = id;
        }
        
        public void setId_promotion(int id_promotion)
        {
            this.id_promotion = id_promotion;
        }
        
        public void setNom(String nom)
        {
            this.nom = nom;
        }
        

}

