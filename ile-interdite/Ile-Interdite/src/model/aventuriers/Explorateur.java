/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;
import java.awt.Color;
import model.Tuile;

import java.util.ArrayList;
import java.util.HashSet;
import model.Grille;

/**
 *
 * @author Léa
 */
public class Explorateur extends Aventurier{

    
    
    public Explorateur(String nom, String role,Tuile position) {
        super(nom, role,position);
        //super.setCouleur(Color.);
    }
    
    @Override
    public HashSet<Tuile> tuilesPossibles(Grille grille){
        HashSet<Tuile> liste = super.tuilesPossibles(grille);
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        
        HashSet<Tuile> tuiles = grille.getTuilesAdjacentesDiagonale(ligne, colonne);
        for (Tuile tuile: tuiles){
            if (tuile.tuileSeche()){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
    
    @Override
    public HashSet<Tuile> assechementPossible(Grille grille){
        HashSet<Tuile> liste = super.assechementPossible(grille);
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
       
        HashSet<Tuile> tuiles = grille.getTuilesAdjacentesDiagonale(ligne, colonne);
        for (Tuile tuile: tuiles){
            if (tuile.isInondée()){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
}
