package com.ediweb.education.client.cmdl;

import com.ediweb.education.client.Bootstrapper;

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
