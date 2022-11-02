package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher implements MyEntity{
    private int id;
    private String email;
    private String fio;
    private String phoneNumber;

    public Teacher(int id, String email, String fio, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInsertQuery(){
        return "Insert into teacher(email, fio, phone_number) VALUES('"+ email +"', '" + fio + "', " + phoneNumber + ")";
    }




    @Override
    public String getUpdateQuery() {
        return "UPDATE teacher SET email = '" + email +
                "', fio = '" + fio +
                "', phone_number = " + phoneNumber +
                " WHERE id = " + id;
    }

    @Override
    public String toString(){
        return "id = " + id +
                ", email = " + email +
                ", fio = " + fio +
                ", phone_number = " + phoneNumber;
    }
}
