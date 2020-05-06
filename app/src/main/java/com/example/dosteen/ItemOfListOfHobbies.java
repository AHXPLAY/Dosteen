package com.example.dosteen;

public class ItemOfListOfHobbies {
    String nameOfHobby;
    String location;
    String hobbyClass;
    String teacherName;
    String contacts;

    public ItemOfListOfHobbies() {
    }

    public ItemOfListOfHobbies(String nameOfHobby, String location, String hobbyClass, String teacherName, String contacts) {
        this.nameOfHobby = nameOfHobby;
        this.location = location;
        this.hobbyClass = hobbyClass;
        this.teacherName = teacherName;
        this.contacts = contacts;
    }

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHobbyClass() {
        return hobbyClass;
    }

    public void setHobbyClass(String hobbyClass) {
        this.hobbyClass = hobbyClass;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
