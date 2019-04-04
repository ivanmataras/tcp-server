package com.ediweb.education.client.cmdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class CommandLineTcpClient {

    private static final Logger log = Logger.getLogger(CommandLineTcpClient.class.getName());

    private static final InputCommandHandler inputCommandHandler = new InputCommandHandler();

    public CommandLineTcpClient() {

    }

    void start() {
        inputCommandHandler.runShell();
    }

}
