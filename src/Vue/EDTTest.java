/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import Controleur.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author ocabane
 */
public class EDTTest extends JFrame implements ActionListener {

    private JPanel container;
    private JComboBox combo1;
    private JComboBox combo2;
    private JLabel label1;
    private JLabel label2;
    private Utilisateur userco;
    private Utilisateur userprint;
    private int sem;
    private JButton[] tabButton;
    private GridBagConstraints gbc;
    private ArrayList<Enseignant> enseignants;
    private ArrayList<Etudiant> etudiants;

    public EDTTest(Utilisateur userco) {

        Calendar cal = Calendar.getInstance();

        this.gbc = new GridBagConstraints();
        this.userco = userco;
        this.userprint = userco;

        int semaine = cal.get(Calendar.WEEK_OF_YEAR);
        this.sem = semaine;

        this.label2 = new JLabel("Enseignant : ");
        this.label1 = new JLabel("Etudiant : ");
        this.combo2 = new JComboBox();

        int nbSemaines = cal.getWeeksInWeekYear();
        this.tabButton = new JButton[nbSemaines];

        this.combo1 = new JComboBox();
        this.container = new JPanel();
        this.etudiants = new ArrayList<Etudiant>();
        this.enseignants = new ArrayList<Enseignant>();
        //on ajoute a notre panel nos combos de tous les étudiants et tous les enseignants

        //TEST
        Groupe groupe1 = new Groupe();
        Etudiant etud1 = new Etudiant(3, "alice.cabane@edu.ece.fr", "12345", "Cabane", "Alice", 1, groupe1);
        this.etudiants.add(etud1);
        Etudiant etud2 = new Etudiant(1, "leonard.najman@edu.ece.fr", "12345", "Najman", "Leonard", 1, groupe1);
        this.etudiants.add(etud2);
        Etudiant etud3 = new Etudiant(2, "solene.haccoun@edu.ece.fr", "12345", "Haccoun", "Solene", 1, groupe1);
        this.etudiants.add(etud3);
        //TEST
        //this.etudiants = findEtudiants();

        //TEST
        Cours cours1 = new Cours(0, "POO Java");
        Enseignant prof1 = new Enseignant(4, "jean-pierre.segado@edu.ece.fr", "12345", "Segado", "Jean-Pierre", cours1);
        this.enseignants.add(prof1);
        //TEST
        //this.enseignants = findEnseignants();
    }

