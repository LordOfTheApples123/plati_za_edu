package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;

public class Student implements MyEntity{
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

    public String getInsertQuery(){
        return "Insert into student(fio, email, group_id) VALUES('"+ fio +"', '" + email + "', " + groupId + ")";
    }


    public static Student parseFromQuery(ResultSet rs) throws Exception {
        return new Student(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("fio"),
                rs.getInt("group_id"));
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE student SET email = '" + email +
                "', fio = '" + fio +
                "', group_id = " + groupId +
                " WHERE id = " + id;
    }

    @Override
    public String toString(){
        return "id = " + id +
                ", email = " + email +
                ", fio = " + fio +
                ", group_id = " + groupId;
    }
}
