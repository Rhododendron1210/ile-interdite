/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuile;

import model.aventuriers.Aventurier;
import java.util.*;
import Grille.Grille;
import util.Utils.EtatTuile;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.COULEE;
import static util.Utils.EtatTuile.INONDEE;

/**
 *
 * @author Yannis
 */
public class Tuile {

    private String nom;
    private EtatTuile etatTuile;
    private int ligne;
    private int colonne;

    private Grille grille;

    private HashMap<String, Aventurier> aventurierPresent;

    public Tuile(String nom, int ligne, int colonne, Grille g) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        this.grille = g;
    }

    public Tuile(String nom, int ligne, int colonne, EtatTuile etatTuile, Grille g) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        this.etatTuile= etatTuile;
        this.grille = g;
    }

    public Tuile(String le_Palais_des_Marées, int i, int i0, boolean b, boolean b0, Grille aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomTuile() {
        return nom;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public boolean tuileSeche() {
        return etatTuile==ASSECHEE;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isSubmergee() {
        return etatTuile==INONDEE;
    }

    public void setSubmergee(boolean submergee) {
        this.etatTuile = INONDEE;
    }

    public boolean isCoulee() {
        return etatTuile==COULEE;
    }

    public void setCoulee(boolean coulee) {
        this.etatTuile = COULEE;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public HashMap<String, Aventurier> getAventurierPresent() {
        return aventurierPresent;
    }

    public void setAventurierPresent(HashMap<String, Aventurier> aventurierPresent) {
        this.aventurierPresent = aventurierPresent;
    }

    public EtatTuile getEtatTuile() {
        return etatTuile;
    }
    

}
