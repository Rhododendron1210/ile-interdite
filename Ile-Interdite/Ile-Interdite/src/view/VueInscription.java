package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author IUT2-Dept Info
 */
public class VueInscription extends Observable {
    
    public VueInscription(){
        
        JFrame window = new JFrame("Inscription");
        window.setSize(900,600);
        
        JPanel panel = new JPanel(new GridLayout(3,1));
        
        //Partie selection du nombre de joueur
        JPanel panelSelectionNbJoueur = new JPanel(new GridLayout(1,3));

        JRadioButton bout2 = new JRadioButton("2 joueurs");
        JRadioButton bout3 = new JRadioButton("3 joueurs");
        JRadioButton bout4 = new JRadioButton("4 joueurs");
                
        panelSelectionNbJoueur.add(bout2);
        panelSelectionNbJoueur.add(bout3);
        panelSelectionNbJoueur.add(bout4);
        
        panelSelectionNbJoueur.setBorder(BorderFactory.createTitledBorder("Nombre de joueurs")); 
                
        panel.add(panelSelectionNbJoueur);
        
        //Partie selection difficulé
        JPanel panelSelectionDifficulte = new JPanel(new GridLayout(1,4));
        
        JRadioButton boutNovice = new JRadioButton("Novice");
        JRadioButton boutNormal = new JRadioButton("Normal");
        JRadioButton boutElite = new JRadioButton("Elite");
        JRadioButton boutLegendaire = new JRadioButton("Légendadire");
        
        panelSelectionDifficulte.add(boutNovice);
        panelSelectionDifficulte.add(boutNormal);
        panelSelectionDifficulte.add(boutElite);
        panelSelectionDifficulte.add(boutLegendaire);
        
        panelSelectionDifficulte.setBorder(BorderFactory.createTitledBorder("Difficulté")); 
        
        panel.add(panelSelectionDifficulte);
        
        //Partie boutons "Règles", "Jouer", "Quitter"
        JPanel panelBoutons = new JPanel();
        
        JButton boutJouer = new JButton("Jouer");
        JButton boutRegles = new JButton("Règles");
        JButton boutQuitter = new JButton("Quitter");
                
        panelBoutons.add(boutJouer);
        panelBoutons.add(boutRegles);
        panelBoutons.add(boutQuitter);
        
        panel.add(panelBoutons);
        //affichage de la fenêtre
        window.add(panel);
        window.setVisible(true);
   }
}
