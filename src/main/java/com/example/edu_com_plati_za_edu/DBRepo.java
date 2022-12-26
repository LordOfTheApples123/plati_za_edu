package com.example.edu_com_plati_za_edu;

import com.example.edu_com_plati_za_edu.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRepo {
    private Connection con;
    private final QueryFabric queryFabric = QueryFabric.getInstance();
    

   

    public DBRepo() {
        init();
    }

    private void init() {
        {
            try {
                con = ConnectionMgr.getNewConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
    }

    public void insert(MyEntity entity) throws SQLException {
            PreparedStatement st = con.prepareStatement(queryFabric.getInsertQuery(entity, entity.getClass()));
            st.executeUpdate();
    }

    public void deleteByIdFrom(int id, Class<?> entityClass) throws SQLException{
            findById(id, entityClass);
            PreparedStatement st = con.prepareStatement(queryFabric.deleteByIdQuery(id, entityClass));
            st.executeUpdate();

    }

    public MyEntity findById(int id, Class<?> entityClass) throws SQLException{
        PreparedStatement st = con.prepareStatement(queryFabric.findByIdQuery(id, entityClass));
        ResultSet rs = st.executeQuery();
        if(!rs.next()){
            throw new SQLException();
        }
        return queryFabric.parseFromQuery(entityClass, rs);
    }

    public List<MyEntity> getAll(Class<?> entityClass) throws SQLException {
        List<MyEntity> result = new ArrayList<>();
        PreparedStatement st = con.prepareStatement(queryFabric.getAllQuery(entityClass));
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            result.add(queryFabric.parseFromQuery(entityClass, rs));
        }
        return result;
    }

//    public List<Student> getStudents() {
//        List<Student> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.student;");
//            while (rs.next()) {
//                result.add((Student) queryFabric.parseFromQuery(Student.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public List<Course> getCourses() {
//        List<Course> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.course;");
//            while (rs.next()) {
//                result.add((Course) queryFabric.parseFromQuery(Course.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public List<ClassStud> getClasses() {
//        List<ClassStud> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.class_stud;");
//            while (rs.next()) {
//                result.add((ClassStud) queryFabric.parseFromQuery(ClassStud.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public List<GroupStud> getGroups() {
//        List<GroupStud> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.group_stud;");
//            while (rs.next()) {
//                result.add((GroupStud) queryFabric.parseFromQuery(GroupStud.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public List<Teacher> getTeachers() {
//        List<Teacher> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher;");
//            while (rs.next()) {
//                result.add((Teacher) queryFabric.parseFromQuery(Teacher.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
    public void update(MyEntity obj) {

        try {
            PreparedStatement st = con.prepareStatement(queryFabric.getUpdateQuery(obj, obj.getClass()));
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public Student findStudentById(int id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.student WHERE id = " + id + ";");
//            return (Student) queryFabric.parseFromQuery(Student.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Teacher findTeacherById(int id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher WHERE id = " + id + ";");
//            return (Teacher) queryFabric.parseFromQuery(Teacher.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ClassStud findClassById(int id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.class_stud WHERE id = " + id + ";");
//            return (ClassStud) queryFabric.parseFromQuery(ClassStud.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Course findCourseById(int id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.course WHERE id = " + id + ";");
//            return (Course) queryFabric.parseFromQuery(Course.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public GroupStud findGroupById(int id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.teacher WHERE id = " + id + ";");
//            return (GroupStud) queryFabric.parseFromQuery(GroupStud.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<Student> getGroupList(int groupNumber) {
//        List<Student> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.student WHERE group_id = " + groupNumber + ";");
//            while (rs.next()) {
//                result.add((Student) queryFabric.parseFromQuery(Student.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public Teacher getTeacherByCourseId(int req_id){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM teacher te WHERE id IN " +
//                    "(SELECT teacher_id from course co WHERE id = )" + req_id);
//            return (Teacher) queryFabric.parseFromQuery(Teacher.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Teacher getTeacherByCourseName(int subjectName){
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM teacher te WHERE id IN " +
//                    "(SELECT teacher_id from course co WHERE subject = ')" + subjectName + "';");
//            return (Teacher) queryFabric.parseFromQuery(Teacher.class, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<ClassStud> getGroupsClasses(int groupNumber){
//        List<ClassStud> result = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM class_stud WHERE group_id IN " +
//                    "(SELECT id from group_stud WHERE group_number = )" + groupNumber + ";");
//            while(rs.next()){
//                result.add((ClassStud) queryFabric.parseFromQuery(ClassStud.class, rs));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
