package view;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Tuile;
import model.aventuriers.Aventurier;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.INONDEE;

public class VueTuile extends JButton{
    
    VueTuile(Tuile tuile){
        JLabel label = new JLabel(tuile.getNom());
        this.setLayout(new BorderLayout());
        this.add(label,BorderLayout.NORTH);
        if (tuile.getEtatTuile()==ASSECHEE){
            this.setBackground(Color.orange);
        } else if (tuile.getEtatTuile()==INONDEE){
            this.setBackground(Color.BLUE);
        } else {
            this.setBackground(Color.gray);
            this.setEnabled(false);
        }
        JPanel panel = new JPanel(new GridLayout(1,4));
        HashMap<String,Aventurier> aventuriers = tuile.getAventurierPresent();
        for (Aventurier ave: aventuriers.values()){
            if (ave!=null){
                
            }
        }
        this.add(panel, BorderLayout.CENTER);
    }  

    
}