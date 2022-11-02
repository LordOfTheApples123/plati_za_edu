package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;
import java.sql.Time;

public class ClassStud implements MyEntity{
    private int id;
    private String startAt;
    private int roomNo;
    private int groupId;
    private int teacherId;

    public ClassStud(int id, String startAt, int roomNo, int groupId, int teacherId) {
        this.id = id;
        this.startAt = startAt;
        this.roomNo = roomNo;
        this.groupId = groupId;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getInsertQuery(){
        return "Insert into teacher(start_at, room_no, group_id, teacher_id) VALUES('"+ startAt.toString() +"', " + roomNo + ", " + groupId + ", " + teacherId + ")";
    }


    public static ClassStud parseFromQuery(ResultSet rs) throws Exception{
        return new ClassStud(rs.getInt("id"),
                rs.getTime("start_at").toString(),
                rs.getInt("room_no"),
                rs.getInt("group_id"),
                rs.getInt("teacher_id"));
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE class_stud SET start_at = '" + startAt +
                "', room_no = " + roomNo +
                ", group_id = " + groupId +
                ", teacher_id = " + teacherId +
                " WHERE id = " + id;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", startAt = " + startAt +
                ", room_no = " + roomNo +
                ", group_id = " + groupId +
                ", teaher_id = " + teacherId;
    }
}
