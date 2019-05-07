package com.ediweb.education.server;

import com.ediweb.education.server.handlers.ConnectionHandler;

import java.util.logging.Logger;

public class TcpServer implements Server {

    private static final Logger log = Logger.getLogger(TcpServer.class.getName());

    private static final ConnectionHandler connectionHandler = new ConnectionHandler();

    public TcpServer() {

    }

    void start() {
        connectionHandler.handle();
    }

}
