package com.ediweb.education.client.ui;

import jdk.nashorn.internal.runtime.JSONFunctions;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AuthorizationFormAction {


    protected void authorization(final JFrame frame, DataOutputStream out, DataInputStream in, String login, String pass) throws IOException {

        String string = String.format("{\"login\":\"%s\",\"password\":\"%s\"}", login, pass);
//        String string = String.format("{\"task\":\"AuthorizationTask\",\"login\":\"%s\",\"password\":\"%s\"}", login, pass);

        out.writeUTF(string);
        out.flush();

        String answer = in.readUTF();

        checkAnswer(frame, answer);
    }


    private void checkAnswer(final JFrame frame, String answer) {
        if ("200".equals(answer)) {
            JFrame docsFormFrame = new ClientFrame();
            DocsForm docCreateForm = new DocsForm(docsFormFrame);

            docsFormFrame.setContentPane(docCreateForm.getPanel());

            docsFormFrame.pack();
            docsFormFrame.setVisible(true);

            frame.dispose();
        } else {
            JDialog dialog = new InformationDialogFrame().createDialog(frame,"Ошибка подключения", "Ошибка авторизации");
            dialog.setVisible(true);
        }
    }

}
