package com.ediweb.education.dao;

import com.ediweb.education.entities.DocumentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocumentTypeDAO implements DAO<DocumentType> {

    private static final Logger log = Logger.getLogger(DocumentTypeDAO.class.getName());

    private static final String SQL_SELECT_ALL_TYPES = "SELECT id, type FROM document_types";
    private static final String SQL_DELETE_ALL_TYPES = "DELETE FROM document_types";
    private static final String SQL_SELECT_TYPE_BY_ID = "SELECT id, type FROM document_types WHERE id = ?";
    private static final String SQL_SELECT_TYPE = "SELECT id, type FROM document_types WHERE id = ?";
    private static final String SQL_INSERT_TYPE = "INSERT INTO document_types (type) VALUES(?)";
    private static final String SQL_UPDATE_TYPE = "UPDATE document_types SET type = ? WHERE id = ?";
    private static final String SQL_DELETE_TYPE_BY_ID = "DELETE FROM document_types WHERE id = ?";
    private static final String SQL_DELETE_TYPE = "DELETE FROM document_types WHERE id = ?";

    private Connection connection;

    DocumentTypeDAO() {
    }

    DocumentTypeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<DocumentType> findAll() {
        List<DocumentType> documentTypes = new ArrayList<DocumentType>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_TYPES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DocumentType documentType = new DocumentType();
                documentType.setId(resultSet.getInt("id"));
                documentType.setType(resultSet.getString("type"));
                documentTypes.add(documentType);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentTypes;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_TYPES);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public DocumentType find(int id) {
        DocumentType documentType = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_TYPE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                documentType = new DocumentType();
                documentType.setId(resultSet.getInt("id"));
                documentType.setType(resultSet.getString("type"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentType;
    }

    @Override
    public DocumentType find(DocumentType documentType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_TYPE);
            statement.setInt(1, documentType.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                documentType = new DocumentType();
                documentType.setId(resultSet.getInt("id"));
                documentType.setType(resultSet.getString("type"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return documentType;
    }

    @Override
    public void create(DocumentType documentType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_TYPE);
            statement.setString(1, documentType.getType());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(DocumentType documentType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_TYPE);
            statement.setString(1, documentType.getType());
            statement.setInt(2, documentType.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_TYPE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(DocumentType documentType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_TYPE);
            statement.setInt(1, documentType.getId());
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
