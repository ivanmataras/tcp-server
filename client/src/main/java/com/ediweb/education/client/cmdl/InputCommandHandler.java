package com.ediweb.education.client.cmdl;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;
import static java.util.logging.Logger.getLogger;

public class InputCommandHandler implements Runnable {

    private static final Logger log = getLogger(InputCommandHandler.class.getName());

    private final CountDownLatch inputCommandHandlerLatch;

    public InputCommandHandler(CountDownLatch inputCommandHandlerLatch) {
        this.inputCommandHandlerLatch = inputCommandHandlerLatch;

    }

    @Override
    public void run() {

        out.print("Commandline Tcp client version 1.0");

        if (log.isLoggable(Level.INFO)) {
            log.info("InputCommandHandler task has finished.");
        }
        inputCommandHandlerLatch.countDown();

    }
}
