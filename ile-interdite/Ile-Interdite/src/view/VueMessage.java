/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import util.Parameters;

/**
 *
 * @author louesdol
 */
public class VueMessage extends JFrame{
    private JLabel label;
    public VueMessage(){
        label= new JLabel("Départ Jeu");
        this.add(label);
        this.setSize(200,util.Parameters.HAUTEUR_VUE_AVENTURIER );
        this.setLocation(1400, Parameters.TOP_AUTRES_VUES+Parameters.HAUTEUR_VUE_AVENTURIER+100);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(Parameters.UNDECORATED);
        this.setResizable(Parameters.RESIZABLE);
        this.setVisible(true);
    }
    
    public void setLabel(String texte){
        label.setText(texte);
        
    }
}
