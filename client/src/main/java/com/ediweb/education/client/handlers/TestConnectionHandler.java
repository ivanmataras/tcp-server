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
                byte[] buffer = text.getBytes();

                out.println("Send to server :" + " " + text);

                bos.write(buffer);
                bos.flush();

                out.print("Received from server :" + " ");
                int c;
/*                while ((c = bis.read()) != -1) {
                    out.print((char) c);
                }*/

                while (bis.available() != 0) {
                    out.print((char) bis.read());
                }

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
