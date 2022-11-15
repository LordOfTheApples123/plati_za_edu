package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.ClassStud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassStudManager implements EntityManager{
    public static String getInsertQuery(ClassStud entity){
        return "Insert into class_stud(start_at, room_no, group_id, teacher_id) VALUES('"+
                entity.getStartAt() + "', " +
                entity.getRoomNo() + ", " +
                entity.getGroupId() + ", " +
                entity.getTeacherId() + ")";
    }

    public static String getUpdateQuery(ClassStud entity){

        return "UPDATE class_stud SET start_at = '" + entity.getStartAt() +
                "', room_no = " + entity.getRoomNo() +
                ", group_id = " + entity.getGroupId() +
                ", teacher_id = " + entity.getTeacherId() +
                " WHERE id = " + entity.getId();
    }

    public static ClassStud parseFromQuery(ResultSet rs) throws SQLException {
        return new ClassStud(rs.getInt("id"),
                rs.getTime("start_at").toString(),
                rs.getInt("room_no"),
                rs.getInt("group_id"),
                rs.getInt("teacher_id"));
    }
}
