/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author louesdol
 */
public class Boutons extends JPanel{
    //Attributs
    private JButton deplacer;
    private JButton assecher;
    private JButton finir;
    //Constructeur
    Boutons(){
        deplacer = new JButton("Se Déplacer");
        assecher = new JButton("Assecher");
        finir = new JButton("Finir");
        this.setLayout(new GridLayout(1,3));
        this.add(deplacer);
        this.add(assecher);
        this.add(finir);
    }
}
