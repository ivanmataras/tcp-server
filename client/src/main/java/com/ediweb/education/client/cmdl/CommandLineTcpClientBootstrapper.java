package com.ediweb.education.client.cmdl;

import com.ediweb.education.client.Bootstrapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLineTcpClientBootstrapper implements Bootstrapper {

    private static final Logger log = Logger.getLogger(CommandLineTcpClientBootstrapper.class.getName());

    private final CountDownLatch latch = new CountDownLatch(1);
    private static ExecutorService service = Executors.newSingleThreadExecutor();

    public void bootstrap() {

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClientBootstrapper has started.");
        }

        CommandLineTcpClient commandLineTcpClient = new CommandLineTcpClient(latch);
        service.submit(commandLineTcpClient);

        try {
            latch.await();
        } catch (InterruptedException interruptedException) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe("Interrupted exception.");
            }
        }

        if (!service.isShutdown()) {
            service.shutdown();
            if (log.isLoggable(Level.INFO)) {
                log.info("CommandLineTcpClientBootstrapper executor service has shutted down.");
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClientBootstrapper has stopped.");
        }

    }

}
