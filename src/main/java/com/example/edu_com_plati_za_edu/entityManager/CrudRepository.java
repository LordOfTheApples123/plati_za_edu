package com.example.edu_com_plati_za_edu.entityManager;

import com.example.edu_com_plati_za_edu.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class CrudRepository<T, ID> {

    private final Function<ResultSet, T> entityFactory;
    private final Connection connection;
    private final Function<ID, String> queryfactory;


    protected CrudRepository(Function<ResultSet, T> entityFactory, Connection connection, Function<ID, String> queryfactory) {
        this.entityFactory = entityFactory;
        this.connection = connection;
        this.queryfactory = queryfactory;
    }


    public Optional<T> execute(ID id) {

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(queryfactory.apply(id));
            return Optional.of(entityFactory.apply(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
