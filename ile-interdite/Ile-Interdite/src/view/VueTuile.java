package view;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Tuile;
import model.aventuriers.Aventurier;
import util.Observateur;
import static util.Utils.EtatTuile.ASSECHEE;
import static util.Utils.EtatTuile.INONDEE;

public class VueTuile extends JPanel{
    
    private Color couleur;
    private int colonne;
    private int ligne;
    private Tuile tuile;
    private String nom;
    private JButton bouton;
    
    /*VueTuile(Tuile tuile){
        ligne= tuile.getLigne();
        colonne=tuile.getColonne();
        JPanel panel = new JPanel(new GridLayout(4,1));
        JLabel label = new JLabel(tuile.getNom());
        this.setLayout(new BorderLayout());
        this.add(label,BorderLayout.NORTH);
        if (tuile.getEtatTuile()==ASSECHEE){
            setCouleur(Color.orange);
        } else if (tuile.getEtatTuile()==INONDEE){
            setCouleur(Color.BLUE);
        } else {
            setCouleur(Color.gray);
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
    } */

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
        repaint();
        System.out.println("couleur");
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
        this.add(bouton,BorderLayout.CENTER);
        
        
    }
    
    public JButton getBouton(){
        return bouton;
    }
    private void joueurs(){
        JLabel joueur;
        HashMap<String,Aventurier> aventuriers = tuile.getAventurierPresent();
        for (Aventurier ave: aventuriers.values()){
            if (ave!=null){
                joueur= new JLabel(ave.getNom());
                this.add(joueur,BorderLayout.NORTH);
                System.out.println("set joueur");
            } 
               
            
        }
    }
    public void update(){
        joueurs();
        validate();
        repaint();
    }
    
    /*@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = this.getX();
        int y = this.getY();
        if (tuile.getNom()!=null){
            g.setColor(Color.black);
            g.drawString(tuile.getNom(), x+5, y+5);
            System.out.println(tuile.getNom());
        }
        int height = this.getHeight();
        int width=this.getWidth();
        int i=1;
        HashMap<String,Aventurier> aventuriers = tuile.getAventurierPresent();
        for (Aventurier ave: aventuriers.values()){
            if (ave!=null){
                g.setColor(ave.getCouleur());
                g.fillRect(x, y+height/5*i, width, height/5);
                
            } else {
                g.setColor(couleur);
                g.fillRect(x, y+height/5*i, width, height/5);
            }
            i=i+1;
        }
        
    }*/
    
}