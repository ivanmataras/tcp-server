package com.ediweb.education.client.cmdl;

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
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class InputCommandHandler implements Runnable {

    private static final Logger log = Logger.getLogger(InputCommandHandler.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("text", new Locale("en", "US"));

    private static final Map<String, Runnable> commands = new HashMap<>();

    static {
        commands.put("time", new TimeCommandHandler());
    }

    private static final ExecutorService commandExecutorService = Executors.newSingleThreadExecutor();

    private final CountDownLatch inputCommandHandlerLatch;

    public InputCommandHandler(CountDownLatch inputCommandHandlerLatch) {
        this.inputCommandHandlerLatch = inputCommandHandlerLatch;

    }

    @Override
    public void run() {

        out.println(resourceBundle.getString("client.interface.messages.greeting"));
        out.println(resourceBundle.getString("client.interface.messages.helpadvise"));
        out.println(resourceBundle.getString("client.interface.messages.commandadvise"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        try {

            do {
                command = reader.readLine();
                if (commands.containsKey(command))
//                    commands.get(command).run();
                    commandExecutorService.submit(commands.get(command));
            } while (!command.equals("exit"));

        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        }

        if (log.isLoggable(Level.INFO)) {
            log.info("InputCommandHandler task has finished.");
        }
        inputCommandHandlerLatch.countDown();

    }

}
