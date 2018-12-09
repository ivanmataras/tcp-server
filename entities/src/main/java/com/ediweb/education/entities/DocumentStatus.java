package com.ediweb.education.entities;

import java.io.Serializable;

public class DocumentStatus implements Entity, Serializable, Cloneable {

    private int id;
    private String status;


    public DocumentStatus() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
