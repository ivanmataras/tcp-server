package com.ediweb.education.server.handlers;

import com.ediweb.education.server.ServerConfigurationManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionHandler {

    private static final Logger log = Logger.getLogger(ConnectionHandler.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private static final Integer PORT = ServerConfigurationManager.getPropertyAsInt("server.port");

    private static final Integer NUMBER_OF_THREADS = ServerConfigurationManager.getPropertyAsInt("server.number_of_threads");

    public ConnectionHandler() {

    }

    public void handle() {

        ServerSocket serverSocket = null;
        //Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        }

        ExecutorService tcpServerExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        Semaphore semaphore = new Semaphore(NUMBER_OF_THREADS);

        while (true) {

            try {

                semaphore.acquire();

                tcpServerExecutorService.submit(new TestConnectionHandler(serverSocket, semaphore));

            } catch (InterruptedException e) {
                if (log.isLoggable(Level.SEVERE)) {
                    log.severe(e.getMessage());
                }
            } finally {

            }

        }

        /*shutdownAndAwaitTermination(tcpServerExecutorService);*/

    }

    private void shutdownAndAwaitTermination(ExecutorService tcpServerExecutorService) {
        tcpServerExecutorService.shutdown();
        try {
            if (!tcpServerExecutorService.awaitTermination(1, TimeUnit.SECONDS)) {
                tcpServerExecutorService.shutdownNow();
                if (!tcpServerExecutorService.awaitTermination(1, TimeUnit.SECONDS))
                    if (log.isLoggable(Level.SEVERE)) {
                        log.severe("CommandExecutorService did not terminate.");
                    }
            }
        } catch (InterruptedException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
            tcpServerExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
