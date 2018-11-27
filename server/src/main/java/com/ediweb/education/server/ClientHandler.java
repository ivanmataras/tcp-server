package com.ediweb.education.server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {

    private static Logger log = Logger.getLogger(ClientHandler.class.getName());

    private static Socket clientDialog;

    public ClientHandler(Socket client) {
        this.clientDialog = client;
    }

    @Override
    public void run() {
        try {
            while (!clientDialog.isClosed()) {

            }

            clientDialog.close();

        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }


    }

}
