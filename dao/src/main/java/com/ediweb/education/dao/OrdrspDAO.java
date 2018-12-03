package com.ediweb.education.dao;

import com.ediweb.education.entities.Ordrsp;

import java.sql.*;
import java.util.ArrayList;
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
        List<Ordrsp> ordrsps = new ArrayList<Ordrsp>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_DOCUMENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ordrsp ordrsp = new Ordrsp();
                ordrsp.setId(resultSet.getInt("id"));
                ordrsp.setNumber(resultSet.getInt("number"));
                ordrsp.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                ordrsp.setTypeId(resultSet.getInt("type_id"));
                ordrsp.setStatusId(resultSet.getInt("status_id"));
                ordrsp.setFileName(resultSet.getString("filename"));
                ordrsp.setSenderId(resultSet.getInt("sender_id"));
                ordrsp.setReceiverId(resultSet.getInt("receiver_id"));
                ordrsps.add(ordrsp);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return ordrsps;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_DOCUMENTS);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public Ordrsp find(int id) {
        Ordrsp ordrsp = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_DOCUMENT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ordrsp = new Ordrsp();
                ordrsp.setId(resultSet.getInt("id"));
                ordrsp.setNumber(resultSet.getInt("number"));
                ordrsp.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                ordrsp.setTypeId(resultSet.getInt("type_id"));
                ordrsp.setStatusId(resultSet.getInt("status_id"));
                ordrsp.setFileName(resultSet.getString("filename"));
                ordrsp.setSenderId(resultSet.getInt("sender_id"));
                ordrsp.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return ordrsp;
    }

    @Override
    public Ordrsp find(Ordrsp ordrsp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_DOCUMENT);
            statement.setInt(1, ordrsp.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ordrsp = new Ordrsp();
                ordrsp.setId(resultSet.getInt("id"));
                ordrsp.setNumber(resultSet.getInt("number"));
                ordrsp.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                ordrsp.setTypeId(resultSet.getInt("type_id"));
                ordrsp.setStatusId(resultSet.getInt("status_id"));
                ordrsp.setFileName(resultSet.getString("filename"));
                ordrsp.setSenderId(resultSet.getInt("sender_id"));
                ordrsp.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return ordrsp;
    }

    @Override
    public void create(Ordrsp ordrsp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_DOCUMENT);
            statement.setInt(1, ordrsp.getNumber());
            statement.setTimestamp(2, Timestamp.valueOf(ordrsp.getDate().atStartOfDay()));
            statement.setInt(3, DocumentTypeId.ORDERS.getDocumentTypeId());
            statement.setInt(4, ordrsp.getStatusId());
            statement.setString(5, ordrsp.getFileName());
            statement.setInt(6, ordrsp.getSenderId());
            statement.setInt(7, ordrsp.getReceiverId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(Ordrsp ordrsp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_DOCUMENT);
            statement.setInt(1, ordrsp.getNumber());
            statement.setTimestamp(2, Timestamp.valueOf(ordrsp.getDate().atStartOfDay()));
            statement.setInt(3, DocumentTypeId.ORDRSP.getDocumentTypeId());
            statement.setInt(4, ordrsp.getStatusId());
            statement.setString(5, ordrsp.getFileName());
            statement.setInt(6, ordrsp.getSenderId());
            statement.setInt(7, ordrsp.getReceiverId());
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
