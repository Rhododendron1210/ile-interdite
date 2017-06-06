package Contrôleur;

import Grille.Grille;
import static java.awt.Color.black;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.text.html.HTMLDocument.Iterator;
import model.aventuriers.Aventurier;
import model.aventuriers.Explorateur;
import model.aventuriers.Ingenieur;
import model.aventuriers.Messager;
import model.aventuriers.Navigateur;
import model.aventuriers.Pilote;
import model.aventuriers.Plongeur;
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
    public Contrôleur(){
        VueAventurier vue;
        joueurs= new HashMap<>();
        initialisationPartie();
        /*for(String e:joueurs.keySet()){
            System.out.println(joueurs.get(e).getRole()+"  "+joueurs.get(e).getTuile().getNom()+joueurs.get(e).getTuile().getEtatTuile());            
        }   */
        grille.afficheGrille();
        
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

    
    
    public void tour(Aventurier a){
        
        int nbAction = 3;
        
        while (nbAction > 0) {
            
        }
    }
    
    public void effectuerAction(){
        //A faire
    }
    
    public void initialisationPartie(){
        grille=new Grille();
        grille.creeTuiles();
        joueurs.put("Explo", new Explorateur("explorateur","Explorateur",grille.getTuile(2, 4)));        
        joueurs.put("Mess", new Messager("messager","Messager",grille.getTuile(2, 1)));
        joueurs.put("Ingé", new Ingenieur("ingénieur","Ingénieur",grille.getTuile(0, 3)));
        joueurs.put("Pilote", new Pilote("pilote","Pilote",grille.getTuile(2, 3)));
        joueurs.put("Plong", new Plongeur("plongeur","Plongeur",grille.getTuile(1, 2)));
        joueurs.put("Nav", new Navigateur("navigateur","Navigateur",grille.getTuile(1, 3)));
        
    }
    
    public void tourDeJeu(){
        int i;
        for(String e:joueurs.keySet()){
            i=0;
            while (i<3){
                joueurs.get(e).effectuerAction();
                i=i+1;
            }
            
        }
    }
    
    @Override
    public void traiterMessage(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
