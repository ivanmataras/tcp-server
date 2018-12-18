package com.ediweb.education.protocol;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "DocumentStatus")
public class DocumentStatus implements Entity, Serializable, Cloneable {

    private int id;
    private String status;


    public DocumentStatus() {

    }

    @Override
    @XmlElement(name = "Id")
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
