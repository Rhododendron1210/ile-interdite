/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;
import Tuile.Tuile;
import java.util.ArrayList;
/**
 *
 * @author Yannis
 */
public abstract class Aventurier {
    
    private String nom;
    private String role;
    private ArrayList<Tuile> colTuilePossible;
    private Tuile position;
    
    Aventurier(String nom, String role,Tuile position){
        this.nom=nom;
        this.role=role;
        colTuilePossible = new ArrayList<>();
        this.setPosition(position);
    }
    
    public String getRole() {
        return this.role;
    }
    
    public String getNom() {
        return this.nom;
    }

    public Tuile getTuile() {
        return position;
    }

    public void setPosition(Tuile tuile) {
        this.position = tuile;
    }

    public void effectuerAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
