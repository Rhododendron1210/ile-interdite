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
import static util.Utils.Commandes.TERMINER;
import static util.Utils.Commandes.VALIDER_JOUEURS;
import util.Utils.EtatTuile;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.INONDEE;
import util.Utils.Tresor;
import view.VueAventurier;
import view.VueAventurier2;
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
public class Contrôleur implements Observateur{
    
    private ArrayList<Aventurier> joueurs;
    private Grille grille;
    private VueAventurier2 vueAventurier2;
    private VuePlateau vuePlateau;
    private VueInscription vueInscription;
    private int nbJoueurs;
    private int difficulte;
    private ArrayList<VueAventurier2> aventuriers;
    private Stack<CarteTirage> piocheTirage;
    private Stack<CarteTirage> defausseTirage;
    private Stack<CarteInondation> piocheInondation;
    private Stack<CarteInondation> defausseInondation;
    private VueNiveau vueNiveau;
    private boolean finJeu = false;
    private Aventurier aventurierCourant;
    private ArrayList<Tresor> tresorsTrouvees;
    private VueMessage vueMessage;
    private int actionEffectuer;
    
    
    public Contrôleur(){
        tresorsTrouvees=new ArrayList<>();
        grille=new Grille();
        joueurs= new ArrayList<>();
        this.setPiocheInondation(new Stack());
        this.setDefausseInondation(new Stack());
        defausseTirage=new Stack<>();
        piocheTirage=new Stack<>();
        vueInscription = new VueInscription();
        vueInscription.setObservateur(this);
        actionEffectuer=0;
        aventuriers= new ArrayList();
        
    }
    
    /*public void afficherJoueurs(){
        for(String e:joueurs.keySet()){
            System.out.println(joueurs.get(e).getRole()+"  "+joueurs.get(e).getTuile().getNom()+joueurs.get(e).getTuile().getEtatTuile());            
        }
    }*/
    public void afficher(){
        Tuile [][] tuiles = grille.getGrille();
        vuePlateau= new VuePlateau(tuiles);
        vuePlateau.setObservateur(this);
        vueMessage=new VueMessage();
        vueNiveau=new VueNiveau(difficulte);
    }

    public ArrayList< Aventurier> getJoueurs() {
        return joueurs;
    }

    public Grille getGrille() {
        return grille;
    }
    
