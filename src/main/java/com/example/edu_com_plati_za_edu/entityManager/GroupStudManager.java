package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.GroupStud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupStudManager implements EntityManager{
    public static String getInsertQuery(GroupStud entity){
        return "Insert into teacher(group_number, course_id) VALUES("+
                entity.getGroupNumber() +", " +
                entity.getCourseId() + ")";
    }

    public static String getUpdateQuery(GroupStud entity){

        return "UPDATE group_stud group_number = " + entity.getGroupNumber() +
                ", course_id = " + entity.getCourseId() +
                " WHERE id = " + entity.getId();
    }

    public static GroupStud parseFromQuery(ResultSet rs) throws SQLException {

        return new GroupStud(rs.getInt("id"),
                rs.getInt("group_number"),
                rs.getInt("course_id"));
    }
}
