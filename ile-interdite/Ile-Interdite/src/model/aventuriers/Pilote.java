/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import model.Grille;
import model.Tuile;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Léa
 */
public class Pilote extends Aventurier{
    
    public Pilote(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public HashSet<Tuile> tuilesPossibles(Grille grille){
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        
        HashSet<Tuile> liste = new HashSet<>();
        liste= grille.getTuilesAssechee();
        super.setColTuilePossible(liste);
        return liste;
    }
}
