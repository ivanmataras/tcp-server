package com.ediweb.education.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {

    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
