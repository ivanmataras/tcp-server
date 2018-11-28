package com.ediweb.education.dao;

import com.ediweb.education.entities.Entity;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class OrganizationDAO implements DAO {

    private static final String SQL_SELECT_ALL_ORGANIZATIONS = "SELECT id, name, full_name FROM organization";
    private static final String SQL_SELECT_ORGANIZATION_BY_ID = "SELECT id, name, full_name FROM organization WHERE id = ?";
    private static final String SQL_INSERT_ORGANIZATION = "INSERT INTO organization (name, full_name) VALUES(?, ?)";
    private static final String SQL_UPDATE_ORGANIZATION = "UPDATE organization SET name = ?, full_name = ? WHERE id = ?";
    private static final String SQL_DELETE_ORGANIZATION = "DELETE FROM organization WHERE id = ?";

    private Connection connection;

    public OrganizationDAO() {

    }

    public OrganizationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Entity> findAll() {
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
