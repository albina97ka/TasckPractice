package com.example.tasckpractice;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            String loginPass = hashString(UserPass.getText().trim()); // хеширование пароля
            loginUser(loginText, loginPass);
        });
    }

    private void loginUser(String loginText, String loginPass) {
        String url = "jdbc:mysql://localhost:3306/author?useSSL=true&requireSSL=true&verifyServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(url, "admin", "12345")) {
            String query = "SELECT login, password, isAdmin FROM userdata WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, loginText);
            statement.setString(2, loginPass);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    boolean isAdmin = result.getBoolean("isAdmin");
                    if (isAdmin) {
                        // Перенаправление на окно администратора
                        adminButton.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("admin.fxml"));
                        loader.load();

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    } else {
                        // Перенаправление на окно клиента
                        adminButton.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("client.fxml"));
                        loader.load();

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                } else {
                    Shake userLoginAnim = new Shake(this.UserLogin);
                    Shake userPassAnim = new Shake(this.UserPass);
                    userLoginAnim.playAnim();
                    userPassAnim.playAnim();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace(); // замените этот код на обработку исключения по вашим потребностям
        }
    }

    private String hashString(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte a : hashBytes) {
                String hex = Integer.toHexString(0xff & a);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
