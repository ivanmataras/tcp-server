package com.ediweb.education.client;

import com.ediweb.education.client.gui.TcpClientBootstrapper;

import java.util.logging.Logger;

public class ClientBootstrapper {

    private static Logger log = Logger.getLogger(ClientBootstrapper.class.getName());

    public static void main(String[] args) {
        try {
            Bootstrapper bootstrapper = new TcpClientBootstrapper();
            bootstrapper.bootstrap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
