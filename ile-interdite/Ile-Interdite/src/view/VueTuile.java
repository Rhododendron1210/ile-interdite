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

public class VueTuile extends JPanel {
    
    VueTuile(Tuile tuile){
        JLabel label = new JLabel(tuile.getNom());
        this.add(label);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
    }  
}