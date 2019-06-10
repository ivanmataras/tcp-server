package com.ediweb.education.client.handlers;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static java.lang.System.out;

public class HelpCommandHandler implements Runnable {

    private static final Logger log = Logger.getLogger(HelpCommandHandler.class.getName());

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("text", new Locale("en", "US"));

    @Override
    public void run() {
        out.println(resourceBundle.getString("client.interface.commands.help"));
        out.println(resourceBundle.getString("client.interface.commands.time"));
        out.println(resourceBundle.getString("client.interface.commands.testconnection"));
        out.println(resourceBundle.getString("client.interface.commands.connect"));
        out.println(resourceBundle.getString("client.interface.commands.disconnect"));
        out.println(resourceBundle.getString("client.interface.commands.send"));
        out.println(resourceBundle.getString("client.interface.commands.receive"));
        out.println(resourceBundle.getString("client.interface.commands.exit"));
    }
}
