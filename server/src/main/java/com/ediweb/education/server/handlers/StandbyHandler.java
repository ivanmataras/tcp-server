package com.ediweb.education.server.handlers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class StandbyHandler implements Runnable {

    private static final Logger log = Logger.getLogger(StandbyHandler.class.getName());

    private final CountDownLatch standbyHandlerLatch;
    private final StringBuilder clock = new StringBuilder(32);
    private final char CR = '\r';
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss z", Locale.ENGLISH);

    public StandbyHandler(CountDownLatch standbyHandlerLatch) {
        this.standbyHandlerLatch = standbyHandlerLatch;
    }

    @Override
    public void run() {
        try {
            while (true) {
                clock.append(CR).append(ZonedDateTime.now().format(formatter));
                out.print(clock);
                clock.delete(0, clock.length());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException interruptedException) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe("Interrupted exception.");
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("StandbyHandler task has finished.");
        }
        standbyHandlerLatch.countDown();

    }

}
