/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import java.awt.Color;
import model.Grille;
import model.Tuile;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Léa
 */
public class Plongeur extends Aventurier{
    
    public Plongeur(String nom, String role,Tuile position) {
        super(nom, role,position);
        super.setCouleur(Color.black);
    }
    
    @Override
    public HashSet<Tuile> tuilesPossibles(Grille grille){
        ArrayList<Tuile> tuilesDejaVu = new ArrayList<>();
        HashSet<Tuile> liste = new HashSet<>();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        
        ArrayList<Tuile> tu = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile : tu){
            if (tuile.tuileSeche()){
                liste.add(tuile);
            } else if(tuilesDejaVu.contains(tuile)==false){
                tuilesDejaVu.add(tuile);
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne(),tuilesDejaVu,grille));
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
    //ATTENTION possible erreurs car ces deux méthodes sont récursives 
    //donc possibilité de boucle infinie
    public HashSet<Tuile> tuilesPossibles(int colonne,int ligne,ArrayList<Tuile> tuilesVu ,Grille grille){
        ArrayList<Tuile> tuilesDejaVu = tuilesVu;
        HashSet<Tuile> liste = new HashSet<>();
        Tuile t = getPosition();
        
        ArrayList<Tuile> tu = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile : tu){
            if (tuile.tuileSeche() && t!=tuile){
                liste.add(tuile);
            } else if(tuilesDejaVu.contains(tuile)==false ){
                tuilesDejaVu.add(tuile);
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne(),tuilesDejaVu,grille));
            }
        }
        return liste;
    }
}
