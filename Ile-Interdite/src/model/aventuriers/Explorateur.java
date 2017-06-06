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
public class Explorateur extends Aventurier{

    
    
    public Explorateur(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public ArrayList<Tuile> tuilesPossibles(){
        ArrayList<Tuile> liste = super.tuilesPossibles();
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesAssechee();
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if ((colonneT==colonne-1 || colonneT==colonne+1)&&(ligneT==ligne-1 || ligneT == ligne+1)){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
    
    @Override
    public ArrayList<Tuile> assechementPossible(){
        ArrayList<Tuile> liste = super.tuilesPossibles();
        Tuile t = super.getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesInondée();
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if ((colonneT==colonne-1 || colonneT==colonne+1)&&(ligneT==ligne-1 || ligneT == ligne+1)){
                liste.add(tuile);
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
}
