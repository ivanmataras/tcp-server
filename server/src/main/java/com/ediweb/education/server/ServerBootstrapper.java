package com.ediweb.education.server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerBootstrapper {

    private static Logger log = Logger.getLogger(ServerBootstrapper.class.getName());

    public static void main(String[] args) {
        TcpServerBootstrapper tcpServerBootstrapper = new TcpServerBootstrapper();
        tcpServerBootstrapper.bootstrap();
        if (log.isLoggable(Level.INFO)) {
            log.info("Server has finished the task.");
        }
    }

}