    public void afficherEDT() {

        int droit = getUserCo().getDroit();

        Calendar cal = Calendar.getInstance();
        this.combo1.removeAllItems();
        this.combo2.removeAllItems();
        this.container.removeAll();

        //On récupère toutes les séances de l'utilisateur à afficher
        ArrayList<Seance> seances = new ArrayList<Seance>();
        seances.clear();
        
        //A AJOUTER seances = findSeances(userprint, sem);

        //On créé notre JFrame et Notre Jpanel
        this.setTitle("EDT");
        this.setSize(1300, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.setSize(1300, 900);

        JPanel top = new JPanel();
        //Si l'utilisateur connecté est un ref ped (2) ou un admin (1)
        if (droit == 1 || droit == 2) {

            this.combo1.setPreferredSize(new Dimension(100, 20));

            System.out.println("nb etudiants dans la liste: " + this.etudiants.size());
            System.out.println("nb enseignants dans la liste: " + this.enseignants.size());

            this.combo1.addItem("");
            this.combo2.addItem("");

            for (int i = 0; i < this.etudiants.size(); i++) {
                this.combo1.addItem(this.etudiants.get(i).getPrenom() + " " + this.etudiants.get(i).getNom());
            }
            this.combo1.addActionListener(this);
            //on rentre dans notre combo tous les enseignants
            this.combo2.setPreferredSize(new Dimension(100, 20));
            for (int i = 0; i < enseignants.size(); i++) {
                this.combo2.addItem(enseignants.get(i).getPrenom() + " " + enseignants.get(i).getNom());
            }
            this.combo2.addActionListener(this);

            top.add(this.label1);
            top.add(this.combo1);
            top.add(this.label2);
            top.add(this.combo2);
        }

        JButton ligne = new JButton("Passer en ligne");
        ligne.setName("ligne");
        ligne.addActionListener(this);
        top.add(ligne);

        top.setBorder(BorderFactory.createTitledBorder("TOP"));
        container.add(top, BorderLayout.NORTH);

        //affichages des semaines
        JPanel middle = new JPanel();
        middle.setPreferredSize(new Dimension(1300, 130));
        middle.setBackground(Color.red);

        int nbSemaines = cal.getWeeksInWeekYear();

        for (int i = 0; i < this.tabButton.length; i++) {
            this.tabButton[i] = null;
        }
        for (int i = 0; i < nbSemaines; i++) {
            this.tabButton[i] = new JButton("" + (i + 1));
            this.tabButton[i].setName("" + i);
            this.tabButton[i].addActionListener(this);
            middle.add(this.tabButton[i]);
        }

        //affichage de l'emploi du temps
        JPanel bot = new JPanel(new GridBagLayout());
        bot.setBackground(Color.yellow);
        gbc.insets = new Insets(5, 2, 5, 2);

        //Connaitre chaque jour de la semaine
        for (int i = 0; i < 7; i++) {
            String Date = this.getDateofDay(i);
            JButton b = new JButton(Date);
            gbc.gridx = i + 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            bot.add(b, gbc);

            String Creneau = this.getCreneau(i);
            JButton b2 = new JButton(Creneau);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.fill = GridBagConstraints.BOTH;
            bot.add(b2, gbc);
        }

        int[][] tabEDT = new int[7][7];
        for (int i = 0; i < tabEDT.length; i++) {
            for (int j = 0; j < tabEDT[i].length; j++) {
                tabEDT[i][j] = 0;
            }
        }

        for (int i = 0; i < seances.size(); i++) {
            String cours = seances.get(i).getCours().getNom();
            Date date = seances.get(i).getDate();
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
            //b.setPreferredSize(new Dimension(250, 100));

            gbc.gridx = x + 1;
            gbc.gridy = y + 1;

            gbc.fill = GridBagConstraints.BOTH;

            tabEDT[x][y] = 1;
            bot.add(b, gbc);
            //boutons.add(b);
            //grid bag avec mon x et mon y
        }
        for (int i = 0; i < tabEDT.length; i++) {
            for (int j = 0; j < tabEDT[i].length; j++) {
                if (tabEDT[i][j] == 0) {
                    JButton b = new JButton("                 ");
                    //b.setPreferredSize(new Dimension(250, 100));
                    gbc.gridx = i + 1;
                    gbc.gridy = j + 1;
                    gbc.fill = GridBagConstraints.BOTH;
                    bot.add(b, gbc);
                }
            }
        }

        middle.setBorder(BorderFactory.createTitledBorder("MIDDLE"));
        bot.setBorder(BorderFactory.createTitledBorder("BOT"));

        BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout1);

        container.add(middle);
        container.add(bot);

        this.setContentPane(container);
        this.setVisible(true);
    }

    public String getNameMonth(int mois) {
        String nomMois = null;
        switch (mois) {
            case 0:
                nomMois = "Janvier";
                break;
            case 1:
                nomMois = "Février";
                break;
            case 2:
                nomMois = "Mars";
                break;
            case 3:
                nomMois = "Avril";
                break;
            case 4:
                nomMois = "Mai";
                break;
            case 5:
                nomMois = "Juin";
                break;
            case 6:
                nomMois = "Juillet";
                break;
            case 7:
                nomMois = "Aout";
                break;
            case 8:
                nomMois = "Septembre";
                break;
            case 9:
                nomMois = "Octobre";
                break;
            case 10:
                nomMois = "Novembre";
                break;
            case 11:
                nomMois = "Décembre";
                break;
        }
        return nomMois;
    }

