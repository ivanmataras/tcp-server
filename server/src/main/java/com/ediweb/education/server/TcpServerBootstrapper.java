package com.ediweb.education.server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static final Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    public void bootstrap() {

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServerBootstrapper has started.");
        }

        TcpServer tcpServer = new TcpServer();
        tcpServer.start();

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServerBootstrapper has stopped.");
        }

    }

}
