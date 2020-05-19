
package Modele;

/**
 *
 * @author KévinKOY
 */
public class Etudiant extends Utilisateur
{
    // Attributs
    private int numero;
    private Groupe groupe;
    
    // Constructor default
    public Etudiant()
    {

    }
    
    // Constructor surchargé
    public Etudiant(int numero, Groupe groupe)
    {
        super();
        this.numero = numero;
        this.groupe = groupe;
    }
    
    
    // Methodes
    
        // toString
        @Override
        public String toString()
        {
        return "numero: " + numero + ", id_groupe: " + groupe ;
        }
    
        //Getters
        public int getNumero()
        {
            return this.numero;
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
        
        public void setNumero(int numero)
        {
            this.numero = numero;
        }

// commit Sylvain Lundi 18 15H
    
    
}
