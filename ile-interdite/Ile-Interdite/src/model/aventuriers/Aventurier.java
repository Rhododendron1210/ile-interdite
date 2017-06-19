/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;
import Grille.Grille;
import Tuile.Tuile;
import java.util.ArrayList;
import java.util.HashSet;
import util.ObjetIdentifie;
/**
 *
 * @author Yannis
 */
public abstract class Aventurier extends ObjetIdentifie{
    
    private String nom;
    private String role;
    private HashSet<Tuile> colTuilePossible;
    private Tuile position;
    
    Aventurier(String nom, String role,Tuile position){
        this.nom=nom;
        this.role=role;
        colTuilePossible = new HashSet<>();
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
    
    public Tuile getPosition(){
        return position;
    }
    
    
    
    public HashSet<Tuile> tuilesPossibles(){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if (tuile.tuileSeche()){
                   colTuilePossible.add(tuile);
            }
        }
        return colTuilePossible;
    }

    public void setColTuilePossible(HashSet<Tuile> colTuilePossible) {
        this.colTuilePossible = colTuilePossible;
    }
   
    public HashSet<Tuile> assechementPossible(){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile: tuiles){
            if (tuile.isInondée()){
                colTuilePossible.add(tuile);
            }
        }
        return colTuilePossible;
    }
}
