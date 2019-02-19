package com.ediweb.education.client.gui.ui.models;

import com.ediweb.education.client.gui.ui.DocsForm;

import javax.swing.*;

public class FactoryMainPnl {

	private FactoryMainPnl() {
	}

	public static FactoryMainPnl getInstance() {
		return new FactoryMainPnl();
	}

	public JPanel getPanel(Form formModel, JFrame frame) {

		if (DocsFormModel.NAME.equals(formModel.getName())) {
			DocsForm docsForm = new DocsForm(frame, (DocsFormModel) formModel);
			return docsForm.getPanel();
		}

		return null;
	}

}
