package com.ediweb.education.client.cmdl;

import java.util.logging.Logger;

class CommandLineTcpClient {

    private static final Logger log = Logger.getLogger(CommandLineTcpClient.class.getName());

    private static final InputCommandHandler inputCommandHandler = new InputCommandHandler();

    public CommandLineTcpClient() {

    }

    void start() {
        inputCommandHandler.handle();
    }

}
