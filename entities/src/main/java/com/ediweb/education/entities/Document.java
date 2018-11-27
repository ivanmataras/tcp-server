package com.ediweb.education.entities;

import java.time.LocalDate;

public interface Document extends Entity {

    int getNumber();

    void setNumber(int number);

    LocalDate getDate();

    void setDate(LocalDate date);

    String getType();

    void setType(String type);

    String getStatus();

    void setStatus(String status);

    int getSenderId();

    void setSenderId(int id);

    int getReceiverId();

    void setReceiverId(int id);

    String getFileName();

    void setFileName(String fileName);

}
