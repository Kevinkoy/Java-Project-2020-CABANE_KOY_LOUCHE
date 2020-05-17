package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_groupes
{
    /// Attributs
    private int id_seance;
    private int id_groupe;
    
    /// Constructor default
    public Seance_groupes()
    {
    }
    
    /// Constructor surcharge
    public Seance_groupes(int id_seance, int id_groupe)
    {
        this.id_seance = id_seance;
        this.id_groupe = id_groupe;
    }
    
    //**************** CONSTRUCTOR UTILE?
    public Seance_groupes(Seance seance, Groupe groupe)
    {
        this.id_seance = seance.getId();
        this.id_groupe = groupe.getId();
    }
     
    /// Methodes 
        // Getters
            public int GetId_seance()
            {
                return this.id_seance;
            }
            
            public int GetId_groupe()
            {
                return this.id_groupe;
            }
            
        // Setters
        public void setId_groupe(int id_groupe)
        {
            this.id_groupe = id_groupe;
        }
        
        public void setId_seance(int id_seance)
        {
            this.id_seance = id_seance;
        }
}
