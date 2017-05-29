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
    
   
}
