package view;

import java.util.Observable;
import javax.swing.JFrame;
import model.Tuile;
import util.Observateur;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau {
    private VueGrille grille;
    private JFrame frame;
    private Observateur observateur;
    public VuePlateau(Tuile[][] tuiles){
        frame= new JFrame();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        grille = new VueGrille(tuiles);
        frame.setSize(1500, 1200);
        frame.add(grille);
        frame.setVisible(true);
    }
}
