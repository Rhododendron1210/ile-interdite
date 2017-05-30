/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuile;

import model.aventuriers.Aventurier;
import java.util.*;
import Grille.Grille;

/**
 *
 * @author Yannis
 */
public class Tuile {

    private String nom;
    private boolean inondée = false;
    private boolean coulee = false;
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

    public Tuile(String nom, int ligne, int colonne, boolean inondée, boolean coulee, Grille g) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        this.inondée = inondée;
        this.coulee = coulee;
        this.grille = g;
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
        if (inondée || coulee) {
            return false;
        } else {
            return true;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isSubmergee() {
        return inondée;
    }

    public void setSubmergee(boolean submergee) {
        this.inondée = submergee;
    }

    public boolean isCoulee() {
        return coulee;
    }

    public void setCoulee(boolean coulee) {
        this.coulee = coulee;
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

}
