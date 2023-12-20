package com.example.tasckpractice;

import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public DatabaseHandler() {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=Europe/Moscow";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(connectionString, this.dbUser, this.dbPass);
        return this.dbConnection;
    }

    public void signUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_NUMBER + "," + Const.USER_MAIL + "," +
                Const.USER_LOCATION + "," + Const.USER_PASSWORD + "," + Const.USER_SERVICE +
                ")" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getNumber());
            prSt.setString(3, user.getMail());
            prSt.setString(4, user.getLocation());
            prSt.setString(5, user.getPassword());
            prSt.setString(6, user.getService());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getUser(User user) {
        ResultSet reSet = null;
        String select = "SELECT * FROM " +  Const.USER_TABLE + " WHERE " + Const.USER_LOCATION + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLocation());
            prSt.setString(2, user.getPassword());
            reSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reSet;
    }
}
