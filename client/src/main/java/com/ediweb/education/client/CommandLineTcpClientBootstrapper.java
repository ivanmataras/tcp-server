package com.ediweb.education.client;

import java.util.logging.Logger;

import static java.lang.System.out;

public class CommandLineTcpClientBootstrapper implements Bootstrapper {

    private static Logger log = Logger.getLogger(CommandLineTcpClientBootstrapper.class.getName());

    public void bootstrap() {
        out.println("Command line TCP client started.");
        waitForInput();
    }

    private void waitForInput() {


    }
}
