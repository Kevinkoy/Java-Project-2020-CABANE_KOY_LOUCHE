
package Modele;

/**
 *
 * @author KévinKOY
 */
public class Etudiant extends Utilisateur
{
    // Attributs
    private int numero;
    private int id_groupe;
    
    // Constructor default
    public Etudiant()
    {
        //super(); // APPEL du constructor par default du Parent
        //this.numero = 0;
        //this.id_groupe = 0;
    }
    
    // Constructor surchargé
    public Etudiant(int numero, int id_groupe)
    {
        super();
        this.numero = numero;
        this.id_groupe = id_groupe;
    }
    
    
    // Methodes
    
        // toString
        @Override
        public String toString()
        {
        return "numero: " + numero + ", id_groupe: " + id_groupe ;
        }
    
        //Getters
        public int getNumero()
        {
            return this.numero;
        }
        public int getId_groupe()
        {
            return this.id_groupe;
        }
        
        // Setters
        public void setId_groupe(int id_groupe)
        {
            this.id_groupe = id_groupe;
        }
        
        public void setNumero(int numero)
        {
            this.numero = numero;
        }


    
    
}
