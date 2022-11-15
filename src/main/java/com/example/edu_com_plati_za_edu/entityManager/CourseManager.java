package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseManager implements EntityManager{
    public static String getInsertQuery(Course entity){
        return "Insert into course(subject, price, teacher_id) VALUES('"+
                entity.getSubject() +"', " +
                entity.getPrice() + ", " +
                entity.getTeacherID() + ")";
    }

    public static String getUpdateQuery(Course entity){

        return "UPDATE course SET subject = '" + entity.getSubject() +
                "', price = " + entity.getPrice() +
                ", teacher_id = " + entity.getTeacherID() +
                "WHERE id = " + entity.getId();
    }

    public static Course parseFromQuery(ResultSet rs) throws SQLException {

        return new Course(rs.getInt("id"),
                rs.getString("subject"),
                rs.getInt("price"),
                rs.getInt("teacher_id"));
    }
}
