package com.ediweb.education.client.cmdl;

import com.ediweb.education.client.commands.TimeCommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;
import static java.lang.System.err;

class InputCommandHandler {

    private static final Logger log = Logger.getLogger(InputCommandHandler.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("text", new Locale("en", "US"));

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final Map<String, Runnable> commands = new HashMap<>();

    static {
        commands.put("time", new TimeCommandHandler());
    }

    private static final ExecutorService commandExecutorService = Executors.newSingleThreadExecutor();

    public InputCommandHandler() {

    }

    void runShell() {
        out.println(resourceBundle.getString("client.interface.messages.greeting"));
        out.println(resourceBundle.getString("client.interface.messages.helpadvise"));
        out.println(resourceBundle.getString("client.interface.messages.commandadvise"));

        String command;

        try {
            do {
                command = reader.readLine();
                if (commands.containsKey(command)) {
                    commandExecutorService.submit(commands.get(command));
                }
            } while (!command.equals("exit"));
        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        }
        shutdownAndAwaitTermination(commandExecutorService);
    }

    private void shutdownAndAwaitTermination(ExecutorService commandExecutorService) {
        commandExecutorService.shutdown();
        try {
            if (!commandExecutorService.awaitTermination(1, TimeUnit.SECONDS)) {
                commandExecutorService.shutdownNow();
                if (!commandExecutorService.awaitTermination(1, TimeUnit.SECONDS))
                    if (log.isLoggable(Level.SEVERE)) {
                        log.severe("CommandExecutorService did not terminate.");
                    }
            }
        } catch (InterruptedException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
            commandExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
