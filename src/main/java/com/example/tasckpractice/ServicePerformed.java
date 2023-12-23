package com.example.tasckpractice;

public class ServicePerformed {
    private String name;
    private String Registered;
    private String Mail;
    private String Phone;
    private String Time;
    private String Cost;

    public ServicePerformed(String name, String registered, String mail, String phone, String time, String cost) {
        this.name = name;
        Registered = registered;
        Mail = mail;
        Phone = phone;
        Time = time;
        Cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegistered() {
        return Registered;
    }
    public void setRegistered(String registered) {
        Registered = registered;
    }
    public String getMail() {
        return Mail;
    }
    public void setMail(String mail) {Mail = mail;}
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
    }
    public String getCost() {
        return Cost;
    }
    public void setCost(String cost) {
        Cost = cost;
    }
}
