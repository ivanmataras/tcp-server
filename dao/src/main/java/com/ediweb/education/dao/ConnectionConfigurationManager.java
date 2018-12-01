package com.ediweb.education.dao;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ConnectionConfigurationManager {

    private static final Logger log = Logger.getLogger(ConnectionConfigurationManager.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    private ConnectionConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
