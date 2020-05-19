package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignants
{
    /// Attributs
    private Seance seance;
    private Enseignant enseignant;
    
    /// Constructor default
    public Seance_enseignants()
    {
    }
    
    /// Constructor surcharge
    public Seance_enseignants(Seance seance, Enseignant enseignant)
    {
        this.seance = seance;
        this.enseignant = enseignant;
    }
    
     
    /// Methodes 
        // Getters
            public Seance getSeance()
            {
                return this.seance;
            }
            
            public Enseignant getEnseignant()
            {
                return this.enseignant;
            }
            
        // Setters
        public void setEnseignant(Enseignant enseignant)
        {
            this.enseignant = enseignant;
        }
        
        public void setSeance(Seance seance)
        {
            this.seance = seance;
        }
}
