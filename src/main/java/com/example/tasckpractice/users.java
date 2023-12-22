package com.example.tasckpractice;

public class users {
    int IDTableData;
    String UserLastNameTableData, UserNameTableData, UserLoginTableData, UserPasswordTableData;
    public int getIDTableData() {
        return IDTableData;
    }
    public void setIDTableData(int IDTableData) {
        this.IDTableData = IDTableData;
    }
    public String getUserLastNameTableDataname() {
        return UserLastNameTableData;
    }
    public void setUserLastNameTableDataname(String UserLastNameTableDataname) {
        this.UserLastNameTableData = UserLastNameTableDataname;
    }
    public String getUserNameTableData() {
        return UserNameTableData;
    }
    public void setUserNameTableData(String userNameTableData) {
        this.UserNameTableData = userNameTableData;
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
    public users(int IDTableData, String UserLastNameTableData, String userNameTableData, String userLoginTableData, String userPasswordTableData) {
        this.IDTableData = IDTableData;
        this.UserLastNameTableData = UserLastNameTableData;
        this.UserNameTableData = userNameTableData;
        this.UserLoginTableData = userLoginTableData;
        this.UserPasswordTableData = userPasswordTableData;
    }
}
