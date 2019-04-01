package com.ediweb.education.client;

import com.ediweb.education.client.cmdl.CommandLineTcpClientBootstrapper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientBootstrapper {

    private static Logger log = Logger.getLogger(ClientBootstrapper.class.getName());

    public static void main(String[] args) {
        if (log.isLoggable(Level.INFO)) {
            log.info("ClientBootstrapper has started.");
        }
        CommandLineTcpClientBootstrapper commandLineTcpClientBootstrapper = new CommandLineTcpClientBootstrapper();
        commandLineTcpClientBootstrapper.bootstrap();
        if (log.isLoggable(Level.INFO)) {
            log.info("ClientBootstrapper has stopped.");
        }
    }

}
