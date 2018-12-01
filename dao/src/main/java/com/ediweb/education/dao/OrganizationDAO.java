package com.ediweb.education.dao;

import com.ediweb.education.entities.Organization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrganizationDAO implements DAO<Organization> {

    private static final Logger log = Logger.getLogger(OrganizationDAO.class.getName());

    private static final String SQL_SELECT_ALL_ORGANIZATIONS = "SELECT id, name, full_name FROM organization";
    private static final String SQL_DELETE_ALL_ORGANIZATIONS = "DELETE FROM organization";
    private static final String SQL_SELECT_ORGANIZATION_BY_ID = "SELECT id, name, full_name FROM organization WHERE id = ?";
    private static final String SQL_SELECT_ORGANIZATION = "SELECT id, name, full_name FROM organization WHERE id = ?";
    private static final String SQL_INSERT_ORGANIZATION = "INSERT INTO organization (name, full_name) VALUES(?, ?)";
    private static final String SQL_UPDATE_ORGANIZATION = "UPDATE organization SET name = ?, full_name = ? WHERE id = ?";
    private static final String SQL_DELETE_ORGANIZATION_BY_ID = "DELETE FROM organization WHERE id = ?";
    private static final String SQL_DELETE_ORGANIZATION = "DELETE FROM organization WHERE id = ?";

    private Connection connection;

    public OrganizationDAO() {

    }

    public OrganizationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Organization> findAll() {
        List<Organization> organizations = new ArrayList<Organization>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_ORGANIZATIONS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setFullName(resultSet.getString("full_name"));
                organizations.add(organization);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return organizations;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_ORGANIZATIONS);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public Organization find(int id) {
        Organization organization = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORGANIZATION_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return organization;
    }

    @Override
    public Organization find(Organization organization) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORGANIZATION);
            statement.setInt(1, organization.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return organization;
    }

    @Override
    public void create(Organization organization) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_ORGANIZATION);
            statement.setString(1, organization.getName());
            statement.setString(2, organization.getFullName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(Organization organization) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_ORGANIZATION);
            statement.setString(1, organization.getName());
            statement.setString(2, organization.getFullName());
            statement.setInt(3, organization.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_ORGANIZATION_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Organization organization) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ORGANIZATION);
            statement.setInt(1, organization.getId());
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