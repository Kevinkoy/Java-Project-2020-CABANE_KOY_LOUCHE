package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_salles
{
    /// Attributs
    private int id_seance;
    private int id_salle;
    
    /// Constructor default
    public Seance_salles()
    {
    }
    
    /// Constructor surcharge
    public Seance_salles(int id_seance, int id_salle)
    {
        this.id_seance = id_seance;
        this.id_salle = id_salle;
    }
    
    //**************** CONSTRUCTOR UTILE?
    public Seance_salles(Seance seance, Salle salle)
    {
        this.id_seance = seance.getId();
        this.id_salle = salle.getId();
    }
     
    /// Methodes 
        // Getters
            public int GetId_seance()
            {
                return this.id_seance;
            }
            
            public int GetId_salle()
            {
                return this.id_salle;
            }
            
        // Setters
        public void setId_salle(int id_salle)
        {
            this.id_salle = id_salle;
        }
        
        public void setId_seance(int id_seance)
        {
            this.id_seance = id_seance;
        }
}
