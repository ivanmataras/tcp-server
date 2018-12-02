package com.ediweb.education.dao;

public enum DocymentType {

    ORDERS("Orders"), ORDRSP("Ordrsp");

    private String documentType;

    DocymentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

}
