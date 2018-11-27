package com.ediweb.education.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    private final CountDownLatch latch = new CountDownLatch(1);

    private static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    void bootstrap() {

        ExecutorService service = Executors.newSingleThreadExecutor();
        TcpServer tcpServer = new TcpServer(latch);
        service.submit(tcpServer);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!service.isShutdown()) {
            service.shutdown();
            if (log.isLoggable(Level.INFO)) {
                log.info("Main executors service has shutted down.");
            }
        }

    }


    void testBootstrap() {
        try (ServerSocket server = new ServerSocket(getPort())) {

            while (!server.isClosed()) {

//                TODO: close server on message

                Socket client = server.accept();

                executeIt.execute(new ClientHandler(client));
                log.info("Connection accepted.");
            }

            executeIt.shutdown();
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        }
    }


    private int getPort() throws Exception {
        try {
            Properties props = new Properties();
            props.load(TcpServerBootstrapper.class.getResourceAsStream("/config.properties"));
            String port = props.getProperty("server.port");
            return Integer.parseInt(port);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Config file not found!");
        }
    }


}
