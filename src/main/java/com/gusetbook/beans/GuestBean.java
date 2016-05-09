package com.gusetbook.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class GuestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String fistName;
    private String secondName;
    private String phoneNumber;
    private boolean editable;

    public GuestBean(){}

    public GuestBean(String id, String fistName, String secondName, String phoneNumber) {
        this.id = id;
        this.fistName = fistName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.editable = false;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
