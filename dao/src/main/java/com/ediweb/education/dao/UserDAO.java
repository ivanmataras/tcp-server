package com.ediweb.education.dao;

import com.ediweb.education.entities.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO implements DAO {

    private static final String SQL_SELECT_ALL_USERS = "SELECT id, name, full_name, organization_id, role_id FROM users";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT id, name,full_name, organization_id, role_id FROM users WHERE id = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO users (name, full_name, organization_id, role_id) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET name = ?, full_name = ?, organization_id = ?, role_id = ? WHERE id = ?";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";

    private Connection connection;

    public UserDAO() {

    }

    public UserDAO(Connection connection) {
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
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqlException) {
//            лог о невозможности закрытия Statement
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
//            генерация исключения, т.к.нарушается работа пула
        }
    }
}
