/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Tuile.Tuile;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Yannis
 */
public class Grille {
    
    
    private Tuile[][] grille;
    
    Grille() {
        grille =new Tuile[6][6];
    }

    public Tuile[][] getGrille() {
        return grille;
    }
    
    public Tuile getTuile(int ligne,int colonne){
        return grille[ligne][colonne];
    }
    public void creeTuiles(){
        Tuile 
    }
    
    

    
    
}
