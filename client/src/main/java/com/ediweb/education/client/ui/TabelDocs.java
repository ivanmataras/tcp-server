package com.ediweb.education.client.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TabelDocs extends AbstractTableModel {

	private String[] headers;
	private List<String[]> values;

	public TabelDocs(String[] headers, List<String[]> values) {
		super();
		this.headers = headers;
		this.values = values;
	}

	public int getRowCount() {
		return values.size();
	}

	public int getColumnCount() {
		return headers.length;
	}

	public Object getValueAt(int r, int c) {
		return values.get(r)[c];
	}

	public String getColumnName(int c) {
		return headers[c];
	}

}
