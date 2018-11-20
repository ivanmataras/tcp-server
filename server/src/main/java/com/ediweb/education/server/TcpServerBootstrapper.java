package com.ediweb.education.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    void bootstrap() {

        ExecutorService service = Executors.newSingleThreadExecutor();
        TcpServer tcpServer = new TcpServer();
        Future<Boolean> result = service.submit(tcpServer);

        while (!result.isDone()) {

            try {
                service.awaitTermination(1, TimeUnit.SECONDS);
                if (log.isLoggable(Level.INFO)) {
                    log.info("Server is preparing to stop.");
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {

            }

        }
    }

}
