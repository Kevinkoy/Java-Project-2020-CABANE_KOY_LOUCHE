/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import Controleur.*;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author ocabane
 */
public class EDTTest extends JFrame {

    private JPanel container = new JPanel();
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JLabel label1 = new JLabel("Etudiant : ");
    private JLabel label2 = new JLabel("Enseignant : ");
    private Utilisateur userco = new Utilisateur();

    public EDTTest(Utilisateur userco, Utilisateur userprint, int sem) {

        int droit = userco.getDroit();
        this.userco = userco;

        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants = findEtudiants();

        ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        enseignants = findEnseignants();

        ArrayList<Seance> seances = new ArrayList<Seance>();
        seances = findSeances(userprint, sem);

        this.setTitle("EDT");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        //on rentre dans notre combo tous les étudiants
        combo1.setPreferredSize(new Dimension(100, 20));
        for (int i = 0; i < etudiants.size(); i++) {
            combo1.addItem(etudiants.get(i));
        }
        combo1.addItemListener(new ItemState());
        //on rentre dans notre combo tous les enseignants
        combo2.setPreferredSize(new Dimension(100, 20));
        for (int i = 0; i < enseignants.size(); i++) {
            combo2.addItem(enseignants.get(i));
        }
        combo2.addItemListener(new ItemState());
        
        JPanel top = new JPanel();
        top.add(label1);
        top.add(combo1);
        top.add(label2);
        top.add(combo2);
        
        //affichage de l'emploi du temps
        for(int i=0; i<seances.size(); i++)
        {
            String cours = seances.get(i).getCours().getNom();
            MaDate date = seances.get(i).getDate();
            Time heure = seances.get(i).getHeure_debut();
        }

        container.add(top, BorderLayout.NORTH);

        this.setContentPane(container);
        this.setVisible(true);
    }

    class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            Calendar cal = Calendar.getInstance();
            int sem = cal.get(Calendar.WEEK_OF_YEAR);
            EDTTest edt = new EDTTest(userco, (Utilisateur) e.getItem(), sem);
        }
    }

    public static void main(String[] args) {
        //
    }

}
