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
    
    private Color couleur;
    
    VueTuile(Tuile tuile){
        JPanel panel = new JPanel(new GridLayout(4,1));
        JLabel label = new JLabel(tuile.getNom());
        this.setLayout(new BorderLayout());
        this.add(label,BorderLayout.NORTH);
        if (tuile.getEtatTuile()==ASSECHEE){
            couleur = Color.orange;
        } else if (tuile.getEtatTuile()==INONDEE){
            couleur = Color.BLUE;
            
        } else {
            couleur =Color.gray;
            this.setEnabled(false);
        }
        panel.setBackground(couleur);
        this.setBackground(couleur);
        HashMap<String,Aventurier> aventuriers = tuile.getAventurierPresent();
        for (Aventurier ave: aventuriers.values()){
            JPanel joueur = new JPanel();
            if (ave!=null){
                joueur.setBackground(ave.getCouleur());
                
            } else {
                joueur.setBackground(couleur);
            }
            panel.add(joueur);
        }
        
        this.add(panel, BorderLayout.CENTER);
    }  

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    
}