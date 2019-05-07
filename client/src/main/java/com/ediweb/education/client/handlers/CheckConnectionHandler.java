package com.ediweb.education.client.handlers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckConnectionHandler implements Runnable {

    private static final Logger log = Logger.getLogger(CheckConnectionHandler.class.getName());

    @Override
    public void run() {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 9001));

        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) {
                log.severe(e.getMessage());
            }
        } finally {

        }
    }

}
