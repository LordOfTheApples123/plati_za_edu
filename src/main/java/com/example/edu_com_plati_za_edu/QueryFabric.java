package com.example.edu_com_plati_za_edu;

import com.example.edu_com_plati_za_edu.entity.*;
import com.example.edu_com_plati_za_edu.entityManager.*;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class QueryFabric {
    private static QueryFabric instance;
    private Map<Class<?>, Class<?>> entityToManager;

    private QueryFabric() {
        initMap();
    }

    public String getInsertQuery(MyEntity entity, Class<?> entityClass){
        Class<?> manager = entityToManager.get(entityClass);
        try {
            Method insertMethod = manager.getMethod("getInsertQuery", entityClass);
            String query = (String) insertMethod.invoke(null, entity);

            return query.replace("<", " nice try ");

        } catch (Exception e) {
            System.err.println("рефлекты упали");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public String getUpdateQuery(MyEntity entity, Class<?> entityClass){
        Class<?> manager = entityToManager.get(entityClass);
        try {
            Method insertMethod = manager.getMethod("getUpdateQuery", entityClass);
            String query = (String) insertMethod.invoke(null, entity);
            return query.replace("<", " nice try ");

        } catch (Exception e) {
            System.err.println("рефлекты упали");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    private void initMap(){
        entityToManager = new HashMap<>();
        entityToManager.put(ClassStud.class, ClassStudManager.class);
        entityToManager.put(GroupStud.class, GroupStudManager.class);
        entityToManager.put(Course.class, CourseManager.class);
        entityToManager.put(Student.class, StudentManager.class);
        entityToManager.put(Teacher.class, TeacherManager.class);
    }

    public static QueryFabric getInstance(){
        if(instance == null){
            instance = new QueryFabric();
        }
        return instance;
    }

    public MyEntity parseFromQuery(Class<?> entityClass, ResultSet rs){
        Class<?> manager = entityToManager.get(entityClass);
        try {
            Method insertMethod = manager.getMethod("parseFromQuery", ResultSet.class);
            Object entity = insertMethod.invoke(null, rs);
            return (MyEntity) entity;

        } catch (Exception e) {
            System.err.println("рефлекты упали");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public String findByIdQuery(int id, Class<?> entityClass) throws SQLException {
        return "SELECT * FROM " + classToSQLTableName(entityClass) + " WHERE id = " + id + ";";

    }

    public String getAllQuery(Class<?> entityClass) throws SQLException{
        return "SELECT * FROM " + classToSQLTableName(entityClass) + ";";
    }

    public String deleteByIdQuery(int id, Class<?> entityClass) throws SQLException {
        return "DELETE FROM " + classToSQLTableName(entityClass) + " WHERE id = " + id + ";";
    }

    private static Boolean compareClasses(Class<?> a, Class<?> b){
        return a.getCanonicalName().equals(b.getCanonicalName());
    }

    private String classToSQLTableName(Class<?> entityClass) throws SQLException {
        if(compareClasses(entityClass, ClassStud.class)){
            return "public.class_stud";
        } else if (compareClasses(entityClass, Course.class)) {
            return "public.course";
        } else if (compareClasses(entityClass, GroupStud.class)) {
            return "public.group_stud";
        } else if (compareClasses(entityClass, Student.class)){
            return "public.student";
        } else if (compareClasses(entityClass, Teacher.class)){
            return "public.teacher";
        }
        else throw new SQLException();
    }
}
