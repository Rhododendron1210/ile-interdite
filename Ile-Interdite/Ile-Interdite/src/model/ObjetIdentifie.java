/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author louesdol
 */
public class ObjetIdentifie {

    private static Integer lastId = 1;
    protected Integer id;

    public ObjetIdentifie() {
        this.id = ObjetIdentifie.getNextId();
    }

    public Integer getId() {
        return this.id;
    }

    public static Integer getNextId() {
        return lastId++;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
