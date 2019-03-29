package com.ediweb.education.server;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static final Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    private final CountDownLatch latch = new CountDownLatch(1);
    private static ExecutorService service = Executors.newSingleThreadExecutor();

    public void bootstrap() {

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServerBootstrapper has started.");
        }

        TcpServer tcpServer = new TcpServer(latch);
        service.submit(tcpServer);

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
                log.info("TcpServerBootstrapper executor service has shutted down.");
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServerBootstrapper has stopped.");
        }

    }

}
