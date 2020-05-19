package Modele;

/**
 *
 * @author KévinKOY
 */
public class Enseignant
{
    /// Attributs
    private Utilisateur utilisateur;
    private Cours cours;
    
    /// Constructor default
    public Enseignant()
    {
    }
    
    /// Constructor surcharge
    public Enseignant(Utilisateur utilisateur, Cours cours)
    {
        this.utilisateur = utilisateur;
        this.cours = cours;
    }
    
    //**************** CONSTRUCTOR UTILE?
    /*public Enseignant(Utilisateur utilisateur, Cours cours)
    {
        this.id_utilisateur = utilisateur.getId();
        this.id_cours = cours.getId();
    }*/
     
    /// Methodes 
        // Getters
            public Utilisateur GetUtilisateur()
            {
                return this.utilisateur;
            }
            
            public Cours GetCours()
            {
                return this.cours;
            }
            
        // Setters
        public void setId_cours(Cours cours)
        {
            this.cours = cours;
        }
        
        public void setUtilisateur(Utilisateur utilisateur)
        {
            this.utilisateur = utilisateur;
        }
        
        
}
