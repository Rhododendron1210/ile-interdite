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
public class Plongeur extends Aventurier{
    
    public Plongeur(String nom, String role,Tuile position) {
        super(nom, role,position);
    }
    
    @Override
    public ArrayList<Tuile> tuilesPossibles(){
        ArrayList<Tuile> tuilesDejaVu = new ArrayList<>();
        ArrayList<Tuile> liste = new ArrayList<>();
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
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne()));
            }
        }
        return liste;
    }
    //ATTENTION possible erreurs car ces deux méthodes sont récursives 
    //donc possibilité de boucle infinie
    public ArrayList<Tuile> tuilesPossibles(int colonne,int ligne){
        ArrayList<Tuile> tuilesDejaVu = new ArrayList<>();
        ArrayList<Tuile> liste = new ArrayList<>();
        Tuile t = getPosition();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tu = grille.getTuilesAdjacentes(ligne, colonne);
        for (Tuile tuile : tu){
            if (tuile.tuileSeche()){
                liste.add(tuile);
            } else if(tuilesDejaVu.contains(tuile)==false){
                tuilesDejaVu.add(tuile);
                liste.addAll(tuilesPossibles(tuile.getColonne(),tuile.getLigne()));
            }
        }
        return liste;
    }
}
