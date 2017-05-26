/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

/**
 *
 * @author Yannis
 */
public class Aventurier {
    
    private String nom;
    private String role;
    
    Aventurier(String nom, String role){
        nom = this.nom;
        role = this.role;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getNom() {
        return nom;
    }
}
