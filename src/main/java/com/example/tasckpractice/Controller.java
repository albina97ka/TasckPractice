package com.example.tasckpractice;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button applicationButton;
    @FXML
    private Button adminButton;
    @FXML
    private TextField UserLogin;
    @FXML
    private PasswordField UserPass;

    @FXML
    void initialize() {
        applicationButton.setOnAction(event -> {
            applicationButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sample.fxml"));
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

        adminButton.setOnAction(event -> {
            String loginText = UserLogin.getText().trim();
            String loginPass = UserPass.getText().trim();
            if (!loginText.equals("") && !loginPass.equals("")) {
                try {
                    loginUser(loginText, loginPass);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                adminButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Проверьте корректность данных.");
                        alert.showAndWait();
                    }
                });
            }
        });
    }

    private void loginUser(String loginText, String loginPass) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLocation(loginText);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) {
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ++counter;
        }
        if (counter >= 1) {
            adminButton.setOnAction(event -> {
                adminButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("admin.fxml"));
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
        } else {
            Shake userLoginAnim = new Shake(this.UserLogin);
            Shake userPassAnim = new Shake(this.UserPass);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
}
