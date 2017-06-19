/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author louesdol
 */
public class Grille extends JPanel{
    
    
    @Override
    public void paintComponent(Graphics g){
        
        this.setLayout( new GridLayout(6,6));
        
        JButton x3y1 = new JButton();
        JButton x4y1 = new JButton();
        JButton x2y2 = new JButton();
        JButton x3y2 = new JButton();
        JButton x4y2 = new JButton();
        JButton x5y2 = new JButton();
        JButton x1y3 = new JButton();
        JButton x2y3 = new JButton();
        JButton x3y3 = new JButton();
        JButton x4y3 = new JButton();
        JButton x5y3 = new JButton();
        JButton x6y3 = new JButton();
        JButton x1y4 = new JButton();
        JButton x2y4 = new JButton();
        JButton x3y4 = new JButton();
        JButton x4y4 = new JButton();
        JButton x5y4 = new JButton();
        JButton x6y4 = new JButton();
        JButton x2y5 = new JButton();
        JButton x3y5 = new JButton();
        JButton x4y5 = new JButton();
        JButton x5y5 = new JButton();
        JButton x3y6 = new JButton();
        JButton x4y6 = new JButton();
        
        this.add(x3y1);
        this.add(x4y1);
        this.add(x2y2);
        this.add(x3y2);
        this.add(x4y2);
        this.add(x5y2);
        this.add(x1y3);
        this.add(x2y3);
        this.add(x3y3);
        this.add(x4y3);
        this.add(x5y3);
        this.add(x6y3);
        this.add(x1y4);
        this.add(x2y4);
        this.add(x3y4);
        this.add(x4y4);
        this.add(x5y4);
        this.add(x6y4);
        this.add(x2y5);
        this.add(x3y5);
        this.add(x4y5);
        this.add(x5y5);
        this.add(x3y6);
        this.add(x4y6);
        
    }
}

