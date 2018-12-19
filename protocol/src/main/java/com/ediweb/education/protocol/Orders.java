package com.ediweb.education.protocol;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

@XmlRootElement(name = "Orders")
public class Orders implements Document, Entity, Serializable, Cloneable {

    private int id;
    private int number;
    private LocalDate date;
    private int typeId;
    private int statusId;
    private int senderId;
    private int receiverId;
    private String fileName;

    public Orders() {

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

    @Override
    @XmlElement(name = "Number")
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    @XmlElement(name = "Date")
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    @XmlElement(name = "TypeId")
    public int getTypeId() {
        return typeId;
    }

    @Override
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    @XmlElement(name = "StatusId")
    public int getStatusId() {
        return statusId;
    }

    @Override
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    @XmlElement(name = "SenderId")
    public int getSenderId() {
        return senderId;
    }

    @Override
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    @XmlElement(name = "ReceiverId")
    public int getReceiverId() {
        return receiverId;
    }

    @Override
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    @XmlElement(name = "FileName")
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
