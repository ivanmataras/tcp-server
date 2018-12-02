package com.ediweb.education.dao;


import com.ediweb.education.entities.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersDAO implements DAO<Orders> {

    private static final Logger log = Logger.getLogger(OrdersDAO.class.getName());

    private static final String SQL_SELECT_ALL_DOCUMENTS = "SELECT id, number, date, type, status, filename, sender_id, receiver_id FROM documents WHERE type = ?";
    private static final String SQL_DELETE_ALL_DOCUMENTS = "DELETE FROM documents WHERE type = ?";
    private static final String SQL_SELECT_DOCUMENT_BY_ID = "SELECT id, number, date, type, status, filename, sender_id, receiver_id FROM documents WHERE type = ? AND id = ?";
    private static final String SQL_SELECT_DOCUMENT = "SELECT id, number, date, type, status, filename, sender_id, receiver_id FROM documents WHERE id = ? AND id = ?";
    private static final String SQL_INSERT_DOCUMENT = "INSERT INTO documents (number, date, type, status, filename, sender_id, receiver_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DOCUMENT = "UPDATE documents SET number = ?, date = ?, type = ?, status = ?, filename = ?, sender_id = ?, receiver_id = ? WHERE type = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT_BY_ID = "DELETE FROM documents WHERE type = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT = "DELETE FROM documents WHERE type = ? AND id = ?";

    private Connection connection;

    public OrdersDAO() {

    }

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Orders find(int id) {
        return null;
    }

    @Override
    public Orders find(Orders entity) {
        return null;
    }

    @Override
    public void create(Orders entity) {

    }

    @Override
    public void update(Orders entity) {

    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT);
            statement.setString(1, DocymentType.ORDERS.getDocumentType());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Orders orders) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT);
            statement.setString(1, orders.getType());
            statement.setInt(2, orders.getId());
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
