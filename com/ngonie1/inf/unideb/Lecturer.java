/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngonie1.inf.unideb;

/**
 *
 * @author ngoni
 */
public class Lecturer {
    private String id;
    private String name;

    public Lecturer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
