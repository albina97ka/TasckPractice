package com.example.tasckpractice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class sampleController {
    @FXML
    private Button back;
    @FXML
    private TextField mail_filed;
    @FXML
    private TextField name_filed;
    @FXML
    private TextField number_filed;
    @FXML
    private Button sampleButton;
    @FXML
    private CheckBox apartment;
    @FXML
    private CheckBox residential;
    @FXML
    private CheckBox public_buildings;
    @FXML
    private CheckBox territory;
    @FXML
    private CheckBox design;
    @FXML
    private TextField loginFiler;
    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

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
        DatabaseHandler dbHandler = new DatabaseHandler();
        sampleButton.setOnAction(event ->{

            String firstName = name_filed.getText();
            String number = number_filed.getText();
            String mail = mail_filed.getText();
            String location = loginFiler.getText();
            String password = passwordField.getText();
            String service = "";
            if (apartment.isSelected()){service="Жилые_многоквартирные_дома";}
            else if (residential.isSelected()) {service = "Индивидуальнные_жилые_дома";}
            else if (public_buildings.isSelected()) {service="Общественные_здания";}
            else if (territory.isSelected()) {service="Планирование_территории";}
            else{service = "Дизайн_интерьера";}

            User user = new User(firstName,number,mail,location,password,service);
            dbHandler.signUser(user);

        });
    }
}
