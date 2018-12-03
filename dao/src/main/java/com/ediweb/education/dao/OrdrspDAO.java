package com.ediweb.education.dao;

import com.ediweb.education.entities.Ordrsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdrspDAO implements DAO<Ordrsp> {

    private static final Logger log = Logger.getLogger(OrdrspDAO.class.getName());

    private static final String SQL_SELECT_ALL_DOCUMENTS = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ?";
    private static final String SQL_DELETE_ALL_DOCUMENTS = "DELETE FROM documents WHERE type_id = ?";
    private static final String SQL_SELECT_DOCUMENT_BY_ID = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_SELECT_DOCUMENT = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_INSERT_DOCUMENT = "INSERT INTO documents (number, date, type_id, status_id, filename, sender_id, receiver_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DOCUMENT = "UPDATE documents SET number = ?, date = ?, type_id = ?, status_id = ?, filename = ?, sender_id = ?, receiver_id = ? WHERE type_id = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT_BY_ID = "DELETE FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT = "DELETE FROM documents WHERE type_id = ? AND id = ?";

    private Connection connection;

    public OrdrspDAO() {

    }

    public OrdrspDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ordrsp> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Ordrsp find(int id) {
        return null;
    }

    @Override
    public Ordrsp find(Ordrsp entity) {
        return null;
    }

    @Override
    public void create(Ordrsp entity) {

    }

    @Override
    public void update(Ordrsp entity) {

    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT_BY_ID);
            statement.setString(1, DocumentType.ORDERS.getDocumentType());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Ordrsp ordrsp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT);
            statement.setInt(1, DocumentTypeId.ORDRSP.getDocumentTypeId());
            statement.setInt(2, ordrsp.getId());
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
