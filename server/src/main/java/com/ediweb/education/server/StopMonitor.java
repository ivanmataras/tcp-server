package com.ediweb.education.server;

import java.net.InetAddress;
import java.net.ServerSocket;

public class StopMonitor implements Runnable {

    private final ServerSocket serverSocket;

    public StopMonitor(InetAddress inetAddress, int port) {
        try {
            serverSocket = new ServerSocket(port, 1, inetAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

    }
}
