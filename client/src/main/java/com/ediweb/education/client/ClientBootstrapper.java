package com.ediweb.education.client;

import java.util.logging.Logger;

public class ClientBootstrapper {

    private static Logger log = Logger.getLogger(ClientBootstrapper.class.getName());

    public static void main(String[] args) {
        try {
            TcpClientBootstrapper bootstrapper = new TcpClientBootstrapper();
            bootstrapper.bootstrap();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
