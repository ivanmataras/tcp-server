package com.ediweb.education.entities;

import java.time.LocalDate;

public interface Document extends Entity {

    int getNumber();

    void setNumber(int number);

    LocalDate getDate();

    void setDate(LocalDate date);

    String getDocumentType();

    void setDocumentType(String documentType);

    String getDocumentStatus();

    void setDocumentStatus(String DocumentStatus);

    int getSenderId();

    void setSenderId(int id);

    int getReceiverId();

    void setReceiverId(int id);

    String getFileName();

    void setFileName(String FileName);

}
