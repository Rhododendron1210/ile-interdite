package view;

import java.util.Observable;
import javax.swing.JFrame;
import model.Tuile;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {
    private VueGrille grille;
    private JFrame frame;
    
    public VuePlateau(Tuile[][] tuiles){
        frame= new JFrame();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        grille = new VueGrille(tuiles);
        frame.setSize(1000, 1000);
        frame.add(grille);
        frame.setVisible(true);
    }
    
    
}
