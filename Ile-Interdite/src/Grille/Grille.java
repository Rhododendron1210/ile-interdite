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
    
    private HashMap<int[][], Tuile> collecTuile = new HashMap();    
    
    Grille(HashMap<int [][], Tuile> collecTuile) {
        this.collecTuile = collecTuile;
    }

    public HashMap<int[][], Tuile> getCollecTuile() {
        return collecTuile;
    }

    public void setCollecTuile(HashMap<int[][], Tuile> collecTuile) {
        this.collecTuile = collecTuile;
    }
    
    
}
