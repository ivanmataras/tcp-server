package com.ediweb.education.entities;

import java.io.Serializable;

public class DocumentStatus implements Entity, Serializable, Cloneable {

    private int id;
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
