/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Utils.Tresor;
import static util.Utils.Tresor.CALICE;
import static util.Utils.Tresor.CRISTAL;
import static util.Utils.Tresor.PIERRE;
import static util.Utils.Tresor.ZEPHYR;

/**
 *
 * @author Yannis
 */
public class VueTresor extends JPanel{
    
    public VueTresor(ArrayList<Tresor> tresorsTrouves) {
        
        this.setLayout(new GridLayout(4,1));
        
        JLabel labelCalice = new JLabel("Le Calice de l'Onde");
        JLabel labelPierre = new JLabel("La Pierre Sacrée");
        JLabel labelZephyr = new JLabel("La statue du Zéphyr");
        JLabel labelCristal = new JLabel("Le Cristal Ardent");
        
        for (Tresor t : tresorsTrouves) { //paracours de la collection de trésors trouvés
            if (t == CALICE) {
                this.add(labelCalice);
            } else if (t == CRISTAL) {
                this.add(labelCristal);
            } else if (t == ZEPHYR) {
                this.add(labelZephyr);
            } else if (t == PIERRE) {
                this.add(labelPierre);
            }
        }
        
        this.setBorder(BorderFactory.createTitledBorder("Trésors récupérés"));
    }
}
