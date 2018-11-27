package com.ediweb.education.client.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rusakov on 24.11.18.
 */
public class ClientFrame extends JFrame {

	public ClientFrame() throws HeadlessException {
		super("EDI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
	}

}
