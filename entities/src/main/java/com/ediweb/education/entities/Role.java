package com.ediweb.education.entities;

import java.io.Serializable;

public class Role implements Entity, Serializable, Cloneable {

    private int id;
    private String roleName;
    private String rolefullName;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolefullName() {
        return rolefullName;
    }

    public void setRolefullName(String rolefullName) {
        this.rolefullName = rolefullName;
    }

}
