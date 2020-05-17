package Modele;

import java.sql.*;
import java.util.Calendar;

/**
 *
 * @author KévinKOY
 */
public class Seance 
{
    /// Attributs
    private int id;
    private int semaine;
    private MaDate date;
    private Time heure_debut;
    private Time heure_fin;
    private int etat;
    private int id_cours;
    private int id_type;
              
    /// Constructor default
    public Seance()
    {
        
    }
    
    /// Constructor surcharge
    public Seance(int id, MaDate date, Time heure_debut, Time heure_fin, int etat, int id_cours, int id_type)
    { 
     // MODIFICATION POSSIBLE
     this.id = id;
     //this.semaine = (int) Math.ceil(((date.getMois()-1)*30.41 + date.getJour())/7);
     Calendar cal = Calendar.getInstance();
     cal.setTime(date);
     this.semaine = cal.get(Calendar.WEEK_OF_YEAR);
     this.date = new MaDate(date);
     this.heure_debut = new Time(0,0,0);
     this.heure_debut = heure_debut;
     this.heure_fin =  new Time(heure_debut.getHours() + heure_fin.getHours(),heure_debut.getMinutes()+ heure_fin.getMinutes(), 0);

     this.etat = etat; 
     this.id_cours = id_cours;
     this.id_type = id_type;
    }
    
    
    public Seance(Seance seance)
    {
      // MODIFICATION POSSIBLE
    }
    
    /// Methodes 
        //ToString
    @Override
        public String toString()
        {
            return "id: " + id + ", semaine: " + semaine + ", date: " + date + ", heure de debut: " + heure_debut + ", heure de fin: " 
                    + heure_fin + ", etat: " + etat + ", id cours: " + id_cours + ", id type: " + id_type;
        }
    
        // Getters
        public int getId()
        {
            return this.id;
        }
        public int getSemaine()
        {
            return this.semaine;
        }
        public MaDate getDate()
        {
            return this.date;
        }
        public Time getHeure_debut()
        {
            return this.heure_debut;
        }
        public Time getHeure_fin()
        {
            return this.heure_fin;
        }
        public int getEtat()
        {
            return this.etat;
        }
        public int getId_cours()
        {
            return this.id_cours;
        }
        public int getId_type()
        {
            return this.id_type;
        }
        
        // Setters
        public void setId(int id)
        {
            this.id =id;
        }
        
        public void setSemaine(int semaine)
        {
            this.semaine = semaine;
        }
        
        public void setDate(MaDate date)
        {
            this.date = date;
        }
        
        public void setHeure_debut(Time heure_debut)
        {
            this.heure_debut = heure_debut;
        }
        
        public void setHeure_fin(Time heure_fin)
        {
            this.heure_fin = heure_fin;
        }
        
        public void setEtat(int etat)
        {
            this.etat = etat;
        }
        
        public void setId_cours(int id_cours)
        {
            this.id_cours = id_cours;
        }
        
        public void setId_type(int id_type)
        {
            this.id_type = id_type;
        }
        
}

