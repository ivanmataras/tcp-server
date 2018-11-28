package com.ediweb.education.dao;

import com.ediweb.education.entities.Entity;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface DAO {

    List<Entity> findAll();

    void deleteAll();

    Entity find(int id);

    Entity find(Entity entity);

    void create(Entity entity);

    void update(Entity entity);

    void delete(int id);

    void delete(Entity entity);

    void close(Statement Statement);

    void close(Connection connection);

}
