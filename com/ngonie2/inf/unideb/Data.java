/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngonie2.inf.unideb;

import com.ngonie1.inf.unideb.Course;
import com.ngonie1.inf.unideb.Department;
import com.ngonie1.inf.unideb.Lecturer;
import com.ngonie1.inf.unideb.MeetingTime;
import com.ngonie1.inf.unideb.Room;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ngoni
 */
public class Data {
    private ArrayList<Room> rooms;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Course> courses;
    private ArrayList<Department> department;
    private ArrayList<MeetingTime> meetingTime;
    private int numberOfClasses = 0;
    
    public Data() {
        initialize();
    }
    
    private Data initialize(){
        Room room1 = new Room("IK204",25);
        Room room2 = new Room("TEOK1",45);
        Room room3 = new Room("ME251",35);
        rooms = new ArrayList<>(Arrays.asList(room1, room2, room3));
        
        MeetingTime meetingTime1 = new MeetingTime("MT1", "MWF 09:00 - 10:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "MWF 10:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "TTH 09:00 - 10:30");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "TTH 10:30 - 12:00");
        meetingTime = new ArrayList<>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));
        
        Lecturer lecturer1 = new Lecturer("L1", "Dr. James Web");
        Lecturer lecturer2 = new Lecturer("L2", "Mr. Mike Brown");
        Lecturer lecturer3 = new Lecturer("L3", "Dr.Steve Day");
        Lecturer lecturer4 = new Lecturer("L4", "Mrs Jane Doe");
        lecturers = new ArrayList<>(Arrays.asList(lecturer1, lecturer2, lecturer3, lecturer4));
        
        Course course1 = new Course("C1", "INBMA17L-01", new ArrayList<>(Arrays.asList(lecturer1, lecturer2)), 25);
        Course course2 = new Course("C2", "INBMA99S-16", new ArrayList<>(Arrays.asList(lecturer1, lecturer2, lecturer3)), 35);
        Course course3 = new Course("C3", "INBMA58S-21", new ArrayList<>(Arrays.asList(lecturer4, lecturer3)), 25);
        Course course4 = new Course("C4", "INBMA23L-22", new ArrayList<>(Arrays.asList(lecturer2, lecturer1)), 30);
        Course course5 = new Course("C5", "INBMA34P-19", new ArrayList<>(Arrays.asList(lecturer3)), 35);
        Course course6 = new Course("C6", "INBMA66S-77", new ArrayList<>(Arrays.asList(lecturer1, lecturer2)), 45);
        Course course7 = new Course("C7", "INBMA89L-66", new ArrayList<>(Arrays.asList(lecturer3, lecturer4)), 45);
        courses = new ArrayList<>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
        
        Department department1 = new Department("Informatics", new ArrayList<>(Arrays.asList(course1, course3)));
        Department department2 = new Department("Enginnering", new ArrayList<>(Arrays.asList(course2, course4, course5)));
        Department department3 = new Department("Biomedicine", new ArrayList<>(Arrays.asList(course6, course7)));
        department = new ArrayList<>(Arrays.asList(department1, department2, department3));
        department.forEach(x-> numberOfClasses += x.getCourses().size());
        
        return this;
        
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Department> getDepartment() {
        return department;
    }

    public ArrayList<MeetingTime> getMeetingTime() {
        return meetingTime;
    }

    public int getNumberOfClasses() {
        return this.numberOfClasses;
    }
    
}
