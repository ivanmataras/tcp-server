package com.ediweb.education.client;

import com.ediweb.education.client.ui.ClientFrame;
import com.ediweb.education.client.ui.DocsForm;

import javax.swing.*;

public class ClientBootstrapper {

    public static void main(String[] args) {
        try {
            TcpClientBootstrapper bootstrapper = new TcpClientBootstrapper();
            bootstrapper.bootstrap();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
