/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author ocabane
 */
public class MajDonnees extends JFrame implements ActionListener {

    private ArrayList<Seance> seances;
    private JPanel container;
    private Utilisateur userco;

    public void MajDonnees(Utilisateur userco) {
        this.seances = new ArrayList<Seance>();
        this.container = new JPanel();
        this.userco = userco;
    }

    public void afficherSeances() {
        //Bouton pour ajouter Seance
        JButton b = new JButton("Ajouter une Séance");
        b.setName("ajout");
        b.addActionListener(this);

        for (int i = 0; i < seances.size(); i++) {

            //afficher ligne par ligne chaue seance
        }
    }

    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src instanceof JButton) {
            JButton b = (JButton) src;
            String name = b.getName();
            if (name.equals("ajout")) {
                //je crée une instance de Formulaire seance
            }
        }

    }
}
