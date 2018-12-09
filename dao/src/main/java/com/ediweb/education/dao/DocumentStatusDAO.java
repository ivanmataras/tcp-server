package com.ediweb.education.dao;

import com.ediweb.education.entities.DocumentStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocumentStatusDAO implements DAO<DocumentStatus> {

    private static final Logger log = Logger.getLogger(DocumentStatusDAO.class.getName());

    private static final String SQL_SELECT_ALL_STATUSES = "SELECT id, status FROM document_statuses";
    private static final String SQL_DELETE_ALL_STATUSES = "DELETE FROM document_statuses";
    private static final String SQL_SELECT_STATUS_BY_ID = "SELECT id, status FROM document_statuses WHERE id = ?";
    private static final String SQL_SELECT_STATUS = "SELECT id, status FROM document_statuses WHERE id = ?";
    private static final String SQL_INSERT_STATUS = "INSERT INTO document_statuses (status) VALUES(?)";
    private static final String SQL_UPDATE_STATUS = "UPDATE document_statuses SET status = ? WHERE id = ?";
    private static final String SQL_DELETE_STATUS_BY_ID = "DELETE FROM document_statuses WHERE id = ?";
    private static final String SQL_DELETE_STATUS = "DELETE FROM document_statuses WHERE id = ?";

    private Connection connection;

    DocumentStatusDAO() {
    }

    DocumentStatusDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<DocumentStatus> findAll() {
        List<DocumentStatus> documentStatuses = new ArrayList<DocumentStatus>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_STATUSES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DocumentStatus documentStatus = new DocumentStatus();
                documentStatus.setId(resultSet.getInt("id"));
                documentStatus.setStatus(resultSet.getString("status"));
                documentStatuses.add(documentStatus);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentStatuses;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_STATUSES);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public DocumentStatus find(int id) {
        DocumentStatus documentStatus = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_STATUS_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                documentStatus = new DocumentStatus();
                documentStatus.setId(resultSet.getInt("id"));
                documentStatus.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentStatus;
    }

    @Override
    public DocumentStatus find(DocumentStatus documentStatus) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_STATUS);
            statement.setInt(1, documentStatus.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                documentStatus = new DocumentStatus();
                documentStatus.setId(resultSet.getInt("id"));
                documentStatus.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentStatus;
    }

    @Override
    public void create(DocumentStatus documentStatus) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_STATUS);
            statement.setString(1, documentStatus.getStatus());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(DocumentStatus documentStatus) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_STATUS);
            statement.setString(1, documentStatus.getStatus());
            statement.setInt(2, documentStatus.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_STATUS_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(DocumentStatus documentStatus) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_STATUS);
            statement.setInt(1, documentStatus.getId());
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
