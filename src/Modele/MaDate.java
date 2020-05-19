package Modele;

/**
 *
 * @author KévinKOY
 */
public class MaDate extends java.util.Date
{
    /// Attributs
    // heritage 
    
    /// Constructor default
    public MaDate()
    { 
    }
    /// Constructor surcharge
  
    public MaDate(int jour, int mois, int annee)
    {
        this.setYear(annee);
        this.setMonth(mois);
        this.setDate(jour);
    }
    
    public MaDate(MaDate date)
    {
        this.setYear(date.getYear());
        this.setMonth(date.getMonth());
        this.setDate(date.getDate());
    }
    
    
    /// Methodes 
        //ToString
        @Override
        public String toString()
        {
         return this.getDate()+"/"+this.getMonth()+"/" +this.getYear();
        }
    
        // DEJA IMPLEMENTES DANS LA LIBRAIRIE java.util.Date
        // Getters
        // Setters 
    
    
}
    
//semaine = (int) Math.ceil(((j-1)*30.41 + i)/7); 

