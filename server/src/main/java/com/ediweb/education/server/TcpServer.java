package com.ediweb.education.server;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class TcpServer implements Server, Runnable {

    private static final Logger log = getLogger(TcpServer.class.getName());

    private final CountDownLatch latch;
    private final CountDownLatch standbyHandlerLatch = new CountDownLatch(1);

    private static ExecutorService tcpServerService;

    public TcpServer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServer has started.");
        }

        tcpServerService = Executors.newFixedThreadPool(2);
        StandbyHandler standbyHandler = new StandbyHandler(standbyHandlerLatch);
        tcpServerService.submit(standbyHandler);

        try {
            standbyHandlerLatch.await();
        } catch (InterruptedException interruptedException) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe("Interrupted exception.");
            }
        }

        if (!tcpServerService.isShutdown()) {
            tcpServerService.shutdown();
            if (log.isLoggable(Level.INFO)) {
                log.info("TcpServer executor service has shutted down.");
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServer task has finished.");
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("TcpServer has stopped.");
        }

        latch.countDown();
    }

}
