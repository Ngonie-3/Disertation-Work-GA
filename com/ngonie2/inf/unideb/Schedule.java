/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngonie2.inf.unideb;

import com.ngonie1.inf.unideb.Class;
import java.util.ArrayList;

/**
 *
 * @author ngoni
 */
public class Schedule {

    private ArrayList<Class> classes;
    private int classNumb = 0;
    private int numbOfConflicts = 0;
    private boolean isFitnessChanged = true;
    private double fitness = -1;

    public int getNumbOfConflicts() {
        return numbOfConflicts;
    }
    
    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }
    
    private Data data;

    public Data getData() {
        return data;
    }

    public Schedule(Data data) {
        classes = new ArrayList<>(data.getNumberOfClasses());
        this.data = data;
    }

    public Schedule initialize() {
        new ArrayList<>(data.getDepartment()).forEach(department -> {
            department.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, department, course);
                newClass.setMeetingTime(data.getMeetingTime().get((int) (data.getMeetingTime().size() * Math.random())));
                newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
                newClass.setLecturer(course.getLecturers().get((int) (course.getLecturers().size() * Math.random())));
                classes.add(newClass);
            });
        });

        return this;
    }

    public double getFitness() {
        if (isFitnessChanged == true) {
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    private double calculateFitness() {
        numbOfConflicts=0;
        classes.forEach(x -> {
            if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudnets()) numbOfConflicts++;
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y->{
                if(x.getMeetingTime() == y.getMeetingTime() && x.getClassId() != y.getClassId()){
                    if(x.getRoom() == y.getRoom()) numbOfConflicts++;
                    if(x.getLecturer()== y.getLecturer()) numbOfConflicts++;
                }
            });
        });
        return 1/(double)(numbOfConflicts + 1);
    }
    
    @Override
    public String toString(){
        String returnValue = new String();
        for(int x = 0; x< classes.size()-1; x++) returnValue += classes.get(x) + ",";
        returnValue += classes.get(classes.size()-1);
        return returnValue;
    }
}
