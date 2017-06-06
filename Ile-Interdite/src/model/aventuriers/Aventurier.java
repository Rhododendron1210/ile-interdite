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
 * @author Yannis
 */
public abstract class Aventurier {
    
    private String nom;
    private String role;
    private ArrayList<Tuile> colTuilePossible;
    private Tuile position;
    
    Aventurier(String nom, String role,Tuile position){
        this.nom=nom;
        this.role=role;
        colTuilePossible = new ArrayList<>();
        this.setPosition(position);
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
    
    public void effectuerAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Tuile> tuilesPossibles(){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesAssechee();
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if (ligneT == ligne+1 && colonneT == colonne&&colonneT == colonne+1 && ligneT == ligne&&ligneT == ligne-1 && colonneT == colonne&&colonneT == colonne-1 && ligne == ligneT){
                if (tuile.tuileSeche()){
                   colTuilePossible.add(tuile);
                }
            }
        }
        return colTuilePossible;
    }

    public void setColTuilePossible(ArrayList<Tuile> colTuilePossible) {
        this.colTuilePossible = colTuilePossible;
    }
   
    public ArrayList<Tuile> assechementPossible(){
        colTuilePossible.clear();
        Tuile t = getPosition();
        int ligne = t.getLigne();
        int colonne = t.getColonne();
        Grille grille = t.getGrille();
        ArrayList<Tuile> tuiles = grille.getTuilesInondée();
        for (Tuile tuile: tuiles){
            int ligneT = tuile.getLigne();
            int colonneT = tuile.getColonne();
            if (ligneT == ligne+1 && colonneT == colonne&&colonneT == colonne+1 && ligneT == ligne&&ligneT == ligne-1 && colonneT == colonne&&colonneT == colonne-1 && ligne == ligneT){
                colTuilePossible.add(tuile);
            }
        }
        return colTuilePossible;
    }
}
