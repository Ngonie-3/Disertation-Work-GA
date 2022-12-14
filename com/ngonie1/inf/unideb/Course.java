/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngonie1.inf.unideb;

import java.util.ArrayList;

/**
 *
 * @author ngoni
 */
public class Course {
    private String number = null;
    private String name = null;
    private int maxNumberOfStudnets;
    private ArrayList<Lecturer> lecturers;
    
    public Course(String number, String name, ArrayList<Lecturer> lecturers, int maxNumberOfStudents){
        this.number = number;
        this.name = name;
        this.lecturers = lecturers;
        this.maxNumberOfStudnets = maxNumberOfStudents;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberOfStudnets() {
        return maxNumberOfStudnets;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        return name;
    }
     
}
