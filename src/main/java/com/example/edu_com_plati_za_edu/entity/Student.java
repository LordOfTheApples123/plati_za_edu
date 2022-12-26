package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;

public class Student extends MyEntity{
    private int id;
    private String email;
    private String fio;

    private int groupId;

    public Student(int id, String email, String fio, int groupId) {
        this.id = id;
        this.email = email;
        this.fio = fio;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }





    @Override
    public String toString(){
        return "<td style=\"border: 1px solid black;\">" + id +
                "</td><td style=\"border: 1px solid black;\">" + email +
                "</td><td style=\"border: 1px solid black;\">" + fio +
                "</td><td style=\"border: 1px solid black;\">" + groupId + "</td>";
    }
}
