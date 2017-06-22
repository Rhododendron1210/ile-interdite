/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author epalley
 */
public class VueFinDePartie extends JFrame {
    
    private JFrame window;
    private JPanel panel;
    private JButton bout;
    private JLabel label;
    
    public VueFinDePartie(String textLabel){
        window = new JFrame();
        panel = new JPanel();
        bout = new JButton();
        label = new JLabel(textLabel);
        
        window.setSize(350,75);
        
        bout.setText("Quitter");
        
        panel.add(label, BorderLayout.CENTER);
        panel.add(bout, BorderLayout.SOUTH);
        window.add(panel);
        
        window.setAlwaysOnTop(true);
        
        window.setVisible(true);
    }
}
