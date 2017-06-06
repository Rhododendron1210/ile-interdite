/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import Grille.Grille;
import Tuile.Tuile;
import java.util.ArrayList;

/**
 *
 * @author Léa
 */
public class Pilote extends Aventurier{
    
    public Pilote(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public ArrayList<Tuile> tuilesPossibles(){
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> liste = new ArrayList<>();
        liste= grille.getTuilesAssechee();
        return liste;
    }
}
