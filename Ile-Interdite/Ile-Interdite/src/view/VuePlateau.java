package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Tuile;
import util.Message;
import util.Observateur;
import util.Parameters;
import static util.Utils.Commandes.BOUGER;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau {
    private VueGrille grille;
    private JFrame frame;
    private Observateur observateur;
    private JButton deplacer;
    private JButton assecher;
    private JButton finir;
    public VuePlateau(Tuile[][] tuiles){
        frame= new JFrame();
        frame.setLocation(180, Parameters.TOP_AUTRES_VUES);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        plateauCentre(tuiles);
        frame.setSize(1200, util.Parameters.HAUTEUR_AUTRES_VUES);
        frame.setVisible(true);
        
    }
    
    /*private void plateauDroit(){
        JPanel droite = new JPanel(new BorderLayout());
        JPanel cartes = new JPanel(new GridLayout(1,2));
        JButton tirage = new JButton("Pioche carte pouvoir");
        cartes.add(tirage);
        JButton innon = new JButton("Pioche carte pouvoir");
        cartes.add(innon);
        droite.add(cartes,BorderLayout.NORTH);
        
    }*/
    private void plateauCentre(Tuile[][] tuiles){
        JPanel panel = new JPanel(new GridLayout(1,3));
        deplacer=new JButton("Déplacer");
        
        assecher=new JButton("assecher");
        finir=new JButton("finir tour");
        panel.add(deplacer);
        panel.add(assecher);
        panel.add(finir);
        frame.add(panel,BorderLayout.NORTH);
        grille = new VueGrille(tuiles);
        
        frame.add(grille,BorderLayout.CENTER);
        
        
        deplacer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(BOUGER,null,null,null,null,0,0);
                observateur.traiterMessage(m);
            }
            
        });
        
        
        
    }
    
    public void afficherTuilesPossibles(HashSet<Tuile> tuiles){
        for(Tuile tuile: tuiles){
            int i = tuile.getLigne();
            int j = tuile.getColonne();
            this.grille.getAffichTuile()[i][j].setCouleur(Color.RED);
            //this.grille.getAffichTuile()[i][j].repaint();
            grille.repaint();
            System.out.println("passer");
        }
        frame.repaint();
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    public void selectionnerDeplacer(){
        assecher.setEnabled(false);
        finir.setEnabled(false);
        frame.repaint();
    }
    
}
