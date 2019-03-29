package com.ediweb.education.server;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ServerConfigurationManager {

    private static final Logger log = Logger.getLogger(ServerConfigurationManager.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ServerConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
