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
import static util.Utils.Commandes.DEFAUSSE;

/**
 *
 * @author epalley
 */
public class VueDefausse extends JFrame{
    
    private int nbCarte;
    
    public VueDefausse(int nbCarte, ArrayList<CarteTirage> cartes){
        JFrame window = new JFrame("Défausse des cartes");
        window.setSize(300,300);
        JPanel panel = new JPanel(new GridLayout(cartes.size(),cartes.size()));
        JScrollPane paneDeroulant = new JScrollPane(panel);
        paneDeroulant.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (CarteTirage c : cartes){
            JButton bout = new JButton(c.getNom());
            bout.addActionListener(new ActionListener(){
                @Override
                    public void actionPerformed(ActionEvent e) {
                        Message m;
                        if (c.getNom() == "La Pierre Sacrée" ) {
                            m = new Message(DEFAUSSE,"La Pierre Sacrée");
                            window.setVisible(false);
                        } else if (c.getNom() == "La statue du Zéphyr") {
                            m = new Message(DEFAUSSE, "La statue du Zéphyr");
                            window.setVisible(false);
                        } else if (c.getNom() == "Le Cristal Ardent") {
                            m = new Message(DEFAUSSE, "Le Cristal Ardent");
                            window.setVisible(false);
                        } else if (c.getNom() == "Le Calice de l'Onde") {
                            m = new Message(DEFAUSSE, "Le Calice de l'Onde");
                            window.setVisible(false);
                        } else if (c.getNom() == "CarteHelicoptere") {
                            m = new Message(DEFAUSSE, "CarteHelicoptere");
                            window.setVisible(false);
                        } else if (c.getNom() == "CarteSacsDeSable") {
                            m = new Message(DEFAUSSE,"CarteSacsDeSable");
                            window.setVisible(false);
                        }
                    }
            });
        panel.add(bout);   
        }
        window.add(paneDeroulant);
        window.setVisible(true);
    }
}
