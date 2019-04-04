package com.ediweb.education.client.cmdl;

import com.ediweb.education.client.Bootstrapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLineTcpClientBootstrapper implements Bootstrapper {

    private static final Logger log = Logger.getLogger(CommandLineTcpClientBootstrapper.class.getName());

    public void bootstrap() {

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClientBootstrapper has started.");
        }

        CommandLineTcpClient commandLineTcpClient = new CommandLineTcpClient();
        commandLineTcpClient.start();

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClientBootstrapper has stopped.");
        }

    }

}
