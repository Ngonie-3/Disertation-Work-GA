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
public class Class {
    private int classId;
    private Department department;
    private Course course;
    private Lecturer lecturer;
    private MeetingTime meetingTime;
    private Room room;

    public Class(int classId, Department department, Course course) {
        this.classId = classId;
        this.department = department;
        this.course = course;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getClassId() {
        return classId;
    }

    public Department getDepartment() {
        return department;
    }

    public Course getCourse() {
        return course;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "["+department.getName()+", "+course.getNumber()+","+lecturer.getId()+","+meetingTime.getId()+"]";
    }
}
