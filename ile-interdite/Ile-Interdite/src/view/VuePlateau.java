package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Tuile;
import util.Message;
import util.Observateur;
import util.Parameters;
import static util.Utils.Commandes.ASSECHER;
import static util.Utils.Commandes.BOUGER;
import static util.Utils.Commandes.DONNER;
import static util.Utils.Commandes.RECUPERER_TRESOR;
import static util.Utils.Commandes.TERMINER;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends JPanel {
    private VueGrille grille ;
    
    private Observateur observateur;
    private JButton deplacer;
    private JButton assecher;
    private JButton finir;
    private util.Utils.Commandes commande;
    private JButton helico;
    private JButton sacSable;
    private JButton passer;
    private JButton tresor;
    
    public VuePlateau(Tuile[][] tuiles){
        this.setLayout(new BorderLayout());
        plateauCentre(tuiles);
        
    }
    
    
    private void plateauCentre(Tuile[][] tuiles){
        JPanel panel = new JPanel(new GridLayout(1,3));
        deplacer=new JButton("Déplacer");
        assecher=new JButton("Assécher");
        finir=new JButton("Fin de tour");
        panel.add(deplacer);
        panel.add(assecher);
        panel.add(finir);
        this.add(panel,BorderLayout.NORTH);
        grille = new VueGrille(tuiles);
        
        this.add(grille,BorderLayout.CENTER);
        
        JPanel panel2 = new JPanel(new GridLayout(4,1));
        helico= new JButton("Carte Helicoptere");
        helico.setEnabled(false);
        panel2.add(helico);
        sacSable= new JButton("Carte Sac De Sable");
        sacSable.setEnabled(false);
        panel2.add(sacSable);
        passer= new JButton("Donner une carte");
        passer.setEnabled(true);
        panel2.add(passer);
        tresor= new JButton("Prendre le tresor");
        tresor.setEnabled(true);
        panel2.add(tresor);
        this.add(panel2,BorderLayout.EAST);
        
        tresor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(RECUPERER_TRESOR,null,null,null,null);
                observateur.traiterMessage(m);
            }
            
        });
        
        
        deplacer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                assecher.setEnabled(false);
                finir.setEnabled(false);
                //deplacer.setBackground(Color.red);
                commande=BOUGER;
                Message m = new Message(BOUGER,null,null,null,null);
                observateur.traiterMessage(m);
            }
            
        });
        
        
        assecher.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                deplacer.setEnabled(false);
                finir.setEnabled(false);
                commande=ASSECHER;
                Message m = new Message(ASSECHER,null,null,null,null);
                observateur.traiterMessage(m);
            }
            
        });
        
        finir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commande = TERMINER;
                Message m = new Message(TERMINER,null,null,null,null);
                observateur.traiterMessage(m);
            }
        });
        
        passer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(DONNER,null,null,null,null);
                observateur.traiterMessage(m);
            }
            
        });
        
        
        
        for (VueTuile[] vues : grille.getAffichTuile()){
            for (VueTuile vue: vues){
                vue.getBouton().addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = String.valueOf(vue.getLigne())+String.valueOf(vue.getColonne());
                        Message m = new Message(commande,null,null,null,Integer.valueOf(id));
                        observateur.traiterMessage(m);
                    }
                    
                });
            }
        }
        
        
    }
    
    public void afficherTuilesPossibles(HashSet<Tuile> tuiles){
        for(Tuile tuile: tuiles){
            int i = tuile.getLigne();
            int j = tuile.getColonne();
            this.grille.getAffichTuile()[i][j].getBouton().setEnabled(true);
           
        }
        repaint();
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    
    public void deselectionner(){
        assecher.setEnabled(true);
        finir.setEnabled(true);
        deplacer.setEnabled(true);
        grille.creeGrille();
        this.repaint();
    }

    public void setHelico(boolean b) {
        helico.setEnabled(b);
    }

    public void sePasser(boolean b) {
        passer.setEnabled(b);
    }

   
    public void setTresor(boolean b) {
        tresor.setEnabled(b);
    }

    public void setSacSable(boolean b) {
        sacSable.setEnabled(b);
    }
    
    public void setDeplacer(boolean b) {
        deplacer.setEnabled(b);
    }
    
    public void setAssecher(boolean b) {
        assecher.setEnabled(b);
    }
    
    public void setFinir(boolean b) {
        finir.setEnabled(b);
    }    
}
