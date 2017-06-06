/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Tuile.Tuile;
import java.util.ArrayList;
import java.util.HashMap;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.COULEE;
import static util.Utils.EtatTuile.INONDEE;

/**
 *
 * @author Yannis
 */
public class Grille {
    
    
    private Tuile[][] grille;
    
    public Grille() {
        grille =new Tuile[6][6];
    }

    public Tuile[][] getGrille() {
        return grille;
    }
    
    public Tuile getTuile(int ligne,int colonne){
        return grille[ligne][colonne];
    }
    public void creeTuiles(){
        Tuile tuile;
        tuile= new Tuile(null,0,0,COULEE,this);
        addTuile(0,0,tuile); 
        tuile= new Tuile(null,0,1,COULEE,this);
        addTuile(0,1,tuile); 
        tuile= new Tuile(null,1,0,COULEE,this);
        addTuile(1,0,tuile);
        tuile= new Tuile(null,0,5,COULEE,this);
        addTuile(0,5,tuile);         
        tuile= new Tuile(null,0,4,COULEE,this);
        addTuile(0,4,tuile);
        tuile= new Tuile(null,1,5,COULEE,this);
        addTuile(1,5,tuile);
        tuile= new Tuile(null,4,0,COULEE,this);
        addTuile(4,0,tuile);
        tuile= new Tuile(null,5,0,COULEE,this);
        addTuile(5,0,tuile); 
        tuile= new Tuile(null,5,1,COULEE,this);
        addTuile(5,1,tuile);
        tuile= new Tuile(null,4,5,COULEE,this);
        addTuile(4,5,tuile);
        tuile= new Tuile(null,5,4,COULEE,this);
        addTuile(5,4,tuile);
        tuile= new Tuile(null,5,5,COULEE,this);
        addTuile(5,5,tuile); 
        tuile= new Tuile("Le Pond des Abimes",0,2,ASSECHEE,this);
        addTuile(0,2,tuile);
        tuile= new Tuile("La Porte de Bronze",0,3,INONDEE,this);
        addTuile(0,3,tuile);
        tuile= new Tuile("La Caverne des Ombres",1,1,ASSECHEE,this);
        addTuile(1,1,tuile);
        tuile= new Tuile("La Porte de Fer",1,2,ASSECHEE,this);
        addTuile(1,2,tuile);
        tuile= new Tuile("La Poste d'or",1,3,ASSECHEE,this);
        addTuile(1,3,tuile);
        tuile= new Tuile("Les Falaises de L'oubli",1,4,ASSECHEE,this);
        addTuile(1,4,tuile);
        tuile= new Tuile("Le Palais de Corail",2,0,ASSECHEE,this);
        addTuile(2,0,tuile);
        tuile= new Tuile("La Porte d'Argent",2,1,ASSECHEE,this);
        addTuile(2,1,tuile);
        tuile= new Tuile("Les Dunes de L'Illusion",2,2,COULEE,this);
        addTuile(2,2,tuile);
        tuile= new Tuile("Heliport",2,3,ASSECHEE,this);
        addTuile(2,3,tuile);
        tuile= new Tuile("La Porte de Cuivre",2,4,ASSECHEE,this);
        addTuile(2,4,tuile);
        tuile= new Tuile("Le Jardin des Hurlements",2,5,ASSECHEE,this);
        addTuile(2,5,tuile);
        tuile= new Tuile("La Foret Pourpre",3,0,ASSECHEE,this);
        addTuile(3,0,tuile);
        tuile= new Tuile("Le Lagon Perdu",3,1,INONDEE,this);
        addTuile(3,1,tuile);
        tuile= new Tuile("Le Marais Brumeux",3,2,COULEE,this);
        addTuile(3,2,tuile);
        tuile= new Tuile("Observatoire",3,3,INONDEE,this);
        addTuile(3,3,tuile);
        tuile= new Tuile("Le Rocher Fantome",3,4,COULEE,this);
        addTuile(3,4,tuile);
        tuile= new Tuile("La Caverne du Brasier",3,5,INONDEE,this);
        addTuile(3,5,tuile);
        tuile= new Tuile("Le Temple du Soleil",4,1,ASSECHEE,this);
        addTuile(4,1,tuile);
        tuile= new Tuile("Le Temple de la Lune",4,2,COULEE,this);
        addTuile(4,2,tuile);
        tuile= new Tuile("Le Palais des Marées",4,3,ASSECHEE,this);
        addTuile(4,3,tuile);
        tuile= new Tuile("Le Val du Crepuscule",4,4,ASSECHEE,this);
        addTuile(4,4,tuile);
        tuile= new Tuile("La Tour de Guet",5,2,ASSECHEE,this);
        addTuile(5,2,tuile);
        tuile= new Tuile("Le Jardin des Murmures",5,3,INONDEE,this);
        addTuile(5,3,tuile);
        
    }
    
    private void addTuile(int ligne,int colonne,Tuile tuile){
        grille[ligne][colonne]=tuile;
    }
    
    public void afficheGrille(){
        int w;
        int i;
        for(w=0; w<=5;w++){
            System.out.println("______________________________________________________________________________________________________________________________");

            for(i=0; i<=5; i++){
                System.out.print("|   "+grille[w][i].getNomTuile()+"   ");
                if(grille[w][i].getAventurierPresent().isEmpty()){
                    System.out.print("");
                }
            }         
            System.out.println("|");
        }
        System.out.println("______________________________________________________________________________________________________________________________");

       /*grille[i][w]; w<=5; w++;*/
    }   
    public ArrayList<Tuile> getTuilesAssechee(){
        ArrayList<Tuile> liste = new ArrayList<>();
        for(Tuile[] tuile : grille){
            for (Tuile t:tuile){
                if (t.tuileSeche()){
                    liste.add(t);
                }
            }
        }
        return liste;
    }
   
    public ArrayList<Tuile> getTuilesInnodée(){
        ArrayList<Tuile> liste = new ArrayList<>();
        for(Tuile[] tuile : grille){
            for (Tuile t:tuile){
                if (t.isSubmergee()){
                    liste.add(t);
                }
            }
        }
        return liste;
    }


    
    
}
