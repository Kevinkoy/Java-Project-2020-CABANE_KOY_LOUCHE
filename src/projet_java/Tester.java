package projet_java;
import Modele.*;
import Modele.MaDate;

//import java.util.*;
import java.sql.*;
// TEST
/**
 *
 * @author KévinKOY, AliceCABANE, SylvainLOUCHE, Student at ECE PARIS, PROJET JAVA 2020 ING3_TD4 
 */
public class Tester
{

    public static void main(String[] args) 
    {           
        // DECLARATION
        Seance maSeance;
        Time time;
        Time duree;
        MaDate date;
        
        // Intialisation
        time = new Time(0,0,0);
        duree = new Time(1,30,0);
        date =  new MaDate(21, 5, 1999);
        maSeance = new Seance(4,date, time, duree, 2, 56, 2);
        
        /// Display
        System.out.print(maSeance.toString());
           
    }
    
}
