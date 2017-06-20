package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Tuile;
 
public class VueGrille extends JPanel {
    private Tuile[][] tuiles;
    
    VueGrille(Tuile[][] tuiles){
        this.setLayout(new GridLayout(6,6));
        this.tuiles=tuiles;
        creeGrille();
    }
    
    private void creeGrille(){
        for(Tuile[] t : tuiles){
            for (Tuile tuile : t){
                VueTuile vue = new VueTuile(tuile);
                this.add(vue);
            }
        }
    }
}