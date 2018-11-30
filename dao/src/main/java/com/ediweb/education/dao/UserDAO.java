package com.ediweb.education.dao;

import com.ediweb.education.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements DAO<User> {

    private static final Logger log = Logger.getLogger(UserDAO.class.getName());

    private static final String SQL_SELECT_ALL_USERS = "SELECT id, name, full_name, organization_id, role_id FROM users";
    private static final String SQL_DELETE_ALL_USERS = "SELECT id, name, full_name, organization_id, role_id FROM users";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT id, name,full_name, organization_id, role_id FROM users WHERE id = ?";
    private static final String SQL_SELECT_USER = "SELECT id, name,full_name, organization_id, role_id FROM users WHERE id = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO users (name, full_name, organization_id, role_id) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET name = ?, full_name = ?, organization_id = ?, role_id = ? WHERE id = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";

    private Connection connection;

    public UserDAO() {
    }

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setFullName(resultSet.getString("full_name"));
                user.setOrganizationId(resultSet.getInt("organization_id"));
                user.setRoleId(resultSet.getInt("role_id"));
                users.add(user);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return users;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_USERS);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public User find(int id) {
        User user = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setFullName(resultSet.getString("full_name"));
                user.setOrganizationId(resultSet.getInt("organization_id"));
                user.setRoleId(resultSet.getInt("role_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return user;
    }

    @Override
    public User find(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setFullName(resultSet.getString("full_name"));
                user.setOrganizationId(resultSet.getInt("organization_id"));
                user.setRoleId(resultSet.getInt("role_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return user;
    }

    @Override
    public void create(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getFullName());
            statement.setInt(3, user.getOrganizationId());
            statement.setInt(4, user.getRoleId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getFullName());
            statement.setInt(3, user.getOrganizationId());
            statement.setInt(4, user.getRoleId());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
    }

    @Override
    public void close(Connection connection) {
        throw new UnsupportedOperationException();
    }

}
