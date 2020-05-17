package Modele;

/**
 *
 * @author KévinKOY
 */
public class Salle 
{
    /// Attributs
    private int id;
    private String nom;
    private int capacite;
    private int id_site;
    
    /// Constructor default
    public Salle()
    {
        
    }
    
    /// Constructor surcharge
    public Salle(int id, String nom, int capacite, int id_site)
    {
       this.id = id;
       this.nom = nom;
       this.capacite = capacite;
       this.id_site =id_site;
    }
    
    /// Methodes 
        // Getters
        public int getId()
        {
            return this.id;
        }
        public String getNom()
        {
            return this.nom;
        }
        public int getCapacite()
        {
            return this.capacite;
        }
        public int getId_site()
        {
            return this.id_site;
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
        
        public void setCapacite(int capacite)
        {
            this.capacite = capacite;
        }
        
        public void setId_site(int id_site)
        {
            this.id_site = id_site;
        }
}
