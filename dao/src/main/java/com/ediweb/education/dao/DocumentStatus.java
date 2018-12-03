package com.ediweb.education.dao;

public enum DocumentStatus {

    DRAFT("DRAFT"), SIGNED("SIGNED"), SENDED("SENDED"), RECIVED("RECIVED");

    private String documentStatus;

    DocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

}
