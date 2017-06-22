package model;

import Tresor.CarteHelicoptere;
import Tresor.CarteInondation;
import Tresor.CarteMonteeDesEaux;
import Tresor.CarteSacsDeSable;
import Tresor.CarteTirage;
import Tresor.CarteTresor;
import java.awt.BorderLayout;
import util.Observateur;
import static java.awt.Color.black;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.Iterator;
import model.aventuriers.Aventurier;
import model.aventuriers.Explorateur;
import model.aventuriers.Ingenieur;
import model.aventuriers.Messager;
import model.aventuriers.Navigateur;
import model.aventuriers.Pilote;
import model.aventuriers.Plongeur;
import util.Message;
import static util.Utils.Commandes.ASSECHER;
import static util.Utils.Commandes.BOUGER;
import static util.Utils.Commandes.DEFAUSSE;
import static util.Utils.Commandes.DONNER;
import static util.Utils.Commandes.RECUPERER_TRESOR;
import static util.Utils.Commandes.TERMINER;
import static util.Utils.Commandes.VALIDER_JOUEURS;
import util.Utils.EtatTuile;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.COULEE;
import static util.Utils.EtatTuile.INONDEE;
import util.Utils.Tresor;
import view.VueAventurier;
import view.VueAventurier2;
import view.VueDefausse;
import view.VueEchange;
import view.VueGenerale;
import view.VueInscription;
import view.VueMessage;
import view.VueNiveau;
import view.VuePlateau;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yannis
 */
public class Contrôleur implements Observateur {

    private ArrayList<Aventurier> joueurs;
    private Grille grille;
    private VueInscription vueInscription;
    private int nbJoueurs;
    private int difficulte;
    private Stack<CarteTirage> piocheTirage;
    private Stack<CarteTirage> defausseTirage;
    private Stack<CarteInondation> piocheInondation;
    private Stack<CarteInondation> defausseInondation;
    private boolean finJeu = false;
    private Aventurier aventurierCourant;
    private ArrayList<Tresor> tresorsTrouvees;
    private int actionEffectuer;
    private VueEchange vueEchange;
    private VueGenerale vueGenerale;

    public Contrôleur() {
        tresorsTrouvees = new ArrayList<>();
        grille = new Grille();
        joueurs = new ArrayList<>();
        piocheInondation=new Stack();
        defausseInondation=new Stack();
        defausseTirage = new Stack<>();
        piocheTirage = new Stack<>();
        vueInscription = new VueInscription();
        vueInscription.setObservateur(this);
        actionEffectuer = 0;

    }

    public void afficher() {
        //affichage de la fenetre principale
        vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
        vueGenerale.setObservateur(this);
    }



