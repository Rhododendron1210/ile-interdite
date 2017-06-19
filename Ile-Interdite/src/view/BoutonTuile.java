/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Tuile.Tuile;
import javax.swing.JButton;

/**
 *
 * @author louesdol
 */
public class BoutonTuile extends JButton{
    int colonne;
    int ligne;
    BoutonTuile(Tuile tuile){
        this.colonne=tuile.getColonne();
        this.ligne=tuile.getLigne();
        
    }
}
