/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Tresor.CarteTirage;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.aventuriers.Aventurier;
import util.Message;
import util.Observateur;
import static util.Utils.Commandes.DONNER;

/**
 *
 * @author louesdol
 */
public class VueEchange extends JFrame {

    private Observateur observateur;
    private JButton valider;
    private JPanel mainPanel;
    private ButtonGroup grJoueurs;
    private ButtonGroup grCartes;

    public VueEchange(ArrayList<CarteTirage> possede, ArrayList<Aventurier> joueurs) {
        this.setLayout(new BorderLayout());
        valider = new JButton("Valider");
        mainPanel = new JPanel(new GridLayout(1, 2));
        mesCartes(possede);
        joueurs(joueurs);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String joueur=null;
                for (Enumeration<AbstractButton> buttons = grJoueurs.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        joueur =button.getText();
                    }
                }
                String carte=null;
                for (Enumeration<AbstractButton> buttons = grCartes.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        carte =button.getText();
                    }
                }
                Message m=new Message(DONNER,joueur,carte,null,null);
                observateur.traiterMessage(m);
            }

        });

    }

    private void mesCartes(ArrayList<CarteTirage> possede) {
        int i = possede.size();
        JPanel panel = new JPanel(new GridLayout(i, 1));
        grCartes = new ButtonGroup();
        for (CarteTirage carte : possede) {
            JRadioButton bout = new JRadioButton(carte.getNom(), true);
            panel.add(bout);
            grCartes.add(bout);
        }
        panel.setBorder(BorderFactory.createTitledBorder("Choisir une carte"));
        mainPanel.add(panel);
    }

    private void joueurs(ArrayList<Aventurier> joueurs) {
        int i = joueurs.size();
        JPanel panel = new JPanel(new GridLayout(i, 1));
        grJoueurs = new ButtonGroup();
        for (Aventurier av : joueurs) {
            JRadioButton bout = new JRadioButton(av.getNom(), true);
            panel.add(bout);
            grJoueurs.add(bout);
        }
        panel.setBorder(BorderFactory.createTitledBorder("Choisir un joueur"));
        mainPanel.add(panel);
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

}
