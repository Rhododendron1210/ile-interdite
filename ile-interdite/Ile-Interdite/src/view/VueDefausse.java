/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Tresor.CarteTirage;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument.Iterator;

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
                
                JTextPane pane = new JTextPane();
                panel.add(pane);
                
                //Iterator ite = cartes.iterator();
                //pane.add(carte);
            }
        }
        
        
    }
}
