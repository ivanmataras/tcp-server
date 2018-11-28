package com.ediweb.education.client.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusakov on 24.11.18.
 */
public class DocsForm {

	private JFrame frame;

	private JPanel pnlMain;
	private JPanel pnlRoot;
	private JPanel pnlAction;
	private JPanel pnlDocs;
	private JComboBox cbDocType;
	private JComboBox cbDirection;
	private JButton btnSearch;
	private JButton btnCreateDoc;
	private JPanel pnlDocType;
	private JLabel lblDocType;
	private JLabel lblDirection;

	final String[] headers = new String[]{"Отправитель", "Получаетель", "Дата создания"};
	final List<String[]> values = new ArrayList<String[]>();

	public DocsForm(final JFrame frame) {
		this.frame = frame;
		btnCreateDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocCreateForm docCreateForm = new DocCreateForm();

				frame.getContentPane().removeAll();
				frame.setContentPane(docCreateForm.getPnlMain());
				((JPanel) frame.getContentPane()).revalidate();
				frame.repaint();

			}
		});

		String[] value = new String[]{"Ритейлер", "Поставщик", "28/11/2018 10:45:22"};
		values.add(value);

		final AbstractTableModel tabelDocsModel = new TabelDocs(headers, values);
		JTable tblDocs = new JTable(tabelDocsModel);
		JScrollPane scrlDocs = new JScrollPane(tblDocs);
		GridBagConstraints gbc = initGridBagConstraints();
		pnlDocs.add(scrlDocs, gbc);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] value = new String[]{"Ритейлер", "Поставщик", "28/11/2018 10:45:22"};
				values.add(value);
				tabelDocsModel.fireTableDataChanged();
			}
		});

	}

	private GridBagConstraints initGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		return gbc;
	}

	public JPanel getPanel() {
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
		pnlAction = new JPanel();
		pnlAction.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlRoot.add(pnlAction, gbc);
		btnSearch = new JButton();
		btnSearch.setText("Поиск");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlAction.add(btnSearch, gbc);
		btnCreateDoc = new JButton();
		btnCreateDoc.setText("Создать");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlAction.add(btnCreateDoc, gbc);
		pnlDocs = new JPanel();
		pnlDocs.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlRoot.add(pnlDocs, gbc);
		pnlDocType = new JPanel();
		pnlDocType.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlRoot.add(pnlDocType, gbc);
		cbDocType = new JComboBox();
		final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
		defaultComboBoxModel1.addElement("ORDER");
		defaultComboBoxModel1.addElement("ORDRSP");
		cbDocType.setModel(defaultComboBoxModel1);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDocType.add(cbDocType, gbc);
		cbDirection = new JComboBox();
		final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
		defaultComboBoxModel2.addElement("ALL");
		defaultComboBoxModel2.addElement("IN");
		defaultComboBoxModel2.addElement("OUT");
		cbDirection.setModel(defaultComboBoxModel2);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDocType.add(cbDirection, gbc);
		lblDocType = new JLabel();
		lblDocType.setText("Тип документа");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		pnlDocType.add(lblDocType, gbc);
		lblDirection = new JLabel();
		lblDirection.setText("Направление");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 50, 5, 5);
		pnlDocType.add(lblDirection, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return pnlMain;
	}
}
