/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.aventuriers.Aventurier;
import java.util.*;

import util.Utils.EtatTuile;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.COULEE;
import static util.Utils.EtatTuile.INONDEE;
import util.Utils.Tresor;

/**
 *
 * @author Yannis
 */
public class Tuile {

    private String nom;
    private EtatTuile etatTuile;
    private int ligne;
    private int colonne;
    private boolean selectionner;

    private Tresor tresor;
    

    public HashMap<String, Aventurier> aventurierPresent;

    public Tuile(String nom, int ligne, int colonne, Grille g,Tresor tresor) {
        selectionner=false;
        aventurierPresent=new HashMap<>();
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        
        this.tresor=tresor;
    }

    public Tuile(String nom, int ligne, int colonne, EtatTuile etatTuile, Grille g) {
        selectionner=false;
        aventurierPresent=new HashMap<>();
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
        this.etatTuile= etatTuile;
        
    }
    public Tuile(String nom, EtatTuile etatTuile, Grille g) {
        selectionner=false;
        aventurierPresent=new HashMap<>();
        this.nom = nom;
        this.etatTuile= etatTuile;
        
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public Tuile(String le_Palais_des_Marées, int i, int i0, boolean b, boolean b0, Grille aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void setAssechee(){
        this.etatTuile = ASSECHEE;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isInondée() {
        return etatTuile==INONDEE;
    }

    public boolean isSelectionner() {
        return selectionner;
    }

    public void setSelectionner(boolean selectionner) {
        this.selectionner = selectionner;
    }

    public void setInondée() {
        this.etatTuile = INONDEE;
    }

    public boolean isCoulee() {
        return etatTuile==COULEE;
    }

    public void setCoulee() {
        this.etatTuile = COULEE;
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

    public void afficheTuile() {
        System.out.println(nom+" - ligne :"+ligne+", colonne:"+colonne);
    }

    public void supprAventurier(Aventurier a) {
        aventurierPresent.remove(a.getNom());
    }

    public void addAventurier(Aventurier a) {
        aventurierPresent.put(a.getNom(),a);
    }

    public Tresor getTresor() {
        return tresor;
    }
    
    

}
