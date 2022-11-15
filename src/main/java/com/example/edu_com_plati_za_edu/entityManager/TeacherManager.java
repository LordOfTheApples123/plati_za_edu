package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherManager implements EntityManager{

    public static String getInsertQuery(Teacher entity) {
        return "Insert into teacher(email, fio, phone_number) VALUES('" + entity.getEmail() +
                "', '" + entity.getFio() +
                "', " + entity.getPhoneNumber() + ")";
    }


    public static String getUpdateQuery(Teacher entity) {
        return "UPDATE teacher SET email = '" + entity.getEmail() +
                "', fio = '" + entity.getFio() +
                "', phone_number = " + entity.getPhoneNumber() +
                " WHERE id = " + entity.getId();
    }


    public static Teacher parseFromQuery(ResultSet rs) throws SQLException {
        return new Teacher(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("fio"),
                rs.getString("phone_number"));
    }
}
