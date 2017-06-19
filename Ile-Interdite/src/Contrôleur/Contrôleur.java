package Contrôleur;

import Grille.Grille;
import Tuile.Tuile;
import static java.awt.Color.black;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
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
 * To change this template file, choose Tools |etery Templates
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
        grille=new Grille();
        VueAventurier vue;
        joueurs= new HashMap<>();
        initialisationPartie();
        grille.afficheGrille();
        tourDeJeu();
    }
    
    public void afficherJoueurs(){
        for(String e:joueurs.keySet()){
            System.out.println(joueurs.get(e).getRole()+"  "+joueurs.get(e).getTuile().getNom()+joueurs.get(e).getTuile().getEtatTuile());            
        }
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

    
    
    
    public void initialisationPartie(){
        
        grille.creeTuiles();
        Aventurier a;
        a = new Explorateur("explorateur              ","Explorateur",grille.getTuile(2, 4));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="La Porte de Cuivre      "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        
        
        a= new Messager(    "messager                 ","Messager",grille.getTuile(2, 1));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="La Porte d'Argent       "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        //grille.getTuile(2, 1).addAventurier(a);
         
        a=new Ingenieur(   "ingénieur                ","Ingénieur",grille.getTuile(0, 3));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="La Porte de Bronze      "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        //grille.getTuile(0, 3).addAventurier(a);
        
        a=new Pilote(     "pilote                   ","Pilote",grille.getTuile(2, 3));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="Heliport                "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        
        //grille.getTuile(2, 3).addAventurier(a);
        
        a=new Plongeur(   "plongeur                 ","Plongeur",grille.getTuile(1, 2));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="La Porte de Fer         "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        //grille.getTuile(1, 2).addAventurier(a);
        
        a=new Navigateur( "navigateur               ","Navigateur",grille.getTuile(1, 3));
        for (Tuile t :grille.getTuiles()){
            if (t.getNom()=="La Porte d'or           "){
                joueurs.put("Pilote", a);
                t.aventurierPresent.put(a.getNom(),a);
            } 
        }
        //grille.getTuile(1, 3).addAventurier(a);
        
    }
    
    public void tourDeJeu(){
        int i;
        for(String e:joueurs.keySet()){
            i=0;
            while (i<3){
                System.out.println("Action :"+String.valueOf(i+1)+" du "+joueurs.get(e).getNom());
                this.tour(joueurs.get(e));
                i=i+1;
            }
            
        }
    }
    
    @Override
    public void traiterMessage(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deplacement(Aventurier a){
        int ligne=0;
        int colonne=0;
        boolean end ;
        HashSet<Tuile> tuiles =new HashSet<>();
        tuiles=a.tuilesPossibles();
        if (tuiles.isEmpty()){
            System.out.println("ne peut pas se deplacer");
            tour(a);
        }
        else{
            System.out.println("Tuiles Possibles : ");
            for(Tuile tuile :tuiles){
                tuile.afficheTuile();
            }
            Scanner sc = new Scanner(System.in);
            end =true;
            System.out.println("Taper ligne=0 et colonne=0 pour annuler le coix d'action.");
            while(end ){
                
                System.out.println("Ligne");
                ligne = sc.nextInt();
                System.out.println("colonne");
                colonne= sc.nextInt();
                if(ligne==0&&colonne==0){
                    end=false;
                    tour(a);
                } else if (ligne<6&&ligne>=0&&colonne<6&&colonne>=0){
                    if (tuiles.contains(grille.getTuile(ligne,colonne))){
                      end=false;  
                    } else {
                        System.out.println("Case avec déplacement non possible");
                    }
                    
                } else {
                    System.out.println("Case en dehors du plateau");
                }
                
            }
            if(ligne!=0&&colonne!=0){
                a.getPosition().supprAventurier(a);
                Tuile tuile=grille.getTuile(ligne, colonne);
                tuile.addAventurier(a);
                a.setPosition(tuile);
                grille.afficheGrille();
            }
            
            
            //tour(a);
            
        }
    }
    
    /*public void faireAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir un joueur :");
        System.out.println("1.Ingénieur");
        System.out.println("2.Navigateur");
        System.out.println("3.Plongeur");
        System.out.println("4.Pilote");
        System.out.println("5.Explorateur");
        System.out.println("6.Messager");
        Aventurier av;
        int i = sc.nextInt();
        if (i==1){
            av=joueurs.get("Ingé");
        } else if(i==2){
            av=joueurs.get("Nav");
        }else if(i==3){
            av=joueurs.get("Plong");
        }else if(i==4){
            av=joueurs.get("Pilote");
        }else if(i==5){
            av=joueurs.get("Explo");
        }else{
            av=joueurs.get("Mess");
        }
        
        System.out.println("Choisir une action :");
        System.out.println("1. Déplacement");
        System.out.println("2. Assechement");
        System.out.println("3. Arret");
        i = sc.nextInt();
        if (i==1){
            deplacement(av);
        } else if(i==2){
            assecherTuile(av);
        } 
        
    }*/
    
    public void tour(Aventurier a){
        Scanner sc = new Scanner(System.in);
        int i;
        System.out.println("Choisir une action :");
        System.out.println("1. Déplacement");
        System.out.println("2. Assechement");
        System.out.println("3. Passer Action");
        i = sc.nextInt();
        if (i==1){
            deplacement(a);
        } else if(i==2){
            assecherTuile(a);
        } else if (i==4){
            afficherJoueurs();
            tour(a);
        }
        
        //grille.afficheGrille();
    }
    
    
    public void assecherTuile(Aventurier a){
        HashSet<Tuile> tuiles = a.assechementPossible();
        int ligne=0;
        int colonne=0;
        boolean end ;
        
        if (tuiles.isEmpty()){
            System.out.println("ne peut pas assecher");
            tour(a);
        }
        else{
            System.out.println("Tuiles Possibles : ");
            for(Tuile tuile :tuiles){
                tuile.afficheTuile();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Taper ligne=0 et colonne=0 pour annuler le coix d'action.");
            end =true;
            while(end ){
                System.out.println("Ligne");
                ligne = sc.nextInt();
                System.out.println("colonne");
                colonne= sc.nextInt();
                if(ligne==0&&colonne==0){
                    end=false;
                    tour(a);
                } else if (ligne<6&&ligne>=0&&colonne<6&&colonne>=0){
                    if (tuiles.contains(grille.getTuile(ligne,colonne))){
                      end=false;  
                    } else {
                        System.out.println("Case avec assechement non possible");
                    }
                    
                } else {
                    System.out.println("Case en dehors du plateau");
                }
            }
        }
        if(ligne!=0&&colonne!=0){
            Tuile tuile=grille.getTuile(ligne, colonne);
            tuile.setAssechee();
            grille.afficheGrille();
        }
        //tour(a);
    }
}

