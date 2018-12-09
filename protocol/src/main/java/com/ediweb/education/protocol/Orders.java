package com.ediweb.education.protocol;

import java.io.Serializable;
import java.time.LocalDate;

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
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int getTypeId() {
        return typeId;
    }

    @Override
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public int getStatusId() {
        return statusId;
    }

    @Override
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public int getSenderId() {
        return senderId;
    }

    @Override
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    public int getReceiverId() {
        return receiverId;
    }

    @Override
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
