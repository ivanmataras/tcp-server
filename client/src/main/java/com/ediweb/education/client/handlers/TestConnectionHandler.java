package com.ediweb.education.client.handlers;

import com.ediweb.education.client.ClientConfigurationManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class TestConnectionHandler implements Runnable {

    private static final Logger log = Logger.getLogger(TestConnectionHandler.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public TestConnectionHandler() {

    }

    @Override
    public void run() {

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        }

        Integer port = ClientConfigurationManager.getPropertyAsInteger("server.port");

        try (Socket socket = new Socket(inetAddress.getHostAddress(), port)) {
            try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                 BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

                String text = "Hello to server" + " " + "from client" + " " + socket.getLocalAddress() + " " + socket.getLocalPort();
                byte[] bytes = text.getBytes();

                out.print("Send to server :" + " " + text);
                out.print(System.lineSeparator());

                bos.write(bytes);
                bos.flush();

                text = "\n";
                bytes = text.getBytes();

                bos.write(bytes);
                bos.flush();

                out.print("Received from server :" + " ");

                while (true) {
                    if (bis.available() != 0) {
                        int c;
                        c = bis.read();
                        if (c != -1 && c != 10) {
                            out.print((char) c);
                        } else if (c == 10) {
                            break;
                        }
                    }
                }

                out.print(System.lineSeparator());

            } catch (IOException e) {
                if (log.isLoggable(Level.SEVERE)) {
                    log.severe(e.getMessage());
                }
            }
        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        }

    }

}
