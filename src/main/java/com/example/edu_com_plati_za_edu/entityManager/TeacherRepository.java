package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class TeacherRepository extends CrudRepository<Teacher, Integer>{

    public static TeacherRepository create(Connection connection){
        try {
            Function<ResultSet, Teacher> func = TeacherRepository::parseFromQuery;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new TeacherRepository(
                TeacherRepository::parseFromQuery,
                connection,
                (Integer id) -> String.format("SELECT * FROM public.teacher WHERE id = %d;", id)
        );
    }

    private TeacherRepository(Function<ResultSet, Teacher> entityFactory, Connection connection, Function<Integer, String> queryfactory) {
        super(entityFactory, connection, queryfactory);
    }

    public static Teacher parseFromQuery(ResultSet rs) throws SQLException {
        return new Teacher(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("fio"),
                rs.getString("phone_number"));
    }
}
