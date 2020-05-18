
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
        //super(); // APPEL du constructor par default du Parent
        //this.numero = 0;
        //this.id_groupe = 0;
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
        public Groupe getId_groupe()
        {
            return this.groupe;
        }
        
        // Setters
        public void setId_groupe(int id_groupe)
        {
            this.groupe = groupe;
        }
        
        public void setNumero(int numero)
        {
            this.numero = numero;
        }


    
    
}
