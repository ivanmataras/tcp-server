package com.ediweb.education.client;

import com.ediweb.education.client.ui.ClientFrame;
import com.ediweb.education.client.ui.DocCreateForm;
import com.ediweb.education.client.ui.DocsForm;

import javax.swing.*;

public class ClientBootstrapper {

    public static void main(String[] args) {
        JFrame frame = new ClientFrame();

        DocsForm reportForm = new DocsForm(frame);
        frame.setContentPane(reportForm.getPanel());

//        DocCreateForm docCreateForm = new DocCreateForm();
//        frame.setContentPane(docCreateForm.getPnlMain());

        frame.pack();
        frame.setVisible(true);
    }
}
