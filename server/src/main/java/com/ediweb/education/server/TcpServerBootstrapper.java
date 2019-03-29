package com.ediweb.education.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpServerBootstrapper implements Bootstrapper {

    private static final Logger log = Logger.getLogger(TcpServerBootstrapper.class.getName());

    private final CountDownLatch latch = new CountDownLatch(1);
    private static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public void bootstrap() {

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

                Socket client = server.accept();

                executeIt.execute(new ClientHandler(client));
                log.info("Connection accepted.");
            }

            executeIt.shutdown();
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        }
    }

    private int getPort() {
        return ServerConfigurationManager.getPropertyAsInt("server.port");
    }

}