    public void initialisationPartie(int nbJoueur) {

        grille.creeTuiles();

        initialiserJoueur(nbJoueur);
        initialiserTresor();
        CarteTirage carte;

        int i;
        for (i = 0; i < 5; i++) {
            carte = new CarteTresor("La statue du Zéphyr", "pas description");
            piocheTirage.push(carte);
        }
        for (i = 0; i < 5; i++) {
            carte = new CarteTresor("La Pierre Sacrée", "pas description");
            piocheTirage.push(carte);
        }
        for (i = 0; i < 5; i++) {
            carte = new CarteTresor("Le Cristal Ardent", "pas description");
            piocheTirage.push(carte);
        }
        for (i = 0; i < 5; i++) {
            carte = new CarteTresor("Le Calice de l'Onde", "pas description");
            piocheTirage.push(carte);
        }
        for (i = 0; i < 2; i++) {
            carte = new CarteSacsDeSable();
            piocheTirage.push(carte);
        }
        for (i = 0; i < 3; i++) {
            carte = new CarteHelicoptere();
            piocheTirage.push(carte);
        }
        for (i = 0; i < 2; i++) {
            carte = new CarteMonteeDesEaux();
            piocheTirage.push(carte);
        }

        Collections.shuffle(piocheTirage);

        ArrayList<Tuile> tuiles;
        tuiles = grille.getTuiles();
        for (Tuile tuile : tuiles) {
            CarteInondation cI = new CarteInondation(tuile);
            this.piocheInondation.push(cI);
        }
        Collections.shuffle(piocheInondation);

    }

   
    @Override
    public void traiterMessage(Message msg) {
        if (msg.getCommande() == BOUGER) {
            if (msg.getIdTuile() == null) {
                HashSet<Tuile> tuiles = new HashSet<>();
                tuiles = aventurierCourant.tuilesPossibles(grille);

                vueGenerale.afficherTuilesPossibles(tuiles);
            } else {
                String placement = String.valueOf(msg.getIdTuile());
                int ligne;
                int colonne;
                if (placement.length() == 1) {
                    ligne = 0;
                    colonne = Integer.valueOf(String.valueOf(placement.charAt(0)));
                } else {
                    ligne = Integer.valueOf(String.valueOf(placement.charAt(0)));
                    colonne = Integer.valueOf(String.valueOf(placement.charAt(1)));
                }
                Tuile tuile = grille.getTuile(ligne, colonne);

                deplacement(aventurierCourant, tuile);

                if (tuile.getNom() == "Heliport                ") {
                    this.gagner();
                }
            }
        } else if (msg.getCommande() == VALIDER_JOUEURS) {
            vueInscription.getWindow().dispose();
            nbJoueurs = msg.getNbJoueurs();
            difficulte = msg.getDifficulte();
            initialisationPartie(nbJoueurs);
            afficher();

        } else if (msg.getCommande() == ASSECHER) {
            if (msg.getIdTuile() == null) {
                HashSet<Tuile> tuiles = new HashSet<>();
                tuiles = aventurierCourant.assechementPossible(grille);
                if (tuiles.isEmpty()) {
                    vueGenerale.setMessage("Assechement impossible, choisir une autre action!");
                    vueGenerale.deselectionner();
                } else {
                    vueGenerale.afficherTuilesPossibles(tuiles);
                }

            } else {
                String placement = String.valueOf(msg.getIdTuile());
                int ligne;
                int colonne;
                if (placement.length() == 1) {
                    ligne = 0;
                    colonne = Integer.valueOf(String.valueOf(placement.charAt(0)));
                } else {
                    ligne = Integer.valueOf(String.valueOf(placement.charAt(0)));
                    colonne = Integer.valueOf(String.valueOf(placement.charAt(1)));
                }
                Tuile tuile = grille.getTuile(ligne, colonne);
                assechement(tuile);
                vueGenerale.dispose();
                vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
                vueGenerale.setObservateur(this);

            }
        } else if (msg.getCommande() == TERMINER) {
            this.actionEffectuer = 2;
            this.changerJoueur();
            vueGenerale.dispose();
            vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
            vueGenerale.setObservateur(this);
        } else if (msg.getCommande() == RECUPERER_TRESOR) {
            prendreTresor();
        } else if (msg.getCommande() == DEFAUSSE) {
            carteADefausser();
            vueGenerale.dispose();
            vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
            vueGenerale.setObservateur(this);
        } else if (msg.getCommande() == DONNER) {
            if (msg.getIdAventurier() == null && msg.getIdCarte() == null) {
                vueEchange = new VueEchange(aventurierCourant.getPossede(), aventurierCourant.getPosition().getAventurierPresent(), aventurierCourant);
                vueEchange.setObservateur(this);
            } else {
                CarteTirage carte = new CarteMonteeDesEaux();
                vueEchange.dispose();

                for (CarteTirage c : aventurierCourant.getPossede()) {
                    if (c.getNom() == msg.getIdCarte()) {
                        carte = c;
                    }
                }
                Aventurier av = new Pilote(null, null, null);
                for (Aventurier a : joueurs) {
                    if (a.getNom() == msg.getIdAventurier()) {
                        av = a;
                    }
                }
                donnerCarteTirage(aventurierCourant, av, carte);
                vueGenerale.dispose();
                vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
                vueGenerale.setObservateur(this);
            }

        }else if (msg.getCommande() == DEFAUSSE){
            System.out.println("sfsdqfsdfq");
            boolean b=false;
            int i=0;
            while(b==false){
                System.out.println("sfsdqfsdfq");
                
                if(aventurierCourant.getPossede().get(i).getNom() == msg.getNomCarte()){
                    addDefausseTirage(aventurierCourant.getPossede().get(i));
                    aventurierCourant.getPossede().remove(aventurierCourant.getPossede().get(i));
                }
                i=i+1;
            }
        }
    }

