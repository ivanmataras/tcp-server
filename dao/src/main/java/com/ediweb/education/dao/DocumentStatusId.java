package com.ediweb.education.dao;

public enum DocumentStatusId {

    DRAFT(1), SIGNED(2), SENDED(3), RECIVED(4);

    private int documentStatusId;

    DocumentStatusId(int documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    public int getDocumentStatusId() {
        return documentStatusId;
    }

}
