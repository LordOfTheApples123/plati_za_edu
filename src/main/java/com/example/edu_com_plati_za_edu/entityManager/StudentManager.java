package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager implements EntityManager{
    public static String getInsertQuery(Student entity){
        return "Insert into student(fio, email, group_id) VALUES('"+
                entity.getFio() +"', '" +
                entity.getEmail() + "', " +
                entity.getGroupId() + ")";
    }

    public static String getUpdateQuery(Student entity){
        return "UPDATE student SET email = '" + entity.getEmail() +
                "', fio = '" + entity.getFio() +
                "', group_id = " + entity.getGroupId() +
                " WHERE id = " + entity.getId();
    }

    public static Student parseFromQuery(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("fio"),
                rs.getInt("group_id"));
    }
}