    public void deplacement(Aventurier a, Tuile tuile) {
        a.getPosition().supprAventurier(a);
        tuile.addAventurier(a);
        a.setPosition(tuile);
        changerJoueur();
    }

    public void assechement(Tuile tuile) {
        tuile.setAssechee();
        changerJoueur();
    }
    private void monteeEaux(CarteTirage carte) {

        difficulte = difficulte + 1;
        this.addDefausseTirage(carte);
        if (difficulte==5){
            vueGenerale.setMessage("VOUS AVEZ PERDU");                             //PERDU
            System.out.println("Perdu Difficulté");
        }else{
            Collections.shuffle(defausseInondation);
            while (!(defausseInondation.empty())) {
                this.addPiocheInondation(defausseInondation.pop());
            }
        }
        vueGenerale.setNiveau(difficulte);

    }

    public void tirerCarteInondation() {
        Stack defausse = this.defausseInondation;
        if (this.piocheInondation.isEmpty()) {
            Collections.shuffle(defausse);                                      //On mélange la defausse
            while (!(defausse.isEmpty())) {
                this.piocheInondation.push(defausseInondation.pop()); //On deplace la defausse dans la pioche
            }
        }
        CarteInondation cI = this.piocheInondation.pop();
        Tuile t = cI.getTuile();
        this.defausseInondation.push(cI);
        EtatTuile etat = t.getEtatTuile();
        if (etat == ASSECHEE) {
            t.setInondée();
        } else if (etat == INONDEE) {
            int ligne = t.getLigne();
            int colonne = t.getColonne();
            Grille g = grille;
            ArrayList tuilesAdjacentes = g.getTuilesAdjacentes(ligne, colonne);
            if(!(t.getAventurierPresent().isEmpty())){            
                if(tuilesAdjacentes.isEmpty()){
                    vueGenerale.setMessage("VOUS AVEZ PERDU \nDES JOUEURS\nONT COULE ");   //PERDU
                    System.out.println("Perdu Joueurs Coulés");
                }
                else{
                        Aventurier a = null;
                        for(String key : t.getAventurierPresent().keySet()){
                            a = t.getAventurierPresent().get(key);
                            //vueGenerale.afficherTuilesPossibles((HashSet) tuilesAdjacentes);                
                        }
                        //demander au joueur de se deplacer sur une case adjacente              
                }
            }
            t.setCoulee();
            Tresor tresor = t.getTresor();            
            if(tresor!=null){
                for(Tuile tuile : grille.getTuiles()){
                    if(tuile.getTresor() == tresor && tuile != t){
                        if(tuile.getEtatTuile()==COULEE){
                            vueGenerale.setMessage("VOUS AVEZ PERDU\nVOUS NE POUVEZ PAS\nRECUPERER TOUS LES TRESORS");             //PERDU    
                            System.out.println("Perdu Temples Coulés");
                        }
                        else{
                            //vueMessage.setLabel("Il reste une tuile pour le trésor '"+tresor.toString()+"'");
                        }
                    }
                }
            }
            if(t.getNom()=="Heliport                "){
                vueGenerale.setMessage("VOUS AVEZ PERDU\nVOUS NE POURREZ\nJAMAIS QUITTER\nL'ÎLE");             //PERDU  
                System.out.println("Perdu Heliport");
            }
        }
        else{
            System.out.println("La tuile est déjà coulée");
        }

    }

