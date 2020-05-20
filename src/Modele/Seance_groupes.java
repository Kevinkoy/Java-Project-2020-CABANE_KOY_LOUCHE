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
    

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Seance_groupes()
    {
    }
    

    /**
     * CONSTRUCTEUR SURCHARGE
     * @param seance
     * @param groupe
     */
    public Seance_groupes(Seance seance, Groupe groupe)
    {
        this.seance = seance;
        this.groupe = groupe;
    }
    
     
    /// Methodes 
        // Getters
            public Seance getSeance()
            {
                return this.seance;
            }
            
            public Groupe getGroupe()
            {
                return this.groupe;
            }
            
        // Setters
        public void setGroupe(Groupe groupe)
        {
            this.groupe = groupe;
        }
        
        public void setSeance(Seance seance)
        {
            this.seance = seance;
        }
}
