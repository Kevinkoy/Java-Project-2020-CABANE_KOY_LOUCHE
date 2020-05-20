package Modele;

import java.sql.*;
import java.util.Calendar;

/**
 *
 * @author KévinKOY
 */
public class Seance {

    /// Attributs
    private int id;
    private int semaine;
    private MaDate date;
    private Time heure_debut;
    private Time heure_fin;
    private int etat;
    private Cours cours;
    private Type_cours type_cours;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Seance() {

    }

    /**
     *
     * @param id
     * @param date
     * @param heure_debut
     * @param heure_fin
     * @param etat
     * @param cours
     * @param type_cours
     */
    public Seance(int id, MaDate date, Time heure_debut, Time heure_fin, int etat, Cours cours, Type_cours type_cours) {
        // MODIFICATION POSSIBLE
        this.id = id;
        //this.semaine = (int) Math.ceil(((date.getMois()-1)*30.41 + date.getJour())/7);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.semaine = cal.get(Calendar.WEEK_OF_YEAR);
        this.date = new MaDate(date);
        this.heure_debut = new Time(0, 0, 0);
        this.heure_debut = heure_debut;
        this.heure_fin = new Time(heure_debut.getHours() + heure_fin.getHours(), heure_debut.getMinutes() + heure_fin.getMinutes(), 0);

        this.etat = etat;
        this.cours = cours;
        this.type_cours = type_cours;
    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param seance objet de class Seance
     */
    public Seance(Seance seance) {
        this.id = seance.id;
        this.semaine = seance.semaine;
        this.date = seance.date;
        this.heure_debut = seance.heure_debut;
        this.heure_fin = seance.heure_fin;
        this.etat = seance.etat;
        this.cours = seance.cours;
        this.type_cours = seance.type_cours;
    }

    /// METHODES 
    //ToString
    @Override
    public String toString() {
        return "id: " + id + ", semaine: " + semaine + ", date: " + date + ", heure de debut: " + heure_debut + ", heure de fin: "
                + heure_fin + ", etat: " + etat + ", id cours: " + cours + ", id type: " + type_cours;
    }

    // GETTERS
    public int getId() {
        return this.id;
    }

    public int getSemaine() {
        return this.semaine;
    }

    public MaDate getDate() {
        return this.date;
    }

    public Time getHeure_debut() {
        return this.heure_debut;
    }

    public Time getHeure_fin() {
        return this.heure_fin;
    }

    public int getEtat() {
        return this.etat;
    }

    public Cours getCours() {
        return this.cours;
    }

    public Type_cours getType_cours() {
        return this.type_cours;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public void setDate(MaDate date) {
        this.date = date;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public void setType_cours(Type_cours type_cours) {
        this.type_cours = type_cours;
    }

}
