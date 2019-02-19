package com.ediweb.education.client.gui.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationDialogFrame {


    public JDialog createDialog(JFrame frame, String title, String errMsg) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
        dialog.setSize(200, 100);

        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());

        pan.add(new JLabel(errMsg));
        JButton okButton = new JButton("OK");
        pan.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.dispose();
            }
        });

        dialog.add(pan);

        return dialog;
    }

}
