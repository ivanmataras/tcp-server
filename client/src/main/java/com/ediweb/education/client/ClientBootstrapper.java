package com.ediweb.education.client;

import com.ediweb.education.client.cmdl.CommandLineTcpClientBootstrapper;

import java.util.logging.Level;
import java.util.logging.Logger;

class ClientBootstrapper {

    private static final Logger log = Logger.getLogger(ClientBootstrapper.class.getName());

    public static void main(String[] args) {
        if (log.isLoggable(Level.INFO)) {
            log.info("ClientBootstrapper has started.");
        }
        Bootstrapper bootstrapper = new CommandLineTcpClientBootstrapper();
        bootstrapper.bootstrap();
        if (log.isLoggable(Level.INFO)) {
            log.info("ClientBootstrapper has stopped.");
        }
    }

}
