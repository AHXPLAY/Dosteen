package com.example.dosteen;

public class Section {

    private String location;
    private String name;
    private String secClass;


    public Section(String name, String secClass, String location) {
        this.name = name;
        this.secClass = secClass;
        this.location = location;
    }

    public Section() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecClass() {
        return secClass;
    }

    public void setSecClass(String secClass) {
        this.secClass = secClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loctaion) {
        this.location = location;
    }
}
