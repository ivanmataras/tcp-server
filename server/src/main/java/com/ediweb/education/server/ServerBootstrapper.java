package com.ediweb.education.server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerBootstrapper {

    private static final Logger log = Logger.getLogger(ServerBootstrapper.class.getName());

    public static void main(String[] args) {
        TcpServerBootstrapper tcpServerBootstrapper = new TcpServerBootstrapper();
        tcpServerBootstrapper.testBootstrap();
        if (log.isLoggable(Level.INFO)) {
            log.info("Server has stoped.");
        }
    }

}
