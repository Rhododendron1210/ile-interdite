/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Tresor.CarteTirage;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument.Iterator;
import util.Message;
import util.Observateur;
import static util.Utils.Commandes.DEFAUSSE;

/**
 *
 * @author epalley
 */
public class VueDefausse extends JFrame {

    private Observateur observateur;

    public VueDefausse( ArrayList<CarteTirage> cartes) {
        //JFrame window = new JFrame("Défausse des cartes");  //création de la fenêtre
        this.setSize(300, 300);    //changement de la taille de la fenêtre
        JPanel panel = new JPanel(new GridLayout(cartes.size(), cartes.size())); //création d'un panel principal
        JScrollPane paneDeroulant = new JScrollPane(panel); //création d'un affichage déroulant
        paneDeroulant.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    //fixation de la barre de scrolling
        for (CarteTirage c : cartes) {   //parcours de la collection de cartes
            JButton bout = new JButton(c.getNom()); //création d'un bouton, sa légende est définie par le nom de la carte
            bout.addActionListener(new ActionListener() {    //gestion des cliques de la souris sur un bouton
                @Override   //redéfinition des méthodes
                public void actionPerformed(ActionEvent e) {    //gestion des actions
                    Message m;  //création d'un message
                    if (c.getNom() == "La Pierre Sacrée") {    //si le nom correspond
                        m = new Message(DEFAUSSE, "La Pierre Sacrée");   //envoie un message
                        observateur.traiterMessage(m);
                    } else if (c.getNom() == "La statue du Zéphyr") {   //si le nom correspond
                        m = new Message(DEFAUSSE, "La statue du Zéphyr");  //envoie un message
                        observateur.traiterMessage(m);
                    } else if (c.getNom() == "Le Cristal Ardent") { //si le nom correspond
                        m = new Message(DEFAUSSE, "Le Cristal Ardent");  //envoie un message
                        observateur.traiterMessage(m);
                    } else if (c.getNom() == "Le Calice de l'Onde") {  //si le nom correspond 
                        m = new Message(DEFAUSSE, "Le Calice de l'Onde");  //envoie un message
                        observateur.traiterMessage(m);
                    } else if (c.getNom() == "CarteHelicoptere") {  //si le nom correspond
                        m = new Message(DEFAUSSE, "CarteHelicoptere");  //envoie un message
                        observateur.traiterMessage(m);
                    } else {  //si le nom correspond
                        m = new Message(DEFAUSSE, "CarteSacsDeSable");  //envoie un message
                        observateur.traiterMessage(m);
                    }
                }
            });
            panel.add(bout);   //ajout des boutons au panel principal
        }
        this.add(paneDeroulant);  //ajout de l'affichage déroulant à la fenêtre
        this.setVisible(true);    //ouvre la fenêtre
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
}
