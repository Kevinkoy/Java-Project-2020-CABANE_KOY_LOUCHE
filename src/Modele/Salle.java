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
    private Site site;
    
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Salle()
    {
        
    }
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param id
     * @param nom
     * @param capacite
     * @param site
     */
    public Salle(int id, String nom, int capacite, Site site)
    {
       this.id = id;
       this.nom = nom;
       this.capacite = capacite;
       this.site = site;
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
        public Site getSite()
        {
            return this.site;
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
        
        public void setSite(Site site)
        {
            this.site = site;
        }
}
