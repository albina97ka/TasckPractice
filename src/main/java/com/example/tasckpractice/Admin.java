package com.example.tasckpractice;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Admin {
    //1 таблица
    @FXML
    private TableView<users> TableUserData;
    @FXML
    private TableColumn<users, Integer> IDTableData;
    @FXML
    private TableColumn<users, String> UserLastNameTableData;
    @FXML
    private TableColumn<users, String> UserNameTableData;
    @FXML
    private TableColumn<users, String> UserLoginTableData;
    @FXML
    private TableColumn<users, String> UserPasswordTableData;
    //относится к окну аккаунты
    @FXML
    private Button Exit;
    @FXML
    private Button Removce;
    @FXML
    private TextField UserLastName;
    @FXML
    private TextField UserLogin;
    @FXML
    private TextField UserName;
    @FXML
    private TextField UserID;
    @FXML
    private Button Add;
    @FXML
    private TextField UserPassword;

    //2 таблица
    @FXML
    private TableView<Applications> TadleApplications;
    @FXML
    private TableColumn<Applications, Integer> IDTableApplications;
    @FXML
    private TableColumn<Applications, String> ClientNameApplications;
    @FXML
    private TableColumn<Applications, String> CustomerNumberApplications;
    @FXML
    private TableColumn<Applications, String> ClientMailApplications;
    @FXML
    private TableColumn<Applications, String> ServiceApplications;
    //относится к окну заявлений
    @FXML
    private TextField IDApplications;
    @FXML
    private Button UpdateApplications;
    @FXML
    private Button DeleteApplications;

    //3 таблица
    @FXML
    private TableView<Service> TableServices;
    @FXML
    private TableColumn<Service, Integer> IDTableServices;
    @FXML
    private TableColumn<Service, String> UserNameServiceTable;
    @FXML
    private TableColumn<Service,String> ServiceRegisteredTable;
    @FXML
    private TableColumn<Service, String> UserMailServiceTable;
    @FXML
    private TableColumn<Service, String> UserPhoneServiceTable;
    @FXML
    private TableColumn<Service, String> UserTimeServiceTable;
    @FXML
    private TableColumn<Service, String> UserCostServiceTable;
    //окно зарегистрированных заявок
    @FXML
    private Button ObService;
    @FXML
    private Button UpdateUser;
    @FXML
    private Button Addservices;
    @FXML
    private TextField CostPerformingService;
    @FXML
    private Button DeleteServices;
    @FXML
    private TextField Id;
    @FXML
    private TextField ServiceRegistered;
    @FXML
    private TextField TimeOfServiceCompletion;
    @FXML
    private TextField UserNameService;
    @FXML
    private TextField UserPhoneService;
    @FXML
    private TextField UserMailService;

    //4 таблица
    @FXML
    private TableView<Service> TableServ;
    @FXML
    private TableColumn<Service, Integer> IDTab;
    @FXML
    private TableColumn<Service, String> NameServiceTable;
    @FXML
    private TableColumn<Service, String> ServiceReg;
    @FXML
    private TableColumn<Service, String> MailServ;
    @FXML
    private TableColumn<Service, String> Time;
    @FXML
    private TableColumn<Service, String> PhoneServic;
    @FXML
    private TableColumn<Service, String> CostSer;

    @FXML
    protected void UpdateUser(MouseEvent event){ClikUpdateUser();}
    @FXML
    protected void UpdateApplications(MouseEvent event){ClikUpdateApplications();}
    @FXML
    protected void UpdateService(MouseEvent event){ClikUpdateService();}
    @FXML
    protected void UpdateService_Archive(MouseEvent event){ClikUpdateService_Archive();}

    private void ClikUpdateService_Archive() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service> list_Archive = dbHandler.Get_All_Service_Archive();

        IDTab.setCellValueFactory(new PropertyValueFactory<Service,Integer>("idRegisteredService"));
        NameServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserNameService"));
        ServiceReg.setCellValueFactory(new PropertyValueFactory<Service,String>("ServiceRegistered"));
        MailServ.setCellValueFactory(new PropertyValueFactory<Service,String>("UserMailService"));
        Time.setCellValueFactory(new PropertyValueFactory<Service,String>("UserPhoneService"));
        PhoneServic.setCellValueFactory(new PropertyValueFactory<Service,String>("UserTimeService"));
        CostSer.setCellValueFactory(new PropertyValueFactory<Service,String>("UserCostService"));

        TableServ.setItems(list_Archive);
    }
    private void ClikUpdateService() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service> list_Service = dbHandler.Get_All_Service();

        IDTableServices.setCellValueFactory(new PropertyValueFactory<Service,Integer>("idRegisteredService"));
        UserNameServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserNameService"));
        ServiceRegisteredTable.setCellValueFactory(new PropertyValueFactory<Service,String>("ServiceRegistered"));
        UserMailServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserMailService"));
        UserPhoneServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserPhoneService"));
        UserTimeServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserTimeService"));
        UserCostServiceTable.setCellValueFactory(new PropertyValueFactory<Service,String>("UserCostService"));

        TableServices.setItems(list_Service);
    }
    private void ClikUpdateApplications() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Applications> list_Applications = dbHandler.Get_All_Applications();

        IDTableApplications.setCellValueFactory(new PropertyValueFactory<Applications,Integer>("iduserrequests"));
        ClientNameApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ClientName"));
        CustomerNumberApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ClientNumber"));
        ClientMailApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ClientMail"));
        ServiceApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ApplicationService"));

        TadleApplications.setItems(list_Applications);
    }
    private void ClikUpdateUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<users> list_users = dbHandler.Get_All_Users();

        IDTableData.setCellValueFactory(new PropertyValueFactory<users,Integer>("IDTableData"));
        UserLastNameTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserLastNameTableDataname"));
        UserNameTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserNameTableData"));
        UserLoginTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserLoginTableData"));
        UserPasswordTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserPasswordTableData"));

        TableUserData.setItems(list_users);
    }
    @FXML
    void initialize() {
        Exit.setOnAction(event -> {
            Exit.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        Add.setOnAction(event -> {signUser();});
        Addservices.setOnAction(event -> {signService();});
        Removce.setOnAction(event -> {
            try {deletingId();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
        DeleteApplications.setOnAction(event -> {
            try {deletingRemoval();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
        DeleteServices.setOnAction(event -> {
            try {deletingAdmin();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
    }
    //зарегистрирование заявки
    private void signService() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Name = UserNameService.getText();
        String Registered = ServiceRegistered.getText();
        String Mail = UserMailService.getText();
        String Phone = UserPhoneService.getText();
        String Time = TimeOfServiceCompletion.getText();
        String Cost = CostPerformingService.getText();

        if(!Name.equals("")&&!Registered.equals("")&&!Mail.equals("")&&!Phone.equals("")&&!Time.equals("")&&!Cost.equals("")){
            ServicePerformed ServicePerformed = new ServicePerformed(Name,Registered,Mail,Phone,Time,Cost);
            dbHandler.signServiceAdmin(ServicePerformed);
            dbHandler.signService(ServicePerformed);

            Addservices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка зарегистрирована");
                    alert.showAndWait();
                }
            });
        }
        else {
            Addservices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте корректность данных" +
                            "(Поле с ID должн бысть пустым)");
                    alert.showAndWait();
                }
            });
        }
    }
    // Добавление пользователя
    private void signUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String lastName = UserLastName.getText();
        String firstName = UserName.getText();
        String login = UserLogin.getText();
        String password = UserPassword.getText();
        if(!firstName.equals("")&&!lastName.equals("")&&!login.equals("")&&!password.equals("")){
            User user = new User();
            dbHandler.signUser(user);

                Add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Пользователь добавлен");
                    alert.showAndWait();
                }
            });
        }
        else {
            Add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте корректность данных" +
                            "(Поле с ID должно бысть пустым)");
                    alert.showAndWait();
                }
            });

        }

    }
    //удаление зарегистрированой заявки
    private void deletingAdmin() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = " RegisteredService ";
        String nameId= " idRegisteredService ";
        String ID = Id.getText();

        if(!Id.equals("")){

            Deleting deleting = new Deleting(name,nameId, ID);
            dbHandler.deletingLine(deleting);

            DeleteServices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка удалена");
                    alert.showAndWait();
                }
            });
        }
        else {
            DeleteServices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных" +
                            "(Только поле с ID должно быть заполнено)");
                    alert.showAndWait();
                }
            });
        }
    }
    //удаление аккаунта
    private void deletingId() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = "users";
        String nameId= "idUserAccounts";
        String ID = UserID.getText();

        if(!UserID.equals("")){

            Deleting deleting = new Deleting(name,nameId, ID);
            dbHandler.deletingLine(deleting);

            Removce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Пользователь удалён");
                    alert.showAndWait();
                }
            });
        }
        else {
            Removce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных" +
                            "(Только поле с ID должно быть заполнено)");
                    alert.showAndWait();
                }
            });
        }
    }
    //удаление заявки
    private void deletingRemoval() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = "userrequests";
        String nameId= "idUserRequests";
        String ID = IDApplications.getText();

        if(!IDApplications.equals("")){

            Deleting deleting = new Deleting(name, nameId, ID);
            dbHandler.deletingLine(deleting);

            DeleteApplications.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка удалена");
                    alert.showAndWait();
                }
            });
        }
        else {
            DeleteApplications.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте корректность данных");
                    alert.showAndWait();
                }
            });

        }
    }
}
