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
public class Promotion 
{
    /// ATTRIBUTS
    private int id;
    private String nom;
    
    /// CONSTRUCTOR DEFAULT
    public Promotion()
    {
        
    }
    
    /// CONSTRUCTOR SURCHARGE
    public Promotion(int id, String nom)
    {
        this.id= id;
        this.nom=nom;
    }
    
    /// METHODES
        // Getters
        public int getId()
        {
        return this.id;
        }
    
        public String getNom()
        {
        return this.nom;
        }   

        // Setters
        public void setId(int id)
        {
            this.id = id;
        }
        
        public void setNom(String nom)
        {
            this.nom = nom;
        }
}
