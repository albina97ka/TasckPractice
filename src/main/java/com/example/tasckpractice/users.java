package com.example.tasckpractice;

public class users {
    int IDTableData;
    String UserNameTableData,UserLastNameTableData,NumberTableData,MailTableData, UserLoginTableData, UserPasswordTableData,ServiceTableData;
    public int getIDTableData() {
        return IDTableData;
    }
    public void setIDTableData(int IDTableData) {
        this.IDTableData = IDTableData;
    }
    public String getUserNameTableData() {
        return UserNameTableData;
    }
    public void setUserNameTableData(String userNameTableData) {
        this.UserNameTableData = userNameTableData;
    }
    public String getUserLastNameTableDataname() {
        return UserLastNameTableData;
    }
    public void setUserLastNameTableDataname(String UserLastNameTableDataname) {
        this.UserLastNameTableData = UserLastNameTableDataname;
    }
    public String getNumberTableData() {
        return NumberTableData;
    }
    public void setNumberTableData(String numberTableData) {
        this.NumberTableData = numberTableData;
    }
    public void setMailTableData(String mailTableData) {
        this.MailTableData = mailTableData;
    }
    public String getMailTableData() {
        return MailTableData;
    }
    public String getUserLoginTableData() {
        return UserLoginTableData;
    }
    public void setUserLoginTableData(String userLoginTableData) {
        this.UserLoginTableData = userLoginTableData;
    }
    public String getUserPasswordTableData() {
        return UserPasswordTableData;
    }
    public void setUserPasswordTableData(String userPasswordTableData) {
        this.UserPasswordTableData = userPasswordTableData;
    }
    public String getServiceTableData() {
        return ServiceTableData;
    }
    public void setServiceTableData(String serviceTableData) {
        this.ServiceTableData = serviceTableData;
    }
    public users(int IDTableData, String userLastNameTableData, String userNameTableData,String numberTableData, String mailTableData, String userLoginTableData, String userPasswordTableData,String serviceTableData) {
        this.IDTableData = IDTableData;
        this.UserLastNameTableData = userLastNameTableData;
        this.UserNameTableData = userNameTableData;
        this.NumberTableData = numberTableData;
        this.MailTableData = mailTableData;
        this.UserLoginTableData = userLoginTableData;
        this.UserPasswordTableData = userPasswordTableData;
        this.ServiceTableData = serviceTableData;
    }
}
