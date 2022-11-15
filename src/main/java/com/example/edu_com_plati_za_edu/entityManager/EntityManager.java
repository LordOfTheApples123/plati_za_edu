package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.MyEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityManager {

    static String getInsertQuery(MyEntity entity){
        return null;
    }

    static String getUpdateQuery(MyEntity entity){
        return null;
    }

    static MyEntity parseFromQuery(ResultSet rs) throws SQLException{
        return null;
    }
}
