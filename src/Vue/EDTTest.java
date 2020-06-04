/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import Controleur.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private ArrayList<JButton> boutons = new ArrayList<JButton>();
    GridBagConstraints gbc = new GridBagConstraints();

    public EDTTest(Utilisateur userco, Utilisateur userprint, int sem) {

        int droit = userco.getDroit();
        this.userco = userco;

        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        //TEST
        Groupe groupe1 = new Groupe();
        Etudiant etud1 = new Etudiant(3, "alice.cabane@edu.ece.fr", "12345", "Cabane", "Alice", 1, groupe1);
        etudiants.add(etud1);
        Etudiant etud2 = new Etudiant(1, "leonard.najman@edu.ece.fr", "12345", "Najman", "Leonard", 1, groupe1);
        etudiants.add(etud2);
        Etudiant etud3 = new Etudiant(2, "solene.haccoun@edu.ece.fr", "12345", "Haccoun", "Solene", 1, groupe1);
        etudiants.add(etud3);
        //TEST
        //etudiants = findEtudiants();

        ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        //TEST
        Cours cours1 = new Cours(0, "POO Java");
        Enseignant prof1 = new Enseignant(4, "jean-pierre.segado@edu.ece.fr", "12345", "Segado", "Jean-Pierre", cours1);
        enseignants.add(prof1);
        //TEST
        //enseignants = findEnseignants();

        ArrayList<Seance> seances = new ArrayList<Seance>();
        //TEST
        Type_cours type_cours1 = new Type_cours(0, "TP");
        Seance seance1 = new Seance(0, new MaDate(4, 6, 2020), new Time(8, 30, 0), new Time(10, 0, 0), 0, cours1, type_cours1);
        seances.add(seance1);
        Seance seance2 = new Seance(1, new MaDate(4, 6, 2020), new Time(10, 15, 0), new Time(11, 45, 0), 0, cours1, type_cours1);
        seances.add(seance2);
        Seance seance3 = new Seance(2, new MaDate(5, 6, 2020), new Time(8, 30, 0), new Time(10, 0, 0), 0, cours1, type_cours1);
        seances.add(seance3);
        //TEST
        //seances = findSeances(userprint, sem);

        this.setTitle("EDT");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new GridLayout(7, 7));

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        //on rentre dans notre combo tous les étudiants
        combo1.setPreferredSize(new Dimension(100, 20));
        for (int i = 0; i < etudiants.size(); i++) {
            combo1.addItem(etudiants.get(i).getPrenom() + " " + etudiants.get(i).getNom());
        }
        combo1.addItemListener(new ItemState());
        //on rentre dans notre combo tous les enseignants
        combo2.setPreferredSize(new Dimension(100, 20));
        for (int i = 0; i < enseignants.size(); i++) {
            combo2.addItem(enseignants.get(i).getPrenom() + " " + enseignants.get(i).getNom());
        }
        combo2.addItemListener(new ItemState());

        JPanel top = new JPanel();
        top.add(label1);
        top.add(combo1);
        top.add(label2);
        top.add(combo2);

        //affichage de l'emploi du temps
        JPanel bot = new JPanel();
        for (int i = 0; i < seances.size(); i++) {
            String cours = seances.get(i).getCours().getNom();
            MaDate date = seances.get(i).getDate();
            Time heure = seances.get(i).getHeure_debut();
            int x = date.getDay();
            int creneau = 8;
            int y = 0;
            while (creneau != heure.getHours()) {
                if (creneau == 12) {
                    creneau++;
                } else {
                    creneau += 2;
                }
                y++;
            }

            JButton b = new JButton(cours);
            gbc.gridx = x;
            gbc.gridy = y;
            top.add(b, gbc);
            //boutons.add(b);
            //grid bag avec mon x et mon y
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
        //TEST
        Utilisateur userco = new Utilisateur(5, "kevin.koy@edu.ece.fr", "12345", "Koy", "Kevin", 0);
        Calendar cal = Calendar.getInstance();
        int sem = cal.get(Calendar.WEEK_OF_YEAR);
        EDTTest edt = new EDTTest(userco, userco, sem);
        //TEST
    }

}
