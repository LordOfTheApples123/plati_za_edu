package com.example.edu_com_plati_za_edu;

import com.example.edu_com_plati_za_edu.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBRepo {
    private static Connection con;

    {
        try {
            con = ConnectionMgr.getNewConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(MyEntity obj) {
        try {
            Statement st = con.createStatement();
            st.executeQuery(obj.getInsertQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteByIdFrom(int id, String table) {
        try {
            Statement st = con.createStatement();
            st.executeQuery("DELETE FROM " + table + " WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudents() {
        List<Student> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.student;");
            while (rs.next()) {
                result.add(Student.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Course> getCourses() {
        List<Course> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.course;");
            while (rs.next()) {
                result.add(Course.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<ClassStud> getClasses() {
        List<ClassStud> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.class_stud;");
            while (rs.next()) {
                result.add(ClassStud.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<GroupStud> getGroups() {
        List<GroupStud> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.group_stud;");
            while (rs.next()) {
                result.add(GroupStud.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Teacher> getTeachers() {
        List<Teacher> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher;");
            while (rs.next()) {
                result.add(Teacher.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void update(MyEntity obj) {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(obj.getUpdateQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student findStudentById(int id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.student WHERE id = " + id + ";");
            return Student.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Teacher findTeacherById(int id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher WHERE id = " + id + ";");
            return Teacher.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ClassStud findClassById(int id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.class_stud WHERE id = " + id + ";");
            return ClassStud.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Course findCourseById(int id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.course WHERE id = " + id + ";");
            return Course.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GroupStud findGroupById(int id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher WHERE id = " + id + ";");
            return GroupStud.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> getGroupList(int groupNumber) {
        List<Student> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.student WHERE group_id = " + groupNumber + ";");
            while (rs.next()) {
                result.add(Student.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Teacher getTeacherByCourseId(int req_id){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM teacher te WHERE id IN " +
                    "(SELECT teacher_id from course co WHERE id = )" + req_id);
            return Teacher.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Teacher getTeacherByCourseName(int subjectName){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM teacher te WHERE id IN " +
                    "(SELECT teacher_id from course co WHERE subject = ')" + subjectName + "';");
            return Teacher.parseFromQuery(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<ClassStud> getGroupsClasses(int groupNumber){
        List<ClassStud> result = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM class_stud WHERE group_id IN " +
                    "(SELECT id from group_stud WHERE group_number = )" + groupNumber + ";");
            while(rs.next()){
                result.add(ClassStud.parseFromQuery(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
