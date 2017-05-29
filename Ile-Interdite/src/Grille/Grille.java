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
    
    Grille(HashMap<int [][], Tuile> collecTuile) {
        
        grille =new Tuile[6][6];
    }

    public Tuile[][] getGrille() {
        return grille;
    }
    
    

    
    
    
}
