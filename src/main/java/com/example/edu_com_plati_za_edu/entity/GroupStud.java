package com.example.edu_com_plati_za_edu.entity;

import java.sql.ResultSet;

public class GroupStud implements MyEntity{
    private int id;
    private int groupNumber;
    private int courseId;

    public GroupStud(int id, int groupNumber, int courseId) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.courseId = courseId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getInsertQuery(){
        return "Insert into teacher(group_number, course_id) VALUES("+ groupNumber +", " + courseId + ")";
    }


    public static GroupStud parseFromQuery(ResultSet rs) throws Exception {
        return new GroupStud(rs.getInt("id"),
                rs.getInt("group_number"),
                rs.getInt("course_id"));
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE group_stud group_number = " + groupNumber +
                ", course_id = " + courseId +
                " WHERE id = " + id;
    }
}
