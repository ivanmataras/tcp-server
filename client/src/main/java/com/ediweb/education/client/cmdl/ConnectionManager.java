package com.ediweb.education.client.cmdl;

import com.ediweb.education.client.ClientConfigurationManager;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ConnectionManager {

    private static final Logger log = Logger.getLogger(ConnectionManager.class.getName());

    private final String adress = ClientConfigurationManager.getProperty("server.adress");

    private final Integer port = ClientConfigurationManager.getPropertyAsInteger("server.port");

    private final InetSocketAddress socketAddress = new InetSocketAddress(adress, port);

    private final Socket socket = new Socket();

    ConnectionManager() {

    }

    public Socket getSocket() {
        return socket;
    }

}
