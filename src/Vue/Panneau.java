package Vue;

// AWT
//import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

// SWING
//import javax.swing.*;
import javax.swing.JPanel;

// IO
import java.io.File;
import java.io.IOException;

// IMAGEIO
import javax.imageio.ImageIO;


/**
 *
 * @author KévinKOY
 */
public class Panneau extends javax.swing.JPanel
{
    //Attributs
    
    // Constructor
    public Panneau()
    {
    }
    
    // Methods
    public void paintComponent(Graphics g)
    {
    /* 
        // Graphics2D version amélioré de Graphics (Dégradé de couleur)
        Graphics2D g2d = (Graphics2D) g;     
        
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 0, Color.BLACK, true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());  
    */
        
        // Affichage d'un message à chaque mise à jour du panneau
        System.out.println("Panneau mise à jour");
        
        // Centrer le Component par rapport à la taille de la fenetre
        int x1 = this.getWidth()/4;
        int y1 = this.getHeight()/4;     
        
        // Dessins
        /*
        // CERCLES
        g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
        g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
        
        // RECTANGLES
        g.drawRect(10, 10, 50, 60);
        g.fillRect(65, 65, 30, 40);
 
        // RECTANGLES A BORD ARRONDI
        g.drawRoundRect(10, 10, 30, 50, 10, 10);
        g.fillRoundRect(55, 65, 55, 30, 5, 5);
        
         //x1, y1, x2, y2
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);

        // Polygones
        int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
        int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
        g.drawPolygon(x, y, 8);

        int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
        int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
        g.fillPolygon(x2, y2, 8);
        */
        
            // Modifier la couleur et la police
            Font font = new Font("Courier", Font.BOLD, 20);
            g.setFont(font);
            g.setColor(Color.red);      
            
            // Afficher un MESSAGE
            g.drawString("Affichage d'un message", 10, 20);
            
            // Afficher une IMAGE +EXCEPTIONS
            try 
            {
            Image img = ImageIO.read(new File("image/Cenote.jpg"));
            
            //Pour une image non adapté
            //g.drawImage(img, 0, 0, this);

            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
            catch (IOException e) 
            {
            e.printStackTrace();
            }
            
        
    }
    
}
