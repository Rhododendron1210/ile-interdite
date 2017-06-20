/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tresor;

import model.Tuile;

/**
 *
 * @author robinta
 */
public class CarteInondation {

    private Tuile tuile;

    public CarteInondation(Tuile tuile) {
        this.tuile = tuile;
    }
        
    public Tuile getTuile() {
        return tuile;
    }

    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }
       
    
}
