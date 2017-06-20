package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Tuile;
import util.Observateur;
import util.Parameters;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau {
    private VueGrille grille;
    private JFrame frame;
    private Observateur observateur;
    private JButton deplacer;
    private JButton assecher;
    private JButton finir;
    public VuePlateau(Tuile[][] tuiles){
        frame= new JFrame();
        frame.setLocation(180, Parameters.TOP_AUTRES_VUES);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(1,3));
        deplacer=new JButton("Déplacer");
        assecher=new JButton("assecher");
        finir=new JButton("finir tour");
        panel.add(deplacer);
        panel.add(assecher);
        panel.add(finir);
        frame.add(panel,BorderLayout.NORTH);
        grille = new VueGrille(tuiles);
        frame.setSize(1200, 1000);
        frame.add(grille,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
