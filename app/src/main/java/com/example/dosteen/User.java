package com.example.dosteen;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String userName;
    private String email;
    private String contacts;
    private String id;
    private int numOfSections;

    public User(String userName, String email, String contacts, String id, int numOfSections) {
        this.userName = userName;
        this.email = email;
        this.contacts = contacts;
        this.id = id;
        this.numOfSections = numOfSections;

    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumOfSections() {
        return numOfSections;
    }

    public void setNumOfSections(int numOfSections) {
        this.numOfSections = numOfSections;
    }
}
