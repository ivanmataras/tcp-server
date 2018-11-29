package com.ediweb.education.entities;

import java.io.Serializable;

public class Role implements Entity, Serializable, Cloneable {

    private int id;
    private String name;
    private String fullName;

    public Role() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
