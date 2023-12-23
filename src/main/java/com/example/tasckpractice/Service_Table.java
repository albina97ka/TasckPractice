package com.example.tasckpractice;

public class Service_Table {
    private String lastName;
    private String ClientNumber;
    private String ClientMail;
    private String Service;

    public Service_Table(String lastName, String clientNumber, String clientMail, String service) {
        this.lastName = lastName;
        ClientNumber = clientNumber;
        ClientMail = clientMail;
        Service = service;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getClientNumber() {
        return ClientNumber;
    }
    public void setClientNumber(String clientNumber) {
        ClientNumber = clientNumber;
    }
    public String getClientMail() {
        return ClientMail;
    }
    public void setClientMail(String clientMail) {
        ClientMail = clientMail;
    }
    public String getService() {return Service;}
    public void setService(String service) {Service = service;}
}
