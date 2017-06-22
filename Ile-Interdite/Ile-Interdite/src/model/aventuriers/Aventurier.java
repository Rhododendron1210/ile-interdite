/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import Tresor.CarteTirage;

import java.awt.Color;

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
    private Color couleur;
    private ArrayList<Tresor> tresors;

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }
    
    Aventurier(String nom, String role,Tuile position){
        this.nom=nom;
        this.role=role;
        colTuilePossible = new HashSet<>();
        this.setPosition(position);
        possede= new ArrayList<>();
        tresors=new ArrayList<>();
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
            if (tuile.tuileSeche() || tuile.isInondée()){
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
    
    

    private boolean recuperationTresorPossible(Tresor tresor) {//a refaire
        int i=0;
        for (CarteTirage carte:possede){
            if (carte.getNom()=="CarteTresor"){
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

    public ArrayList<CarteTirage> getPossede() {
        return possede;
    }
    
    public void addCarte(CarteTirage carte){
        possede.add(carte);
    }

    public void addTresors(Tresor tresor) {
        tresors.add(tresor);
    }

    public ArrayList<Tresor> getTresors() {
        return tresors;
    }

    public void setTresors(ArrayList<Tresor> tresors) {
        this.tresors = tresors;
    }
    
    
    
}
