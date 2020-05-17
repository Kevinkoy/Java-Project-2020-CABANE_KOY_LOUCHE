package Vue;
//import javax.swing.*;
//import java.awt.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author KévinKOY
 */
public class Fenetre extends javax.swing.JFrame 
{  
    /// Attributs
        // herite JFrame 
    
    // Constructor default
    public Fenetre()
    {
        // Titre
        this.setTitle("ECE Planning");
        
        // Dimensions
        this.setSize(500, 500);
        
        // Positionnement
        this.setLocationRelativeTo(null);
    
            // DECLARATION d'un type Panneau (extends JPanel)
            Panneau pan;
            // Initialisation
            pan = new Panneau();
            
            // Couleur de fond
            pan.setBackground(Color.BLUE);

            //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan); 
      
        // Exit si click sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Booleen Visible : VRAI
        this.setVisible(true);
        
    /*
    //Empêcher le redimensionnement de la fenêtre
    this.setResizable(true);
    // Garder la fenêtre au premier plan
    this.setAlwaysOnTop(true);
    */
    
    }
    
  public static void main(String[] args)
  {       
      // DECLARATION
    Fenetre fenetre1;
    
    // INITIALISATION
    fenetre1 = new Fenetre();

  }  
    
    
}