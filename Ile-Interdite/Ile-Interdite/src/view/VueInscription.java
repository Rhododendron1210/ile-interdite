package view;

import java.awt.GridLayout;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author IUT2-Dept Info
 */
public class VueInscription extends Observable {
    
   VueInscription(){
        JFrame window = new JFrame("Inscription");
        window.setSize(600, 400);
        
        JPanel panelSelectionNbJoueur = new JPanel(new GridLayout(1,3));   
        JRadioButton bout2 = new JRadioButton();
        JRadioButton bout3 = new JRadioButton();
        JRadioButton bout4 = new JRadioButton();
        
        panelSelectionNbJoueur.add(bout2);
        panelSelectionNbJoueur.add(bout3);
        panelSelectionNbJoueur.add(bout4);
        
        window.add(panelSelectionNbJoueur);
   }
    
    
    
    
}
