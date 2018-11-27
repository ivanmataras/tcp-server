package com.ediweb.education.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Orders implements Document, Entity, Serializable, Cloneable {

    public Orders() {
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public void setNumber(int number) {

    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public void setDate(LocalDate date) {

    }

    @Override
    public String getDocumentType() {
        return null;
    }

    @Override
    public void setDocumentType(String documentType) {

    }

    @Override
    public String getDocumentStatus() {
        return null;
    }

    @Override
    public void setDocumentStatus(String DocumentStatus) {

    }

    @Override
    public int getSenderId() {
        return 0;
    }

    @Override
    public void setSenderId(int id) {

    }

    @Override
    public int getReceiverId() {
        return 0;
    }

    @Override
    public void setReceiverId(int id) {

    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public void setFileName(String FileName) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
