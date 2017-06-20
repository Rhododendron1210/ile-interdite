package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Tuile;
import util.Message;
import util.Observateur;
 
public class VueGrille extends JPanel implements Observateur{
    private Tuile[][] tuiles;
    private VueTuile[][] affichTuile;
    private Observateur observateur;
    
    VueGrille(Tuile[][] tuiles){
        this.setLayout(new GridLayout(6,6));
        this.tuiles=tuiles;
        this.affichTuile = new VueTuile[6][6];
        initialiser();
        creeGrille();
    }
    private void initialiser(){
        int i = 0;
        for(Tuile[] t : tuiles){
            int j = 0;
            for (Tuile tuile : t){
                VueTuile vue = new VueTuile(tuile);
                affichTuile[i][j] = vue;
                j += 1;
            }
            i += 1;
        }
    }
    private void creeGrille(){
        for(VueTuile[] t : affichTuile){
            for (VueTuile tuile : t){
                tuile.setObservateur(this);
                this.add(tuile);
            }
        }
    }
    
    public VueTuile[][] getAffichTuile() {
        return affichTuile;
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    
    @Override
    public void traiterMessage(Message msg) {
        observateur.traiterMessage(msg);
    }
}