    public String getDateofDay(int jour) {
        int date;
        int mois;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, this.sem);
        String EntireFrenchDate = null;
        switch (jour) {
            case 0:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Lundi " + date + " " + this.getNameMonth(mois);
                break;
            case 1:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Mardi " + date + " " + this.getNameMonth(mois);
                break;
            case 2:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Mercredi " + date + " " + this.getNameMonth(mois);
                break;
            case 3:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Jeudi " + date + " " + this.getNameMonth(mois);
                break;
            case 4:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Vendredi " + date + " " + this.getNameMonth(mois);
                break;
            case 5:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Samedi " + date + " " + this.getNameMonth(mois);
                break;
            case 6:
                cal.set(Calendar.WEEK_OF_YEAR, this.sem + 1);
                cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                date = cal.getTime().getDate();
                mois = cal.getTime().getMonth();
                EntireFrenchDate = "Dimanche " + date + " " + this.getNameMonth(mois);
                break;

        }
        return EntireFrenchDate;
    }

    public String getCreneau(int i) {
        String Creneau = null;
        switch (i) {
            case 0:
                Creneau = "8h30 - 10h00";
                break;
            case 1:
                Creneau = "10h15 - 11h45";
                break;
            case 2:
                Creneau = "12h00 - 13h30";
                break;
            case 3:
                Creneau = "13h45 - 15h15";
                break;
            case 4:
                Creneau = "15h30 - 17h00";
                break;
            case 5:
                Creneau = "17h15 - 18h45";
                break;
            case 6:
                Creneau = "19h00 - 20h30";
                break;
        }
        return Creneau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        int semaine = 1;

        if (src instanceof JButton) {
            JButton b = (JButton) src;
            String name = b.getName();
            if (name.equals("ligne")) {
                //je crée une instance de emploidutemps
                EmploiDuTemps edtLigne = new EmploiDuTemps(this.userco);
                this.setVisible(false);
            } else {
                for (int i = 0; i < this.tabButton.length; i++) {
                    String test = "" + (i + 1);
                    if (name.equals(test)) {
                        semaine = i + 1;
                    }
                }
                this.setSem(semaine);
                System.out.println("Changement de semaine " + this.getSem());
                this.afficherEDT();
            }
        } else if (src instanceof JComboBox) {
            JComboBox combo = (JComboBox) src;
            if (combo.getSelectedItem() != null) {
                Object selected = combo.getSelectedItem();
                for (int i = 0; i < this.etudiants.size(); i++) {
                    if (selected.toString().equals(this.etudiants.get(i).getPrenom() + " " + this.etudiants.get(i).getNom())) {
                        System.out.println("j'ai trouvé un match etudiant : " + selected);
                        Etudiant userSelected = this.etudiants.get(i);
                    }
                }
                for (int i = 0; i < this.enseignants.size(); i++) {
                    if (selected.toString().equals(this.enseignants.get(i).getPrenom() + " " + this.enseignants.get(i).getNom())) {
                        Enseignant userSelected = this.enseignants.get(i);
                        System.out.println("j'ai trouvé un match enseignant : " + selected);
                    }
                }
            }
        }
        /*if (droit == 1 || droit == 2) {
            if (src == this.combo1 || src == this.combo2) {
                JComboBox combo = (JComboBox) src;
                Object selected = combo.getSelectedItem();
                String command = e.getActionCommand();
                if ("comboBoxChanged".equals(command)) {
                    System.out.println(selected);
                    this.afficherEDT();
                }
            } 
            else{
                JButton bouton = (JButton) src;
                String name = bouton.getName();
                int semaine = 1;
                for (int i = 0; i < 54; i++) {
                    String test = "" + (i + 1);
                    if (name.equals(test)) {
                        semaine = i+1;
                    }
                }
                //EDTTest edt = new EDTTest(this.userco, this.userprint, sem);
                this.setSem(semaine);
                System.out.println("Changement de semaine " + this.getSem());
                this.afficherEDT();
            }
        } else {
            JButton bouton = (JButton) src;
            String name = bouton.getName();
            int semaine = 1;
            for (int i = 0; i < 54; i++) {
                String test = "" + (i + 1);
                if (name.equals(test)) {
                    System.out.println(i);
                    semaine = i+1;
                }
            }
            //EDTTest edt = new EDTTest(this.userco, this.userprint, sem);
            this.setSem(semaine);
            System.out.println("Changement de semaine " + semaine);
            this.afficherEDT();
        }*/
        //this.afficherEDT();
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public void setUserCo(Utilisateur userco) {
        this.userco = userco;
    }

    public void setUserPrint(Utilisateur userprint) {
        this.userprint = userprint;
    }

    public int getSem() {
        return (this.sem);
    }

    public Utilisateur getUserCo() {
        return (this.userco);
    }

    public Utilisateur getUserPrint() {
        return (this.userprint);
    }

    public static void main(String[] args) {
        //TEST
        Utilisateur userco = new Utilisateur(5, "kevin.koy@edu.ece.fr", "12345", "Koy", "Kevin", 2);
        EDTTest edt = new EDTTest(userco);
        edt.afficherEDT();

        //TEST
    }

}
