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

/**
 *
 * @author Léa
 */
public class Explorateur extends Aventurier{

    
    
    public Explorateur(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public HashSet<Tuile> tuilesPossibles(){
        HashSet<Tuile> liste = super.tuilesPossibles();
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        HashSet<Tuile> tuiles = grille.getTuilesAdjacentesDiagonale(ligne, colonne);
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if (tuile.tuileSeche()){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
    
    @Override
    public HashSet<Tuile> assechementPossible(){
        HashSet<Tuile> liste = super.assechementPossible();
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        HashSet<Tuile> tuiles = grille.getTuilesAdjacentesDiagonale(ligne, colonne);
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if (tuile.isInondée()){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
}