    public void setJoueurs(ArrayList<Aventurier> joueurs) {
        this.joueurs = joueurs;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Stack<CarteInondation> getPiocheInondation() {
        return piocheInondation;
    }

    public void setPiocheInondation(Stack<CarteInondation> piocheInondation) {
        this.piocheInondation = piocheInondation;
    }

    public Stack<CarteInondation> getDefausseInondation() {
        return defausseInondation;
    }

    public void setDefausseInondation(Stack<CarteInondation> defausseInondation) {
        this.defausseInondation = defausseInondation;
    }

    public boolean isFinJeu() {
        return finJeu;
    }

    public void setFinJeu(boolean finJeu) {
        this.finJeu = finJeu;
    }
    
    
    
    public void initialisationPartie(int nbJoueur){
        
        grille.creeTuiles();

        initialiserJoueur(nbJoueur);
        initialiserTresor();
        //grille.getTuile(1, 3).addAventurier(a);
        CarteTirage carte ;
        
        int i;
        for (i=0 ;i<5 ;i++){
            carte=new CarteTresor("La statue du Zéphyr","pas description");
            piocheTirage.push(carte);
        }
        for (i=0 ;i<5 ;i++){
            carte=new CarteTresor("La Pierre Sacrée","pas description");
            piocheTirage.push(carte);
        }
        for (i=0 ;i<5 ;i++){
            carte=new CarteTresor("Le Cristal Ardent","pas description");
            piocheTirage.push(carte);
        }
        for (i=0 ;i<5 ;i++){
            carte=new CarteTresor("Le Calice de l'Onde","pas description");
            piocheTirage.push(carte);
        }
        for (i=0 ;i<2 ;i++){
            carte=new CarteSacsDeSable();
            piocheTirage.push(carte);
        }
        for (i=0 ;i<3 ;i++){
            carte=new CarteHelicoptere();
            piocheTirage.push(carte);
        }
        for (i=0 ;i<2 ;i++){
            carte=new CarteMonteeDesEaux();
            piocheTirage.push(carte);
        }
        
        
        
        Collections.shuffle(piocheTirage);
        
        
        ArrayList<Tuile> tuiles;
        tuiles = this.getGrille().getTuiles();
        for(Tuile tuile : tuiles){
            CarteInondation cI = new CarteInondation(tuile);
            this.getPiocheInondation().push(cI);
        }
        Collections.shuffle(piocheInondation);
                
        
            
        
        
    }
    
    public void lancerJeu(){
        int x=180;
        for (Aventurier av : joueurs){
            vueAventurier2=new VueAventurier2(av,x);
            x=x+250;
            aventuriers.add(vueAventurier2);
        }
        vueMessage.setLabel("au tour du "+aventurierCourant.getNom());
        
    }
    
    
   /* public void tourDeJeu() throws InterruptedException{
        int i;
        for(Aventurier aventurier :joueurs){
            //afficher vueAventurier
            aventurierCourant=aventurier;
            i=0;
            while (i<3){
                //afficher nb commande
                i=i+1;
            }
            CarteTirage carte =this.piocherCarteTirage();
            if(carte.getNom()=="CarteMonteeDesEaux"){
                monteeEaux(carte);
            }else{
                aventurier.addCarte(carte);
            }
        }
    }*/
    
    @Override
    public void traiterMessage(Message msg) {
        if (msg.getCommande()==BOUGER){
            if (msg.getIdTuile()==null){
                HashSet<Tuile> tuiles =new HashSet<>();
                tuiles=aventurierCourant.tuilesPossibles(this.getGrille());
                
                vuePlateau.afficherTuilesPossibles(tuiles);
            } else {
                String placement=String.valueOf(msg.getIdTuile());
                int ligne;
                int colonne;
                if (placement.length()==1){
                    ligne=0;
                    colonne=Integer.valueOf(String.valueOf(placement.charAt(0)));
                } else {
                    ligne=Integer.valueOf(String.valueOf(placement.charAt(0)));
                    colonne=Integer.valueOf(String.valueOf(placement.charAt(1)));
                }
                Tuile tuile = grille.getTuile(ligne, colonne);

                deplacement(aventurierCourant, tuile);
                
                //vuePlateau.update();
                //vuePlateau.deselectionner();
                vuePlateau.dispose();
                vuePlateau=new VuePlateau(grille.getGrille());
                vuePlateau.setObservateur(this);
                
            }
        } else if(msg.getCommande()==VALIDER_JOUEURS) {
            vueInscription.getWindow().dispose();
            nbJoueurs=msg.getNbJoueurs();
            difficulte= msg.getDifficulte();
            initialisationPartie(nbJoueurs);
            afficher();
            
            
            lancerJeu();
        } else if (msg.getCommande() == ASSECHER) {
            if (msg.getIdTuile() == null) {
                HashSet<Tuile> tuiles = new HashSet<>();
                tuiles = aventurierCourant.assechementPossible(this.getGrille());
                if (tuiles.isEmpty()){
                    vueMessage.setLabel("Assechement impossible, choisir une autre action!");
                    vuePlateau.deselectionner();
                } else {
                    vuePlateau.afficherTuilesPossibles(tuiles);
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
                
                
                //vuePlateau.update();
                //vuePlateau.deselectionner();
                vuePlateau.dispose();
                vuePlateau=new VuePlateau(grille.getGrille());
                vuePlateau.setObservateur(this);

            }
        }
        
        else if(msg.getCommande() == TERMINER){
            this.actionEffectuer = 2;
            this.changerJoueur();
            vuePlateau.dispose();
            vuePlateau=new VuePlateau(grille.getGrille());
            vuePlateau.setObservateur(this);
        }
    }
    
    public void deplacement(Aventurier a,Tuile tuile){            
                a.getPosition().supprAventurier(a);
                tuile.addAventurier(a);
                a.setPosition(tuile);
                changerJoueur();
    }

    public void assechement(Tuile tuile) {
        tuile.setAssechee();
        changerJoueur();
        
        //Tuile[][] tuiles = grille.getGrille();
        //vuePlateau.update();
    }

    /*public void tour(Aventurier a){
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
    }
    */
    
    /*public void assecherTuile(Aventurier a){
        HashSet<Tuile> tuiles = a.assechementPossible(this.getGrille());
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
    }*/
    
    private void monteeEaux(CarteTirage carte){
               
        difficulte=difficulte+1;
        this.addDefausseTirage(carte);
        if (difficulte==5){
            //finDePartie();
        }else{
            Collections.shuffle(defausseInondation);
            while( !(defausseInondation.empty()) ){
                this.addPiocheInondation(defausseInondation.pop());
            }
        }
        vueNiveau.setNiveau(difficulte);
        
    }
    
    public void tirerCarteInondation(){
        Stack defausse = this.getDefausseInondation();
        if(this.getPiocheInondation().isEmpty()){
            Collections.shuffle(defausse);                                      //On mélange la defausse
            while(!(defausse.isEmpty())){
                this.getPiocheInondation().push(getDefausseInondation().pop()); //On deplace la defausse dans la pioche
            }
        }
        CarteInondation cI = this.getPiocheInondation().pop();
        Tuile t = cI.getTuile();
        this.getDefausseInondation().push(cI);
        EtatTuile etat = t.getEtatTuile();
        if(etat == ASSECHEE){
            t.setInondée();
        }
        else if(etat == INONDEE){
            int ligne = t.getLigne();
            int colonne = t.getColonne();
            Grille g = this.getGrille();
            ArrayList tuilesAdjacentes = g.getTuilesAdjacentes(ligne, colonne);
            if(!(t.getAventurierPresent().isEmpty())){            
                if(tuilesAdjacentes.isEmpty()){
                    this.setFinJeu(true);
                }
                else{
                        Aventurier a = null;
                        for(String key : t.getAventurierPresent().keySet()){
                            a = t.getAventurierPresent().get(key);
                        }
                        //demander au joueur de se deplacer sur une case adjacente              
                }
            }
            t.setCoulee();
        }
        else{
            System.out.println("La tuile est déjà coulée");
        }
        
    }

    private void addDefausseTirage(CarteTirage carte) {
        defausseTirage.push(carte);
    }

    private void addPiocheInondation(CarteInondation carte){
        piocheInondation.push(carte);
    }
    
    private void piocherCarteTirage(Aventurier a){
        //pioche une carte et la retourne
        //mélange et remet les carte dans la pioche si la pioche est vide
        CarteTirage carte=piocheTirage.pop();
        if (piocheTirage.empty()){
            while(!defausseTirage.empty()){
               piocheTirage.push(defausseTirage.pop());
            }
            Collections.shuffle(piocheTirage);
        }
        if(carte.getNom()=="CarteMonteeDesEaux"){
                monteeEaux(carte);
            }else{
                a.addCarte(carte);
            }
        
    }
    public void recuperationTresorTuile( Aventurier a,Tresor tresor){
        a.addTresors(tresor);
        this.addTresorsTrouvees(tresor);
        
        
    }
    private void addTresorsTrouvees(Tresor tresor) {
        tresorsTrouvees.add(tresor);
    }
    private void changerJoueur(){
        actionEffectuer=actionEffectuer+1;
        vueMessage.setLabel("nb de coups restants :\n"+(3-actionEffectuer)+"/3");
        if (actionEffectuer==3){
            int i;
            for(i=0;i<difficulte;i++){
                tirerCarteInondation();
            }
            piocherCarteTirage(aventurierCourant);
            piocherCarteTirage(aventurierCourant);
            
            if(joueurs.indexOf(aventurierCourant)+1!=joueurs.size()){
               aventurierCourant=joueurs.get(joueurs.indexOf(aventurierCourant)+1);
               actionEffectuer=0; 
               vueMessage.setLabel("Au tour du "+aventurierCourant.getNom());
               
            }else{
                aventurierCourant=joueurs.get(0);
                actionEffectuer=0; 
            }  
            carteADefausser(aventurierCourant.getPossede().size()-8,aventurierCourant.getPossede());
            
        }
        for (VueAventurier2 vue : aventuriers){
            vue.dispose();
        }
        lancerJeu();
            
        
    }
    
    public void initialiserJoueur(int nbJoueur){
        Aventurier a;
        
        ArrayList<Aventurier> aventuriers = new ArrayList();
        a = new Explorateur("explorateur              ","Explorateur",null);
        aventuriers.add(a);
        a= new Messager(    "messager                 ","Messager",null);
        aventuriers.add(a);
        a=new Ingenieur(   "ingénieur                ","Ingénieur",null);
        aventuriers.add(a);
        a=new Pilote(     "pilote                   ","Pilote",null);
        aventuriers.add(a);
        a=new Plongeur(   "plongeur                 ","Plongeur",null);
        aventuriers.add(a);        
        a=new Navigateur( "navigateur               ","Navigateur",null);
        
        Collections.shuffle(aventuriers);
        
        for(int i = 0; i < nbJoueur; i++){
            a = aventuriers.get(i);
            String nm = a.getRole();

            if(nm == "Explorateur"){
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="La Porte de Cuivre      "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                        aventurierCourant=a;
                    } 
                }
            }

            else if(nm == "Messager"){
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="La Porte d'Argent       "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                    } 
                }
            }
            //grille.getTuile(2, 1).addAventurier(a);

