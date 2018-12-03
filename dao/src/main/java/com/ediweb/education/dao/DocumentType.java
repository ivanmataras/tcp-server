package com.ediweb.education.dao;

public enum DocumentType {

    ORDERS("ORDERS"), ORDRSP("ORDRSP");

    private String documentType;

    DocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

}
