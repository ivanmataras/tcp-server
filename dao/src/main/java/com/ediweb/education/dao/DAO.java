package com.ediweb.education.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface DAO<T> {

    List<T> findAll();

    T find(int id);

    T find(T entity);

    void create(T entity);

    void update(T entity);

    void delete(int id);

    void delete(T entity);

    void close(Statement Statement);

    void close(Connection connection);

}
