package com.example.tasckpractice;

public class User {
    private String firstName;
    private String number;
    private String mail;
    private String location;
    private String password;
    private String service;

    public User(String firstName, String number, String mail, String location, String password, String service) {
        this.firstName = firstName;
        this.number = number;
        this.mail = mail;
        this.location = location;
        this.password = password;
        this.service = service;
    }
    public User() {}
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
}
