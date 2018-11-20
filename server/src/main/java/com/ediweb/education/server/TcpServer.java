package com.ediweb.education.server;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServer implements Server, Callable<Boolean> {

    private static Logger log = Logger.getLogger(TcpServer.class.getName());

    @Override
    public Boolean call() {
        if (log.isLoggable(Level.INFO)) {
            log.info("Server has stoped.");
        }
        return Boolean.TRUE;
    }

}
