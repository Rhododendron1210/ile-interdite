/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        panel = new JPanel(new GridLayout(2,1));
        bout = new JButton();
        label = new JLabel(textLabel);
        
        window.setSize(600,100);
        
        bout.setText("Quitter");
        
        panel.add(label, BorderLayout.CENTER);
        panel.add(bout, BorderLayout.SOUTH);
        window.add(panel);
        
        window.setAlwaysOnTop(true);
        window.setLocationRelativeTo(null);
        
        window.setVisible(true);
        
        bout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
