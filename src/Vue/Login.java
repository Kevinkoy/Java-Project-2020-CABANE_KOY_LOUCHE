/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import Controleur.*;
import DataAcessObject.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ocabane
 */
public class Login extends JFrame implements ActionListener {

    private JPanel container = new JPanel();
    private JTextField jtf = new JTextField("ex : alice.cabane@edu.ece.fr");
    private JLabel label = new JLabel("Email :");
    private JPasswordField jpf = new JPasswordField();
    private JLabel label2 = new JLabel("Mot de passe :");
    private JButton connexion = new JButton("Se connecter");

    public Login() {
        this.setTitle("Login");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        jpf.setFont(police);
        jpf.setPreferredSize(new Dimension(150, 30));
        jpf.setForeground(Color.BLUE);
        jpf.setEchoChar('*');

        top.add(label);
        top.add(jtf);
        top.add(label2);
        top.add(jpf);
        top.add(connexion);

        connexion.addActionListener(this);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connexion) {
            String email = jtf.getText();
            char[] mdp = jpf.getPassword();
            String mdpString = "";
            for (int i = 0; i < mdp.length; i++) {
                mdpString += mdp[i];
            }
            
            //VERIF MAIL
            Pattern pattern;
            Matcher matcher;
            String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@edu.ece.fr$";
            pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(email);
            boolean valid = matcher.matches();
            
            if (valid) {
                Utilisateur user = new Utilisateur();
                Recherche_informations infos = new Recherche_informations(email, mdpString);
                Utilisateur userco = infos.getUser();
                //user = find(email, mdp) //find dans quel classe ? besin creer une entite recheche info ?
                if (userco!=null) //si non null
                {
                    
                    EDTTest edt = new EDTTest(userco);
                } else {
                    JOptionPane.showMessageDialog(null, "L'email et/ou le mot de passe que vous avez saisi sont erronés", "Mauvais match", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "L'email que vous avez saisi est invalide", "Mauvais mail", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Login log = new Login();
    }
}

