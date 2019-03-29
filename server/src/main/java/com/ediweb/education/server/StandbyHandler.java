package com.ediweb.education.server;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StandbyHandler implements Runnable {

    private static final Logger log = Logger.getLogger(StandbyHandler.class.getName());

    private final CountDownLatch standbyHandlerLatch;

    public StandbyHandler(CountDownLatch standbyHandlerLatch) {
        this.standbyHandlerLatch = standbyHandlerLatch;
    }

    @Override
    public void run() {
        if (log.isLoggable(Level.INFO)) {
            log.info("StandbyHandler task has finished.");
        }
        standbyHandlerLatch.countDown();

    }

}
