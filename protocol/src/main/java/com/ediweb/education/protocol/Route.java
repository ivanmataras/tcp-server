package com.ediweb.education.protocol;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Route")
public class Route implements Entity, Serializable, Cloneable {

    private int id;
    private int ownerId;
    private int senderId;
    private int receiverId;

    public Route() {

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

    @XmlElement(name = "OwnerId")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @XmlElement(name = "SenderId")
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @XmlElement(name = "ReceiverId")
    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}
