package com.ediweb.education.client.gui.ui.models;

import com.ediweb.education.client.gui.ui.Direction;
import com.ediweb.education.client.gui.ui.DocType;

public class DocsFormModel implements Form {
	
	public static final String NAME = "DocsForm";
	
	private DocType docType;
	private Direction direction;

	public DocsFormModel(DocType docType, Direction direction) {
		this.docType = docType;
		this.direction = direction;
	}

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
