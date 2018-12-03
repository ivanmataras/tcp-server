package com.ediweb.education.dao;

public enum DocumentTypeId {

    ORDERS(1), ORDRSP(2);

    private int documentTypeId;

    DocumentTypeId(int documentType) {
        this.documentTypeId = documentTypeId;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

}
