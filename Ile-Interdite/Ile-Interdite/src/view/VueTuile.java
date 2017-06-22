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

public class VueTuile extends JPanel{
    
    private Color couleur;
    private int colonne;
    private int ligne;
    private Tuile tuile;
    private JButton bouton;
    


    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        bouton.repaint();
    }
    
    VueTuile(Tuile tuile){
        this.tuile=tuile;
        
        this.setLayout(new BorderLayout());
        bouton= new JButton(tuile.getNom());
        if (tuile.getEtatTuile()==ASSECHEE){
            setCouleur(Color.orange);
        } else if (tuile.getEtatTuile()==INONDEE){
            setCouleur(Color.BLUE);
        } else {
            setCouleur(Color.gray);
            this.setEnabled(false);
        }
        bouton.setBackground(couleur);
        ligne= tuile.getLigne();
        colonne=tuile.getColonne();
        joueurs();
        tresor();
        this.add(bouton,BorderLayout.CENTER);
    }
    
    public JButton getBouton(){
        return bouton;
    }
    private void joueurs(){
        JLabel joueur;
        
        HashMap<String,Aventurier> aventuriers = tuile.getAventurierPresent();
        int i = aventuriers.size();
        
        JPanel panel = new JPanel(new GridLayout(i,1));
        for (Aventurier ave: aventuriers.values()){
            if (ave!=null){
                joueur= new JLabel(ave.getNom());
                panel.add(joueur);
            }  
        }
        this.add(panel,BorderLayout.NORTH);
    }
    
    private void tresor(){
        JLabel tresor;
        
        if (tuile.getTresor()!=null){
            tresor = new JLabel(tuile.getTresor().getLibelle());
            this.add(tresor,BorderLayout.SOUTH);
        }
    }
    
   
    
}
