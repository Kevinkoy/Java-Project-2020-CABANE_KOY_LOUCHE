package Modele;

/**
 *
 * @author KévinKOY
 */
public class Enseignant
{
    /// Attributs
    private int id_utilisateur;
    private int id_cours;
    
    /// Constructor default
    public Enseignant()
    {
    }
    
    /// Constructor surcharge
    public Enseignant(int id_utilisateur, int id_cours)
    {
        this.id_utilisateur = id_utilisateur;
        this.id_cours = id_cours;
    }
    
    //**************** CONSTRUCTOR UTILE?
    public Enseignant(Utilisateur utilisateur, Cours cours)
    {
        this.id_utilisateur = utilisateur.getId();
        this.id_cours = cours.getId();
    }
     
    /// Methodes 
        // Getters
            public int GetId_utilisateur()
            {
                return this.id_utilisateur;
            }
            
            public int GetId_cours()
            {
                return this.id_cours;
            }
            
        // Setters
        public void setId_cours(int id_cours)
        {
            this.id_cours = id_cours;
        }
        
        public void setId_utilisateur(int id_utilisateur)
        {
            this.id_utilisateur = id_utilisateur;
        }
        
        
}
