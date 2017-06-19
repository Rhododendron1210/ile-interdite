/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Contrôleur.Observateur;
import javax.swing.JFrame;

/**
 *
 * @author louesdol
 */
public class VueGeneral extends JFrame{

    /**
     * @param args the command line arguments
     */
    //ATTRIBUTS
    private Boutons boutons;
    private Observateur observateur;
    
    VueGeneral(){
        super("Vue General");
        Boutons b = new Boutons();
        this.add(b);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setSize(500,200);
        this.setVisible(true);
    }
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new VueGeneral();
    }

    
    
    
}
