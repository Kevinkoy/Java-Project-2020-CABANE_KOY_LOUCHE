package Modele;

/**
 *
 * @author KévinKOY
 */
public class MaDate extends java.util.Date {
    /// Attributs (Heritage)

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public MaDate() {
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param jour
     * @param mois
     * @param annee
     */
    public MaDate(int jour, int mois, int annee) {
        this.setYear(annee);
        this.setMonth(mois);
        this.setDate(jour);
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param date Objet de class MaDate
     */
    public MaDate(MaDate date) {
        this.setYear(date.getYear());
        this.setMonth(date.getMonth());
        this.setDate(date.getDate());
    }

    /// Methodes 
    //ToString
    @Override
    public String toString() {
        return this.getDate() + "/" + this.getMonth() + "/" + this.getYear();
    }

    // DEJA IMPLEMENTES DANS LA LIBRAIRIE java.util.Date
    // Getters
    // Setters 
}

//semaine = (int) Math.ceil(((j-1)*30.41 + i)/7); 

