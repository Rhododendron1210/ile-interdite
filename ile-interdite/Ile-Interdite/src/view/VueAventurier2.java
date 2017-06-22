/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Tresor.CarteTirage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.aventuriers.Aventurier;
import util.Parameters;

/**
 *
 * @author louesdol
 */
public class VueAventurier2 extends JPanel{
    private JLabel nomAventurier;
    
    public VueAventurier2(Aventurier a,Color couleur){
        this.setLayout(new BorderLayout());
        nomAventurier= new JLabel(a.getNom());
        this.add(nomAventurier,BorderLayout.NORTH);
        this.setBackground(couleur);
        afficherCartes(a.getPossede());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setVisible(true);
        
    }
    
    private void afficherCartes(ArrayList<CarteTirage> cartes){
        JPanel panel = new JPanel(new GridLayout(3,3));
        JPanel card;
        for (CarteTirage carte : cartes){
            card=new JPanel(new BorderLayout());
            JLabel label = new JLabel(carte.getNom());
            card.add(label);
            Border blackline = BorderFactory.createLineBorder(Color.black);
            card.setBorder(blackline);
            panel.add(card);
        }
        this.add(panel,BorderLayout.CENTER);
    }
    
}
