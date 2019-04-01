package com.ediweb.education.client.cmdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class CommandLineTcpClient implements Runnable {

    private static final Logger log = getLogger(CommandLineTcpClient.class.getName());

    private final CountDownLatch latch;
    private final CountDownLatch inputCommandHandlerLatch = new CountDownLatch(1);

    private static ExecutorService commandLineTcpClientService;

    public CommandLineTcpClient(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClient has started.");
        }

        commandLineTcpClientService = Executors.newFixedThreadPool(2);
        InputCommandHandler inputCommandHandler = new InputCommandHandler(inputCommandHandlerLatch);
        commandLineTcpClientService.submit(inputCommandHandler);

        try {
            inputCommandHandlerLatch.await();
        } catch (InterruptedException interruptedException) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe("Interrupted exception.");
            }
        }

        if (!commandLineTcpClientService.isShutdown()) {
            commandLineTcpClientService.shutdown();
            if (log.isLoggable(Level.INFO)) {
                log.info("CommandLineTcpClient executor service has shutted down.");
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClient task has finished.");
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("CommandLineTcpClient has stopped.");
        }

        latch.countDown();

    }

}
