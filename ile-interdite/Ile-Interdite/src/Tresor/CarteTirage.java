/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tresor;

import util.Utils;

/**
 *
 * @author pestree
 */
public abstract class CarteTirage {
    private String nom;
    private String description;

    public CarteTirage(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
