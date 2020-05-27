/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author KévinKOY
 */
public class Promotion {

    /// ATTRIBUTS
    private int id;
    private String nom;

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Promotion() {

    }

    /**
     * CONSTRUCTEUR SURCHARGE
     *
     * @param id
     * @param nom
     */
    public Promotion(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // METHODES
    // toString : retourner le contenue d'objet sous forme de chaine
    @Override
    public String toString() {
        if (this.id == 0) {
            return "Promotion introuvable";
        }
        return " id: " + this.id + ", nom: " + this.nom;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
