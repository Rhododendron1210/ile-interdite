/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Tuile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import util.Parameters;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.COULEE;
import static util.Utils.EtatTuile.INONDEE;


/**
 *
 * @author Yannis
 */
public class Grille {

    private Tuile[][] grille;
    private ArrayList<Tuile>tuiles;
    private int niveauEaux;

    

    public Grille() {
        grille = new Tuile[6][6];
        tuiles=new ArrayList<>();
    }

    public Tuile[][] getGrille() {
        return grille;
    }

    public Tuile getTuile(int ligne, int colonne) {
        return grille[ligne][colonne];
    }

    public void creeTuiles() {
        Tuile tuile;
        
        //cration des tuiles vide  ==>
        tuile = new Tuile(null, 0, 0, COULEE, this);
        addTuile(0, 0, tuile);
        tuile = new Tuile(null, 0, 1, COULEE, this);
        addTuile(0, 1, tuile);
        tuile = new Tuile(null, 1, 0, COULEE, this);
        addTuile(1, 0, tuile);
        tuile = new Tuile(null, 0, 5, COULEE, this);
        addTuile(0, 5, tuile);
        tuile = new Tuile(null, 0, 4, COULEE, this);
        addTuile(0, 4, tuile);
        tuile = new Tuile(null, 1, 5, COULEE, this);
        addTuile(1, 5, tuile);
        tuile = new Tuile(null, 4, 0, COULEE, this);
        addTuile(4, 0, tuile);
        tuile = new Tuile(null, 5, 0, COULEE, this);
        addTuile(5, 0, tuile);
        tuile = new Tuile(null, 5, 1, COULEE, this);
        addTuile(5, 1, tuile);
        tuile = new Tuile(null, 4, 5, COULEE, this);
        addTuile(4, 5, tuile);
        tuile = new Tuile(null, 5, 4, COULEE, this);
        addTuile(5, 4, tuile);
        tuile = new Tuile(null, 5, 5, COULEE, this);
        addTuile(5, 5, tuile);
        
        //crée des tuiles et mise dans ArrayList  tuiles ==>
        
        
        
        tuile = new Tuile("Le Pond des Abimes      ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Porte de Bronze      ",INONDEE , this);
        tuiles.add(tuile);
        tuile = new Tuile("La Caverne des Ombres   ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Porte de Fer         ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Porte d'or           ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Les Falaises de L'oubli ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Palais de Corail     ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Porte d'Argent       ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Les Dunes de L'Illusion ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Heliport                ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Porte de Cuivre      ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Jardin des Hurlements", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Foret Pourpre        ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Lagon Perdu          ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Marais Brumeux       ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Observatoire            ",ASSECHEE , this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Rocher Fantome       ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Caverne du Brasier   ",ASSECHEE , this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Temple du Soleil     ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Temple de la Lune    ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Palais des Marées    ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Val du Crepuscule    ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("La Tour de Guet         ", ASSECHEE, this);
        tuiles.add(tuile);
        tuile = new Tuile("Le Jardin des Murmures  ",ASSECHEE , this);
        tuiles.add(tuile);
        
        
        Collections.shuffle(tuiles);//<== mélange de tuiles
        
        
        //positionne les tuiles sur la grille==>
        int t=0;
        int i=0;
        int w=0;
        for (i = 0; i <= 5; i++){
            for (w = 0; w <= 5; w++) {
                if (grille[i][w]==null){
                    tuiles.get(t).setLigne(i);
                    tuiles.get(t).setColonne(w);
                    grille[i][w]=tuiles.get(t);
                    t=t+1;
                }
            }
        }

    }

    private void addTuile(int ligne, int colonne, Tuile tuile) {
        grille[ligne][colonne] = tuile;
    }

    public void afficheGrille() {
        int w;
        int i;
        for (w = 0; w <= 5; w++) {
            System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________");

            for (i = 0; i <= 5; i++) {
                if (grille[w][i].getNom() == null) {
                    System.out.print("|                              ");
                } else {
                    System.out.print("|   " + grille[w][i].getNom() + "   ");
                }

            }
            System.out.println(" ");
            for (i = 0; i <= 5; i++) {
                if (!(grille[w][i].getAventurierPresent().isEmpty())) {
                    for (String e : grille[w][i].getAventurierPresent().keySet()) {
                        System.out.print("|   " + grille[w][i].getAventurierPresent().get(e).getNom() + "  ");

                    }
                } else {
                    System.out.print("|                              ");
                }
            }
            System.out.println(" ");
            for (i = 0; i <= 5; i++) {
                System.out.print("|          "+grille[w][i].getEtatTuile()+"            ");
            }
            System.out.println(" ");

        }
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________");

        /*grille[i][w]; w<=5; w++;*/
    }

    public HashSet<Tuile> getTuilesAssechee() {//definit dans le diagramme de sequence de deplacementPossiblePilote
        HashSet<Tuile> liste = new HashSet<>();
        for (Tuile[] tuile : grille) {
            for (Tuile t : tuile) {
                if (t.tuileSeche()) {
                    liste.add(t);
                }
            }
        }
        return liste;
    }

    public HashSet<Tuile> getTuilesInondée() {//définit dans le diagramme de sequences assechementPossible
        HashSet<Tuile> liste = new HashSet<>();
        for (Tuile[] tuile : grille) {
            for (Tuile t : tuile) {
                if (t.isInondée()) {
                    liste.add(t);
                }
            }
        }
        return liste;
    }

    private boolean tuileExiste(int ligne, int colonne) {
        Boolean b = false;
        for (Tuile[] tuile : grille) {
            for (Tuile t : tuile) {
                if (t.getColonne() == colonne && t.getLigne() == ligne) {
                    b = true;
                }
            }
        }
        return b;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(int ligne, int colonne) {//définit dans le diagramme de sequences deplacementPlongeur
        ArrayList<Tuile> liste = new ArrayList<>();
        if (tuileExiste(ligne - 1, colonne)) {
            liste.add(getTuile(ligne - 1, colonne));
        }
        if (tuileExiste(ligne + 1, colonne)) {
            liste.add(getTuile(ligne + 1, colonne));
        }
        if (tuileExiste(ligne, colonne - 1)) {
            liste.add(getTuile(ligne, colonne - 1));
        }
        if (tuileExiste(ligne, colonne + 1)) {
            liste.add(getTuile(ligne, colonne + 1));
        }
        return liste;
    }
    
    public HashSet<Tuile> getTuilesAdjacentesDiagonale(int ligne, int colonne) {//définit dans le diagramme de sequences deplacementPlongeur
        HashSet<Tuile> liste = new HashSet<>();
        if (tuileExiste(ligne - 1, colonne-1)) {
            liste.add(getTuile(ligne - 1, colonne-1));
        }
        if (tuileExiste(ligne + 1, colonne+1)) {
            liste.add(getTuile(ligne + 1, colonne+1));
        }
        if (tuileExiste(ligne+1, colonne - 1)) {
            liste.add(getTuile(ligne+1, colonne - 1));
        }
        if (tuileExiste(ligne-1, colonne + 1)) {
            liste.add(getTuile(ligne-1, colonne + 1));
        }
        return liste;
    }

    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    public int getNiveauEaux() {
        return niveauEaux;
    }

    public void setNiveauEaux(int niveauEaux) {
        this.niveauEaux = niveauEaux;
    }
    

}