package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Tuile;
 
public class VueGrille extends JPanel {
    private Tuile[][] tuiles;
    private VueTuile[][] affichTuile;
    VueGrille(Tuile[][] tuiles){
        this.setLayout(new GridLayout(6,6));
        this.tuiles=tuiles;
        creeGrille();
        this.affichTuile = new VueTuile[6][6];
    }
    
    private void creeGrille(){
        int i = 0;
        for(Tuile[] t : tuiles){
            int j = 0;
            for (Tuile tuile : t){
                VueTuile vue = new VueTuile(tuile);
                this.affichTuile[i][j] = vue;
                this.add(vue);
                j += 1;
            }
            i += 1;
        }
    }

    public VueTuile[][] getAffichTuile() {
        return affichTuile;
    }
}