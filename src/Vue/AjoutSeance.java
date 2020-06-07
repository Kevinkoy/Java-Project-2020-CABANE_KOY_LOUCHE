/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author ocabane
 */
public class AjoutSeance extends JFrame{
    private ArrayList<Seance> seances;
    private JPanel container;
    
    public void AjoutSeance()
    {
        this.seances=new ArrayList<Seance>();
        this.container = new JPanel();
    }
    
    public void afficherSeances()
    {
        //Bouton pour ajouter Seance
        JButton b = new JButton("Ajouter une Séance");
        
        for(int i=0; i<seances.size(); i++)
        {
            //afficher ligne par ligne chaue seance
        }
    }
    
}
