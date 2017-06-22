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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument.Iterator;
import util.Message;
import static util.Utils.Commandes.DEFAUSSE;

/**
 *
 * @author epalley
 */
public class VueDefausse extends JFrame{
    
    private int nbCarte;
    
    VueDefausse(int nbCarte, ArrayList<CarteTirage> cartes){
        
        JFrame window = new JFrame("Défausse des cartes");
        window.setSize(600,300);
        
        JPanel panel = new JPanel(new GridLayout(1,nbCarte));
        
        JScrollPane paneDeroulant = new JScrollPane(panel);
        paneDeroulant.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        while(nbCarte>10){
            
            for(int i = nbCarte; i>10; i++){
                
                JButton bout = new JButton();
                
                for (CarteTirage c : cartes){
                    
                    bout.setText(c.getNom());
                    
                    bout.addActionListener(new ActionListener(){
                    @Override
                        public void actionPerformed(ActionEvent e) {
                            Message m;
                            if (c.getNom() == "La Pierre Sacrée" ) {
                                m = new Message(DEFAUSSE, 1, 0, 0, 0, 0 ,0);
                            } else if (c.getNom() == "La statue du Zéphyr") {
                                m = new Message(DEFAUSSE, 0, 1, 0, 0, 0, 0);
                            } else if (c.getNom() == "Le Cristal Ardent") {
                                m = new Message(DEFAUSSE, 0, 0, 1, 0, 0, 0);
                            } else if (c.getNom() == "Le Calice de l'Onde") {
                                m = new Message(DEFAUSSE, 0, 0, 0, 1, 0, 0);
                            } else if (c.getNom() == "CarteHelicoptere") {
                                m = new Message(DEFAUSSE, 0, 0, 0, 0, 1, 0);
                            } else if (c.getNom() == "CarteSacsDeSable") {
                                m = new Message(DEFAUSSE, 0, 0, 0, 0, 0, 1);
                            }
                        }
                    });
                    
                    panel.add(bout);
                }
            }
        }
        
        window.setVisible(true);
    }
}
