/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuile;

/**
 *
 * @author Yannis
 */
public class Tuile {
    
    private String nom;
    private boolean submergee = false;
    private boolean coulee = false;
    private int ligne;
    private int colonne;
    
    Tuile(String nom, int ligne, int colonne) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    Tuile(String nom, int ligne, int colonne, boolean submergee, boolean coulee) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        this.submergee = submergee;
        this.coulee = coulee;
    }
    
    public String getNomTuile() {
        return nom;
    }
    
    public int getLigne() {
        return ligne;
    }
            
    public int getColonne() {
        return colonne;
    }
    
    public boolean tuileSeche() {
        if (submergee || coulee) {
            return false;
        } else {
            return true;
        }
    }
    
    
}
