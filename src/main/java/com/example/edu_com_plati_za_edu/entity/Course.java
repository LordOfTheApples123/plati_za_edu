package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;

public class Course extends MyEntity{
    private int id;
    private String subject;
    private int price;

    private int teacherID;

    public Course(int id, String subject, int price, int teacherID) {
        this.id = id;
        this.subject = subject;
        this.price = price;
        this.teacherID = teacherID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }







    @Override
    public String toString(){
        return "id = " + id+
                ", subject = " + subject +
                ", price = " + price +
                ", teacher_id = " + teacherID;
    }
}
