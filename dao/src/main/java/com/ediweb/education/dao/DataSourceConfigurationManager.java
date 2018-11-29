package com.ediweb.education.dao;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class DataSourceConfigurationManager {

    private static Logger log = Logger.getLogger(DataSourceConfigurationManager.class.getName());

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("datasource");

    private DataSourceConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
