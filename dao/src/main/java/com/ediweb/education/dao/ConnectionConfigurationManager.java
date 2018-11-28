package com.ediweb.education.dao;

import java.util.ResourceBundle;

public class ConnectionConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("database.properties");

    // класс извлекает информацию из файла config.properties
    private ConnectionConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
