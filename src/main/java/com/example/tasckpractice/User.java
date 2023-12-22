package com.example.tasckpractice;

public class User {
    private String firstName;
    private String lastname;
    private String number;
    private String mail;
    private String login;
    private String password;
    private String service;

    public User(String firstName, String lastname, String number, String mail, String login, String password, String service) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.number = number;
        this.mail = mail;
        this.login = login;
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
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
