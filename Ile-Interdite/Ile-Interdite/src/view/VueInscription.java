package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import util.Message;
import util.Observateur;
import static util.Utils.Commandes.VALIDER_JOUEURS;

/**
 *
 * @author IUT2-Dept Info
 */
public class VueInscription extends Observable {
    
    private int nbJoueurs;
    private int difficulte;
    private Observateur observateur;
    private JFrame window;
    
    public VueInscription(){
        
        window = new JFrame("Inscription");
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
        
        //Partie selection difficulté
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
        
        //Récupération des données
        if (bout2.isSelected()) {
            nbJoueurs = 2;
        } else if (bout3.isSelected()) {
            nbJoueurs = 3;
        } else if (bout4.isSelected()) {
            nbJoueurs = 4;
}
        
        if (boutNovice.isSelected()) {
            difficulte = 1;
        } else if (boutNormal.isSelected()) {
            difficulte = 2;
        } else if (boutElite.isSelected()) {
            difficulte = 3;
        } else if (boutLegendaire.isSelected()) {
            difficulte = 4;
        }
        
        boutJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m;
                m = new Message(VALIDER_JOUEURS, null, null, null,  null, 0, 0);
                observateur.traiterMessage(m);
            }
        });
        
        boutRegles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        boutQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == boutQuitter){
                    getWindow().setVisible(false);
                    getWindow().dispose();
                }
            }
        });
        
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public int getDifficulte() {
        return difficulte;
    }
    
    public void setObservateur(Observateur observateur){
        this.observateur = observateur;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    } 
}
