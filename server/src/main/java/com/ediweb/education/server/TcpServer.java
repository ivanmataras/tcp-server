package com.ediweb.education.server;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class TcpServer implements Server, Runnable {

    private static Logger log = getLogger(TcpServer.class.getName());

    private final CountDownLatch latch;

    public TcpServer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        latch.countDown();
        if (log.isLoggable(Level.INFO)) {
            log.info("Main task has finished.");
        }

    }

}
