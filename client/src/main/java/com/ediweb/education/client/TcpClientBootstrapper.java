package com.ediweb.education.client;

import com.ediweb.education.client.ui.AuthorizationForm;
import com.ediweb.education.client.ui.AuthorizationFrame;

import java.util.logging.Logger;

public class TcpClientBootstrapper implements Bootstrapper {

    private static Logger log = Logger.getLogger(TcpClientBootstrapper.class.getName());

    public void bootstrap() {

        AuthorizationFrame frame = new AuthorizationFrame();
        AuthorizationForm authorizationForm = new AuthorizationForm(frame);

        frame.setContentPane(authorizationForm.getPanel());

        frame.pack();
        frame.setVisible(true);
    }

}
