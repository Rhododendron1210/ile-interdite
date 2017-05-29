package Contrôleur;

import Grille.Grille;
import java.util.HashMap;
import model.aventuriers.Aventurier;
import view.VueAventurier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yannis
 */
public class Contrôleur {
    
    private HashMap<String,Aventurier> joueurs;
    private Grille grille;
    private VueAventurier vueAventurier;
    Contrôleur(Grille grille,VueAventurier vueAventurier){
        joueurs=new HashMap<>();
        this.grille=grille;
        this.vueAventurier=vueAventurier;        
    }

    public HashMap<String, Aventurier> getJoueurs() {
        return joueurs;
    }

    public Grille getGrille() {
        return grille;
    }

    public VueAventurier getVueAventurier() {
        return vueAventurier;
    }

    public void setJoueurs(HashMap<String, Aventurier> joueurs) {
        this.joueurs = joueurs;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setVueAventurier(VueAventurier vueAventurier) {
        this.vueAventurier = vueAventurier;
    }
    
    public void tour(Aventurier a){
        
        int nbAction = 3;
        
        while (nbAction > 0) {
            
        }
    }
    
    public void effectuerAction(){
    }
    
   
}
