package Modele;

/**
 *
 * @author KévinKOY
 */
public class Seance_enseignants
{
    /// Attributs
    private int id_seance;
    private int id_enseignant;
    
    /// Constructor default
    public Seance_enseignants()
    {
    }
    
    /// Constructor surcharge
    public Seance_enseignants(int id_seance, int id_enseignant)
    {
        this.id_seance = id_seance;
        this.id_enseignant = id_enseignant;
    }
    
    //**************** CONSTRUCTOR UTILE?
    public Seance_enseignants(Seance seance, Utilisateur utilisateur)
    {
        this.id_seance = seance.getId();
        this.id_enseignant = utilisateur.getId();
    }
     
    /// Methodes 
        // Getters
            public int GetId_seance()
            {
                return this.id_seance;
            }
            
            public int GetId_enseignant()
            {
                return this.id_enseignant;
            }
            
        // Setters
        public void setId_enseignant(int id_enseignant)
        {
            this.id_enseignant = id_enseignant;
        }
        
        public void setId_seance(int id_seance)
        {
            this.id_seance = id_seance;
        }
}
