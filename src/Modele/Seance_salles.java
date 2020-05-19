package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_salles
{
    /// Attributs
    private Seance seance;
    private Salle salle;
    
    /// Constructor default
    public Seance_salles()
    {
    }
    
    /// Constructor surcharge
    public Seance_salles(Seance seance, Salle id_salle)
    {
        this.seance = seance;
        this.salle = salle;
    }
    
    //**************** CONSTRUCTOR UTILE?
    /*public Seance_salles(Seance seance, Salle salle)
    {
        this.id_seance = seance.getId();
        this.id_salle = salle.getId();
    }*/
     
    /// Methodes 
        // Getters
            public Seance GetSeance()
            {
                return this.seance;
            }
            
            public Salle Getsalle()
            {
                return this.salle;
            }
            
        // Setters
        public void setId_salle(Salle id_salle)
        {
            this.salle = salle;
        }
        
        public void setSeance(Seance seance)
        {
            this.seance = seance;
        }
}
