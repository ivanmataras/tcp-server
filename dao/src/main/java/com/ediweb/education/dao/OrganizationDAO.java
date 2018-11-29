package com.ediweb.education.dao;

import com.ediweb.education.entities.Organization;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrganizationDAO implements DAO<Organization> {

    private static Logger log = Logger.getLogger(OrganizationDAO.class.getName());

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
    public List<Organization> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Organization find(int id) {
        return null;
    }

    @Override
    public Organization find(Organization organization) {
        return null;
    }


    @Override
    public void create(Organization organization) {

    }

    @Override
    public void update(Organization organization) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Organization organization) {

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