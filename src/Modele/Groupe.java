package Modele;

/**
 *
 * @author KévinKOY
 */
public class Groupe 
{
    /// ATTRIBUTS
    private int id;
    private String nom;
    private Promotion promotion;
    
    /**
     * Constructor default
     */
    public Groupe()
    {
        
    }
    

    /**
     * Constructor surcharge
     * @param id
     * @param nom
     * @param promotion
     */
    public Groupe(int id, String nom, Promotion promotion)
    {
        this.id= id;
        this.nom=nom;
        this.promotion=promotion;
    }
    
    /// Methodes
       //ToString
        @Override
        public String toString()
        {
            return "id: " + this.id + ",nom: " + this.nom + ", id_promotion: " + this.promotion ;
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
        
        public Promotion getPromotion()
        {
        return this.promotion;
        }
        
        // Setters
        public void setId(int id)
        {
            this.id = id;
        }
        
        public void setPromotion(Promotion promotion)
        {
            this.promotion = promotion;
        }
        
        public void setNom(String nom)
        {
            this.nom = nom;
        }
        

}

