package com.example.dosteen;

public class ItemOfListOfHobbies {
    String nameOfHobby;
    String location;

    public ItemOfListOfHobbies(String nameOfHobby, String location) {
        this.nameOfHobby = nameOfHobby;
        this.location = location;
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
}
