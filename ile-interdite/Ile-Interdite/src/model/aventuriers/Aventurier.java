/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import Tresor.CarteTirage;
import Tresor.CarteTresor;

import java.util.ArrayList;
import java.util.HashSet;
import model.Grille;
import model.Tuile;
import model.ObjetIdentifie;
import util.Utils.Tresor;
/**
 *
 * @author Yannis
 */
public abstract class Aventurier extends ObjetIdentifie{
    
    private String nom;
    private String role;
    private HashSet<Tuile> colTuilePossible;
    private Tuile position;
    private ArrayList<CarteTirage> possede;
    
    Aventurier(String nom, String role,Tuile position){
        this.nom=nom;
        this.role=role;
        colTuilePossible = new HashSet<>();
        this.setPosition(position);
        possede= new ArrayList<>();
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
    
    
    
    public HashSet<Tuile> tuilesPossibles(Grille grille){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        
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
   
    public HashSet<Tuile> assechementPossible(Grille grille){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        
        ArrayList<Tuile> tuiles = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile: tuiles){
            if (tuile.isInondée()){
                colTuilePossible.add(tuile);
            }
        }
        return colTuilePossible;
    }
    
    public void recuperationTresorTuile(Tresor tresor){
        boolean t;
        t=recuperationTresorPossible(tresor);
        Tuile tuile;
        tuile= getPosition();
        Tresor tuileTresor=tuile.getTresor();
        if(t && tuileTresor==tresor){
            this.addTresor(tresor);
        }
        
        
    }

    private boolean recuperationTresorPossible(Tresor tresor) {
        int i=0;
        for (CarteTirage carte:possede){
            if (carte.getNom()==tresor){
                i=i+1;
            }
        }
        if(i>=4){
            return true;
        }
        else{
            return false;
        }
    }

    private void addTresor(Tresor tresor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
