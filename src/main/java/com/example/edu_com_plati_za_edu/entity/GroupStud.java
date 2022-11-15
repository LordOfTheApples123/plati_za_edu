package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;

public class GroupStud extends MyEntity{
    private int id;
    private int groupNumber;
    private int courseId;

    public GroupStud(int id, int groupNumber, int courseId) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.courseId = courseId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }




    @Override
    public String toString() {
        return "id = " + id +
                ", groupNumber = " + groupNumber +
                ", courseId = " + courseId;
    }
}
