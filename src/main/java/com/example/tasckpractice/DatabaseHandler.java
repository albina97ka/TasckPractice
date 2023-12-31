package com.example.tasckpractice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," + Const.USER_NUMBER + "," + Const.USER_MAIL + "," +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," + Const.USER_SERVICE +
                ")" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getNumber());
            prSt.setString(4, user.getMail());
            prSt.setString(5, user.getLogin());
            prSt.setString(6, user.getPassword());
            prSt.setString(7, user.getService());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getUser(User user) {
        ResultSet reSet = null;
        String select = "SELECT * FROM " +  Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            reSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reSet;
    }
    public void signServiceAdmin (ServicePerformed serviceperformed){
        String insert = "INSERT INTO " + Const.SERVICEADMIN_TABLE + "("+Const.SERVICEADMIN_LASTNAME + "," +
                Const.SERVICEREGISTERED + "," + Const.USERMAILSERVICE + "," +Const.USERPHONESERVICE +  "," +Const.USERCOSTSERVICE + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, serviceperformed.getName());
            prSt.setString(2, serviceperformed.getRegistered());
            prSt.setString(3, serviceperformed.getMail());
            prSt.setString(4, serviceperformed.getPhone());
            prSt.setString(5, serviceperformed.getCost());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void signService(ServicePerformed serviceperformed){
        String insert = "INSERT INTO " + Const.SERVICEADMIN_TABLE_ARCHIVE + "("+Const.SERVICEADMIN_LASTNAME_ARCHIVE + "," +
                Const.SERVICEREGISTERED_ARCHIVE + "," + Const.USERMAILSERVICE_ARCHIVE + "," + Const.USERPHONESERVICE_ARCHIVE + "," +Const.USERCOSTSERVICE_ARCHIVE + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, serviceperformed.getName());
            prSt.setString(2, serviceperformed.getRegistered());
            prSt.setString(3, serviceperformed.getMail());
            prSt.setString(4, serviceperformed.getPhone());
            prSt.setString(5, serviceperformed.getCost());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void deletingLine (Deleting deleting) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM " + deleting.getName() + " WHERE "+ deleting.getNameId()+" = " + deleting.getID() +";";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }
    public ObservableList<users> Get_All_Users() {
        String select = "SELECT * FROM users";
        ObservableList<users> list_users = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_users.add(new users(resultSet.getInt("idusers"), resultSet.getString("name"),
                        resultSet.getString("lastname"),resultSet.getString("number"), resultSet.getString("mail"), resultSet.getString("login"),
                        resultSet.getString("password"), resultSet.getString("service")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_users;
    }
    public ObservableList<Service> Get_All_Service() {
        String select = "SELECT * FROM registeredservice";
        ObservableList<Service> list_Service = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()){
                list_Service.add(new Service(resultSet.getInt("idRegisteredService"), resultSet.getString("UserNameService"),
                        resultSet.getString("ServiceRegistered"),resultSet.getString("UserMailService"),
                        resultSet.getString("UserPhoneService"),
                        resultSet.getString("UserCostService")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Service;
    }
    public ObservableList<Service> Get_All_Service_Archive() {
        String select = "SELECT * FROM archive";
        ObservableList<Service> list_Archive = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_Archive.add(new Service(resultSet.getInt("idArchive"), resultSet.getString("UserNameService_Archive"),
                        resultSet.getString("ServiceRegistered_Archive"),resultSet.getString("UserMailService_Archive"), resultSet.getString("UserPhoneService_Archive"), resultSet.getString("UserCostService_Archive")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Archive;
    }
}
