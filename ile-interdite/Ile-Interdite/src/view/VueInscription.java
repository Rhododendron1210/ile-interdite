
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
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
        //je suis vivant
        window = new JFrame("Inscription");
        window.setSize(900,600);
        
        JPanel panel = new JPanel(new GridLayout(3,1));
        
        //Partie selection du nombre de joueur
        JPanel panelSelectionNbJoueur = new JPanel(new GridLayout(1,3));

        JRadioButton bout2 = new JRadioButton("2 joueurs",true);
        JRadioButton bout3 = new JRadioButton("3 joueurs");
        JRadioButton bout4 = new JRadioButton("4 joueurs");     
        
        ButtonGroup grNbJoueurs = new ButtonGroup();
        grNbJoueurs.add(bout2);
        grNbJoueurs.add(bout3);
        grNbJoueurs.add(bout4);
        
        panelSelectionNbJoueur.add(bout2);
        panelSelectionNbJoueur.add(bout3);
        panelSelectionNbJoueur.add(bout4);
                
        panelSelectionNbJoueur.setBorder(BorderFactory.createTitledBorder("Nombre de joueurs")); 
                
        panel.add(panelSelectionNbJoueur);
        
        //Partie selection difficulté
        JPanel panelSelectionDifficulte = new JPanel(new GridLayout(1,4));
        
        JRadioButton boutNovice = new JRadioButton("Novice");
        JRadioButton boutNormal = new JRadioButton("Normal",true);
        JRadioButton boutElite = new JRadioButton("Elite");
        JRadioButton boutLegendaire = new JRadioButton("Légendadire");
        
        ButtonGroup grDifficulte = new ButtonGroup();
        grDifficulte.add(boutNovice);
        grDifficulte.add(boutNormal);
        grDifficulte.add(boutElite);
        grDifficulte.add(boutLegendaire);
        
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
       
        
        boutJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                Message m;
                m = new Message(VALIDER_JOUEURS, null, null, null,  null, nbJoueurs , difficulte);
                observateur.traiterMessage(m);
            }
        });
        
        boutRegles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame regles = new JFrame("Règles");
                regles.setSize(750,1000);
                JPanel panel = new JPanel(new GridLayout(8,1));
                JTextPane image1 = new JTextPane();
                JTextPane image2 = new JTextPane();
                JTextPane image3 = new JTextPane();
                JTextPane image4 = new JTextPane();
                JTextPane image5 = new JTextPane();
                JTextPane image6 = new JTextPane();
                JTextPane image7 = new JTextPane();
                JTextPane image8 = new JTextPane();
                JScrollPane texteDeroulant = new JScrollPane(panel);
                texteDeroulant.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                panel.add(image1);
                panel.add(image2);
                panel.add(image3);
                panel.add(image4);
                panel.add(image5);
                panel.add(image6);
                panel.add(image7);
                panel.add(image8);
                image1.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/1.jpg"));
                image2.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/2.jpg"));
                image3.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/3.jpg"));
                image4.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/4.jpg"));
                image5.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/5.jpg"));
                image6.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/6.jpg"));
                image7.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/7.jpg"));
                image8.insertIcon(new ImageIcon("/users/info/etu-s2/epalley/Règles ileinterdite/8.jpg"));
                regles.add(texteDeroulant);
                regles.setVisible(true);
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