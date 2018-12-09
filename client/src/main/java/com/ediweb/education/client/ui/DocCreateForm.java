package com.ediweb.education.client.ui;

import com.ediweb.education.client.ui.models.FactoryMainPnl;
import com.ediweb.education.client.ui.models.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rusakov on 25.11.18.
 */
public class DocCreateForm {

	private final JFrame frame;
	private final Form previousForm;

	private JPanel pnlMain;
	private JPanel pnlRoot;
	private JPanel pnlDoc;
	private JLabel lblDoc;
	private JTextField txt;
	private JButton btnSend;
	private JButton btnSelectDoc;
	private JPanel pnlFooter;
	private JButton btnBack;
	private JLabel lblReceiver;
	private JComboBox comboBox1;


	public DocCreateForm(JFrame frame, Form previousForm) {
		this.frame = frame;
		this.previousForm = previousForm;
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.setContentPane(FactoryMainPnl.getInstance().getPanel(previousForm, frame));
				((JPanel) frame.getContentPane()).revalidate();
				frame.repaint();
			}
		});
	}

	public JPanel getPnlMain() {
		return pnlMain;
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		pnlMain = new JPanel();
		pnlMain.setLayout(new GridBagLayout());
		pnlRoot = new JPanel();
		pnlRoot.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		pnlMain.add(pnlRoot, gbc);
		pnlDoc = new JPanel();
		pnlDoc.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlRoot.add(pnlDoc, gbc);
		btnSend = new JButton();
		btnSend.setText("Отправить");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(btnSend, gbc);
		txt = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(txt, gbc);
		lblDoc = new JLabel();
		lblDoc.setText("Документ");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(lblDoc, gbc);
		btnSelectDoc = new JButton();
		btnSelectDoc.setText("...");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(btnSelectDoc, gbc);
		btnBack = new JButton();
		btnBack.setText("Назад");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(btnBack, gbc);
		lblReceiver = new JLabel();
		lblReceiver.setText("Получатель");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(lblReceiver, gbc);
		comboBox1 = new JComboBox();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDoc.add(comboBox1, gbc);
		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlRoot.add(pnlFooter, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return pnlMain;
	}
}
