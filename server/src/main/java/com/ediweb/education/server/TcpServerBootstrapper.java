package com.ediweb.education.server;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    private final CountDownLatch latch = new CountDownLatch(1);

    void bootstrap() {

        ExecutorService service = Executors.newSingleThreadExecutor();
        TcpServer tcpServer = new TcpServer(latch);
        service.submit(tcpServer);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!service.isShutdown()) {
            service.shutdown();
            if (log.isLoggable(Level.INFO)) {
                log.info("Main executors service has shutted down.");
            }
        }

    }
}
