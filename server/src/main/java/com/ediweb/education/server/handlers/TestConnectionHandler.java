package com.ediweb.education.server.handlers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class TestConnectionHandler implements Runnable {

    private static final Logger log = Logger.getLogger(TestConnectionHandler.class.getName());

    ServerSocket serverSocket;
    Socket socket;
    Semaphore semaphore;

    TestConnectionHandler(ServerSocket serverSocket, Semaphore semaphore) {
        this.serverSocket = serverSocket;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try (Socket socket = serverSocket.accept()) {
            try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                 BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

                out.print("Received from client :" + " ");
                int c;
/*                while ((c = bis.read()) != -1) {
                    out.print((char) c);
                }*/

                while (bis.available() != 0) {
                    out.print((char) bis.read());
                }

                String text = "Hello to client" + " " + "from server" + " " + socket.getLocalAddress() + " " + socket.getLocalPort();
                byte[] buffer = text.getBytes();

                out.println("Send to client :" + " " + text);

                bos.write(buffer);
                bos.flush();

            } catch (IOException e) {
                if (log.isLoggable(Level.SEVERE)) {
                    log.severe(e.getMessage());
                }
            } finally {

            }
        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        } finally {
            semaphore.release();
        }

    }

}
