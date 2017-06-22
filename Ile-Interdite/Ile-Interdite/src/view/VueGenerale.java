/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Tuile;
import model.aventuriers.Aventurier;
import util.Message;
import util.Observateur;

/**
 *
 * @author louesdol
 */
public class VueGenerale extends JFrame implements Observateur{
    private VueAventurier vueAventurier2;
    private ArrayList<VueAventurier> aventuriers;
    private VuePlateau vuePlateau;
    private VueNiveau vueNiveau;
    private VueMessage vueMessage;
    private int difficulte;
    private Observateur observateur;
    
    public VueGenerale(int difficulte,Tuile [][] tuiles,ArrayList<Aventurier> joueurs,Aventurier a){
        this.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        //delete size for all views
        vuePlateau= new VuePlateau(tuiles);
        vuePlateau.setObservateur(this);
        this.add(vuePlateau,BorderLayout.CENTER);
        this.difficulte=difficulte;
        vueNiveau=new VueNiveau(difficulte);
        this.add(vueNiveau,BorderLayout.WEST);
        int i = joueurs.size();
        JPanel panel = new JPanel(new GridLayout(1,i));
        aventuriers = new ArrayList();
        for (Aventurier av : joueurs){
            if (av.equals(a)){
                vueAventurier2=new VueAventurier(av,Color.red);
            } else {
                vueAventurier2=new VueAventurier(av,Color.gray);
            }
            
            aventuriers.add(vueAventurier2);
            panel.add(vueAventurier2);
        }
        this.add(panel,BorderLayout.NORTH);
        vueMessage = new VueMessage();
        this.add(vueMessage,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
    }
    
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    
    @Override
    public void traiterMessage(Message msg) {
        observateur.traiterMessage(msg);
    }
    
    public void setMessage(String text){
        vueMessage.setLabel(text);
    }
    
    public void afficherTuilesPossibles(HashSet<Tuile> tuiles){
        vuePlateau.afficherTuilesPossibles(tuiles);
    }
    
    public void deselectionner(){
        vuePlateau.deselectionner();
    }
    
    public void setNiveau(Integer niveau){
        vueNiveau.setNiveau(niveau);
    }
    
    
}