    private void addDefausseTirage(CarteTirage carte) {
        defausseTirage.push(carte);
    }

    private void addPiocheInondation(CarteInondation carte) {
        piocheInondation.push(carte);
    }

    private void piocherCarteTirage(Aventurier a) {
        //pioche une carte et la retourne
        //mélange et remet les carte dans la pioche si la pioche est vide
        CarteTirage carte = piocheTirage.pop();
        if (piocheTirage.empty()) {
            while (!defausseTirage.empty()) {
                piocheTirage.push(defausseTirage.pop());
            }
            Collections.shuffle(piocheTirage);
        }
        if (carte.getNom() == "CarteMonteeDesEaux") {
            monteeEaux(carte);
        } else {
            a.addCarte(carte);
        }

    }

    public void recuperationTresorTuile(Aventurier a, Tresor tresor) {
        a.addTresors(tresor);
        this.addTresorsTrouvees(tresor);

    }
    //
    private void addTresorsTrouvees(Tresor tresor) {
        tresorsTrouvees.add(tresor);
    }
    //compte les coups du joueur et passe au joueur suivant si coups=3
    private void changerJoueur() {
        actionEffectuer = actionEffectuer + 1;
        
        if (actionEffectuer == 3) {
            int i;
            for (i = 0; i < difficulte; i++) {
                tirerCarteInondation();
            }
            piocherCarteTirage(aventurierCourant);
            piocherCarteTirage(aventurierCourant);

            if (joueurs.indexOf(aventurierCourant) + 1 != joueurs.size()) {
                aventurierCourant = joueurs.get(joueurs.indexOf(aventurierCourant) + 1);
                actionEffectuer = 0;
                vueGenerale.setMessage("Au tour du " + aventurierCourant.getNom());

            } else {
                aventurierCourant = joueurs.get(0);
                actionEffectuer = 0;
            }
            
            carteADefausser();
        }
        vueGenerale.dispose();
        vueGenerale = new VueGenerale(difficulte, grille.getGrille(), joueurs,aventurierCourant);
        vueGenerale.setObservateur(this);
        vueGenerale.setMessage("nb de coups restants :\n" + (3 - actionEffectuer) + "/3");

    }
    //place les joueurs sur leur tuile de départ en foncton du nb de joueurs
    public void initialiserJoueur(int nbJoueur) {
        Aventurier a;

        ArrayList<Aventurier> aventuriers = new ArrayList();
        a = new Explorateur("Explorateur              ", "Explorateur", null);
        aventuriers.add(a);
        a = new Messager("Messager                 ", "Messager", null);
        aventuriers.add(a);
        a = new Ingenieur("Ingénieur                ", "Ingénieur", null);
        aventuriers.add(a);
        a = new Pilote("Pilote                   ", "Pilote", null);
        aventuriers.add(a);
        a = new Plongeur("Plongeur                 ", "Plongeur", null);
        aventuriers.add(a);
        a = new Navigateur("Navigateur               ", "Navigateur", null);

        Collections.shuffle(aventuriers);

        for (int i = 0; i < nbJoueur; i++) {
            a = aventuriers.get(i);
            String nm = a.getRole();

            if (nm == "Explorateur") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "La Porte de Cuivre      ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                        aventurierCourant = a;
                    }
                }
            } else if (nm == "Messager") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "La Porte d'Argent       ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                    }
                }
            } 
            else if (nm == "Ingénieur") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "La Porte de Bronze      ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                    }
                }
            } 
            else if (nm == "Pilote") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "Heliport                ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                    }
                }
            } 
            else if (nm == "Plongeur") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "La Porte de Fer         ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                    }
                }
            } 
            else if (nm == "Navigateur") {
                for (Tuile t : grille.getTuiles()) {
                    if (t.getNom() == "La Porte d'or           ") {
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(), a);
                    }
                }
            } else {
                System.out.println("InitialisationPartie : Rôle non trouvé");
            }

            if (i == 0) {
                aventurierCourant = a;
            }
        }
    }
    //place les trésors sur les bonnes tuiles
    public void initialiserTresor() {
        ArrayList<Tuile> tuiles = grille.getTuiles();
        for (Tuile tuile : tuiles) {
            String nomT = tuile.getNom();
            if (nomT == "La Caverne des Ombres   " || nomT == "La Caverne du Brasier   ") {
                tuile.setTresor(Tresor.CRISTAL);
            } else if (nomT == "Le Jardin des Hurlements" || nomT == "Le Jardin des Murmures  ") {
                tuile.setTresor(Tresor.ZEPHYR);
            } else if (nomT == "Le Temple de la Lune    " || nomT == "Le Temple du Soleil     ") {
                tuile.setTresor(Tresor.PIERRE);
            } else if (nomT == "Le Palais des Marées    " || nomT == "Le Palais de Corail     ") {
                tuile.setTresor(Tresor.CALICE);
            } else {
                tuile.setTresor(null);
            }
        }

    }
    //verifie toutes les conditions pour pouvoir recuperer un trésor
    private void prendreTresor() {
        Tuile tuile = aventurierCourant.getPosition();
        if (!(tuile.getTresor() == null)) {
            int cmpt = 0;
            Tresor tresor = tuile.getTresor();
            for (CarteTirage carte : aventurierCourant.getPossede()) {
                if (carte.getNom() == tresor.toString()) {
                    cmpt += 1;
                }
            }
            if (cmpt >= 4) {
                aventurierCourant.addTresors(tresor);
                for (Tuile t : grille.getTuiles()) {
                    if (t.getTresor().toString() == tresor.toString()) {
                        t.setTresor(null);
                    }
                }
            } else {
                vueGenerale.setMessage("Pas assez de cartes pour récuperer le trésor!");
            }
        } else {
            vueGenerale.setMessage("Pas une carte tresor!");
        }
    }
    //quand l'aventurier a + de 9 cartes une fenetre s'affiche pour vider les crtes en trop
    private void carteADefausser() {
        if (aventurierCourant.getPossede().size() > 8) {
            VueDefausse vueDefausse = new VueDefausse(aventurierCourant.getPossede().size() - 8, aventurierCourant.getPossede());
            vueDefausse.setObservateur(this);
        }
    }
    //Donne une carte a un aventurier
    private void donnerCarteTirage(Aventurier a, Aventurier a2, CarteTirage carte) {
        boolean b = false;
        int i = 0;
        while (b == false) {
            if (a.getPossede().get(i) == carte) {
                a.getPossede().remove(i);
                b = true;
            }
            i = i + 1;
        }
        a2.addCarte(carte);

    }
    //Methode qui permet de voir si une partie est gagnée
    private void gagner() {
        ArrayList<Tresor> tresors = new ArrayList();
        boolean b = false;
        for (Aventurier a : this.aventurierCourant.getTuile().getAventurierPresent().values()) {
            for (Tresor t : a.getTresors()) {
                tresors.add(t);
            }
            for (CarteTirage c : a.getPossede()) {
                if (c.getNom() == "CarteHelicoptere") {
                    b = true;
                }
            }
        }
        
        if(tresors.size() == 4){
            if(this.aventurierCourant.getTuile().getAventurierPresent().size() == nbJoueurs){
                if(b){
                    vueGenerale.setMessage("VOUS AVEZ GAGNE");
                    System.out.println("Gagné");
                }
            }
        }
    }
    //retourne les trésors deja trouvée par les aventuriers
    public ArrayList<Tresor> getTresorsObtenus(){
        ArrayList<Tresor> tresorsObtenus = new ArrayList();
        for(Aventurier a : joueurs){
            for(Tresor tresor : a.getTresors()){
                tresorsObtenus.add(tresor);
            }
        }
        return tresorsObtenus;
    }
}
