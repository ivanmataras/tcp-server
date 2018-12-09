package com.ediweb.education.dao;

import com.ediweb.education.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleDAO implements DAO<Role> {

    private static final Logger log = Logger.getLogger(RoleDAO.class.getName());

    private static final String SQL_SELECT_ALL_ROLES = "SELECT id, name, full_name FROM roles";
    private static final String SQL_DELETE_ALL_ROLES = "DELETE FROM roles";
    private static final String SQL_SELECT_ROLE_BY_ID = "SELECT id, name, full_name FROM roles WHERE id = ?";
    private static final String SQL_SELECT_ROLE = "SELECT id, name, full_name  FROM roles WHERE id = ?";
    private static final String SQL_INSERT_ROLE = "INSERT INTO roles (name, full_name) VALUES(?, ?)";
    private static final String SQL_UPDATE_ROLE = "UPDATE roles SET name = ?, full_name = ? WHERE id = ?";
    private static final String SQL_DELETE_ROLE_BY_ID = "DELETE FROM roles WHERE id = ?";
    private static final String SQL_DELETE_ROLE = "DELETE FROM roles WHERE id = ?";

    private Connection connection;

    RoleDAO() {
    }

    RoleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_ROLES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setFullName(resultSet.getString("full_name"));
                roles.add(role);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return roles;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_ROLES);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public Role find(int id) {
        Role role = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ROLE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return role;
    }

    @Override
    public Role find(Role role) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ROLE);
            statement.setInt(1, role.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return role;
    }

    @Override
    public void create(Role role) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_ROLE);
            statement.setString(1, role.getName());
            statement.setString(2, role.getFullName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(Role role) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_ROLE);
            statement.setString(1, role.getName());
            statement.setString(2, role.getFullName());
            statement.setInt(3, role.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_ROLE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Role role) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ROLE);
            statement.setInt(1, role.getId());
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