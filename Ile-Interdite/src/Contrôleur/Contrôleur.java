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
public class Contrôleur implements Observateur{
    
    private HashMap<String,Aventurier> joueurs;
    private Grille grille;
    private VueAventurier vueAventurier;
    Contrôleur(){     
        initialisationPartie();
        
        vueAventurier.setObservateur(this);
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
    
    public void initialisationPartie(){
        grille=new Grille();
        grille.creeTuiles();
        //initialiser joueur
    }
    
    @Override
    public void traiterMessage(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
