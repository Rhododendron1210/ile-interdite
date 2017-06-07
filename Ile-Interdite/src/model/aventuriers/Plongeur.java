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
public class Plongeur extends Aventurier{
    
    public Plongeur(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public HashSet<Tuile> tuilesPossibles(){
        ArrayList<Tuile> tuilesDejaVu = new ArrayList<>();
        HashSet<Tuile> liste = new HashSet<>();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tu = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile : tu){
            if (tuile.tuileSeche()){
                liste.add(tuile);
            } else if(tuilesDejaVu.contains(tuile)==false){
                tuilesDejaVu.add(tuile);
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne(),tuilesDejaVu));
            }
        }
        super.setColTuilePossible(liste);
        return liste;
    }
    //ATTENTION possible erreurs car ces deux méthodes sont récursives 
    //donc possibilité de boucle infinie
    public HashSet<Tuile> tuilesPossibles(int colonne,int ligne,ArrayList<Tuile> tuilesVu){
        ArrayList<Tuile> tuilesDejaVu = tuilesVu;
        HashSet<Tuile> liste = new HashSet<>();
        Tuile t = getPosition();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tu = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile : tu){
            if (tuile.tuileSeche()){
                liste.add(tuile);
            } else if(tuilesDejaVu.contains(tuile)==false){
                tuilesDejaVu.add(tuile);
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne(),tuilesDejaVu));
            }
        }
        return liste;
    }
}