            else if(nm == "Ingénieur"){
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="La Porte de Bronze      "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                    } 
                }
            }
            //grille.getTuile(0, 3).addAventurier(a);

            else if(nm == "Pilote"){            
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="Heliport                "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                    } 
                }
            }
            //grille.getTuile(2, 3).addAventurier(a);

            else if(nm == "Plongeur"){
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="La Porte de Fer         "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                    } 
                }
            }
            //grille.getTuile(1, 2).addAventurier(a);

            else if(nm == "Navigateur"){            
                for (Tuile t :grille.getTuiles()){
                    if (t.getNom()=="La Porte d'or           "){
                        a.setPosition(t);
                        joueurs.add(a);
                        t.aventurierPresent.put(a.getNom(),a);
                    } 
                }
            }

            else{
                System.out.println("InitialisationPartie : Rôle non trouvé");
            }

            if(i == 0){
                aventurierCourant=a;                
            }
        }        
    }
    
    public void initialiserTresor(){
        ArrayList<Tuile> tuiles = this.getGrille().getTuiles();
        for(Tuile tuile : tuiles){
            String nomT = tuile.getNom();
            if(nomT == "La Caverne des Ombres   " || nomT == "La Caverne du Brasier   "){
                tuile.setTresor(Tresor.CRISTAL);
            }
            else if(nomT == "Le Jardin des Hurlements" || nomT == "Le Jardin des Murmures  "){
                tuile.setTresor(Tresor.ZEPHYR);
            }
            else if(nomT == "Le Temple de la Lune    " || nomT == "Le Temple du Soleil     "){
                tuile.setTresor(Tresor.PIERRE);
            }
            else if(nomT == "Le Palais des Marées    " || nomT == "Le Palais de Corail     "){
                tuile.setTresor(Tresor.CALICE);
            }
            else{tuile.setTresor(null);}
        }
        
    }
    
    public void prendreTresor(){
        Tuile tuile = aventurierCourant.getPosition();
        if(!(tuile.getTresor()==null)){
            int cmpt = 0;
            Tresor tresor = tuile.getTresor();
            for(CarteTirage carte : aventurierCourant.getPossede()){
                if(carte.getNom() == tresor.toString()){
                    cmpt += 1;
                }
            }
            if(cmpt >= 4){
                aventurierCourant.addTresors(tresor);            
                for(Tuile t : this.getGrille().getTuiles()){
                    if(t.getTresor().toString()==tresor.toString()){
                        t.setTresor(null);
                    }
                }
            } 
        }
    }
    
    private void carteADefausser(int i, ArrayList<CarteTirage> possede) {
        if (aventurierCourant.getPossede().size()>8){               
                    //VueDefausse(aventurierCourant.getPossede().size()-8,aventurierCourant.getPossede());                
        }    
    }
    
    private void donnerCarteTirage(Aventurier a, Aventurier a2,CarteTirage carte){
        boolean b=false;
        int i=0;
        while(b==false){
            if (a.getPossede().get(i).getNom()==carte.getNom()){
                a.getPossede().remove(i);
                b=true;                       
            }
            i=i+1;
        }
        a2.addCarte(carte);
        
    }
    private void prendreCarteTirage(Aventurier a, Aventurier a2,CarteTirage carte){
        boolean b=false;
        int i=0;
        while(b==false){
            if (a2.getPossede().get(i).getNom()==carte.getNom()){
                a2.getPossede().remove(i);
                b=true;                       
            }
            i=i+1;
        }
        a.addCarte(carte);
        
    }
}

