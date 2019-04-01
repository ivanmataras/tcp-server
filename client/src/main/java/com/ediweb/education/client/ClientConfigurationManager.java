package com.ediweb.education.client;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ClientConfigurationManager {

    private static final Logger log = Logger.getLogger(ClientConfigurationManager.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ClientConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public static Integer getPropertyAsInteger(String key) {
        return Integer.valueOf(resourceBundle.getString(key));
    }

    public static int getPropertyAsInt(String key) {
        return Integer.parseInt(resourceBundle.getString(key));
    }

}
