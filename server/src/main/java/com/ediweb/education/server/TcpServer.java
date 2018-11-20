package com.ediweb.education.server;

import java.util.concurrent.Callable;

public class TcpServer implements Callable<Boolean> {

    @Override
    public Boolean call() {
        return Boolean.TRUE;
    }

}
