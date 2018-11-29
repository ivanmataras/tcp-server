package com.ediweb.education.dao;

import com.ediweb.education.entities.Entity;
import com.ediweb.education.entities.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class RoleDAO implements DAO {

    private static Logger log = Logger.getLogger(RoleDAO.class.getName());

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Entity find(int id) {
        return null;
    }

    @Override
    public Entity find(Entity entity) {
        return null;
    }

    @Override
    public void create(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Entity entity) {

    }

    @Override
    public void close(Statement Statement) {

    }

    @Override
    public void close(Connection connection) {

    }
}
