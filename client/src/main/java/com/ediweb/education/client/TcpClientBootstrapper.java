package com.ediweb.education.client;

import com.ediweb.education.client.ui.ClientFrame;
import com.ediweb.education.client.ui.DocsForm;

import javax.swing.*;
import java.io.InputStream;
import java.net.Socket;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpClientBootstrapper {

    private static Logger log = Logger.getLogger(TcpClientBootstrapper.class.getName());


    public void bootstrap() throws BootstrapperException {

        Properties props = loadPropFile();
        try(Socket socket = new Socket(getAddress(props), getPort(props))) {

            JFrame frame = new ClientFrame();
            DocsForm reportForm = new DocsForm(frame);
            frame.setContentPane(reportForm.getPanel());

            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            log.warning(e.getMessage());
            e.printStackTrace();
        }
    }


    private Properties loadPropFile() throws BootstrapperException {
        try {
            Properties props = new Properties();
            props.load(TcpClientBootstrapper.class.getResourceAsStream("/config.properties"));
            return props;
        } catch (Exception e) {
            throw new BootstrapperException("Can't load prop file config.properties!");
        }
    }


    private String getAddress(Properties props) throws BootstrapperException {
        try {
            return props.getProperty("server.adress");
        } catch (Exception e) {
            throw new BootstrapperException("Config file not found!");
        }
    }


    private int getPort(Properties props) throws BootstrapperException {
        try {
            String port = props.getProperty("server.port");
            return Integer.parseInt(port);
        } catch (Exception e) {
            throw new BootstrapperException("Config file not found!");
        }
    }


    private class BootstrapperException extends Exception {

        public BootstrapperException(String errMsg) {
            super(errMsg);
        }

    }

}
