package view;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Tuile;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.INONDEE;

public class VueTuile extends JPanel {
    
    VueTuile(Tuile tuile){
        JLabel label = new JLabel(tuile.getNom());
        this.add(label);
        if (tuile.getEtatTuile()==ASSECHEE){
            this.setBackground(Color.orange);
        } else if (tuile.getEtatTuile()==INONDEE){
            this.setBackground(Color.BLUE);
        } else {
            this.setBackground(Color.gray);
        }
    }  
}