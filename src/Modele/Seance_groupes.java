package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_groupes
{
    /// Attributs
    private Seance seance;
    private Groupe groupe;
    
    /// Constructor default
    public Seance_groupes()
    {
    }
    
    /// Constructor surcharge
    public Seance_groupes(Seance seance, Groupe groupe)
    {
        this.seance = seance;
        this.groupe = groupe;
    }
    
    //**************** CONSTRUCTOR UTILE?
    /*public Seance_groupes(Seance seance, Groupe groupe)
    {
        this.id_seance = seance.getId();
        this.id_groupe = groupe.getId();
    }*/
     
    /// Methodes 
        // Getters
            public Seance GetSeance()
            {
                return this.seance;
            }
            
            public Groupe GetProupe()
            {
                return this.groupe;
            }
            
        // Setters
        public void setId_groupe(Groupe groupe)
        {
            this.groupe = groupe;
        }
        
        public void setId_seance(Seance seance)
        {
            this.seance = seance;
        }
}
