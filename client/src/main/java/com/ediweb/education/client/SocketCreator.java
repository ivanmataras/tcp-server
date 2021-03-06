package com.ediweb.education.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

public class SocketCreator {


    private SocketCreator() {
    }


    public static Socket create() throws SocketCreatorException, IOException {
        Properties props = loadPropFile();
        return new Socket(getAddress(props), getPort(props));
    }


    private static Properties loadPropFile() throws SocketCreatorException {
        try {
            Properties props = new Properties();
            props.load(TcpClientBootstrapper.class.getResourceAsStream("/config.properties"));
            return props;
        } catch (Exception e) {
            throw new SocketCreatorException("Can't load prop file config.properties!");
        }
    }


    private static String getAddress(Properties props) throws SocketCreatorException {
        try {
            return props.getProperty("server.adress");
        } catch (Exception e) {
            throw new SocketCreatorException("Config file not found!");
        }
    }


    private static int getPort(Properties props) throws SocketCreatorException {
        try {
            String port = props.getProperty("server.port");
            return Integer.parseInt(port);
        } catch (Exception e) {
            throw new SocketCreatorException("Config file not found!");
        }
    }


    private static class SocketCreatorException extends Exception {

        public SocketCreatorException(String errMsg) {
            super(errMsg);
        }

    }

}
