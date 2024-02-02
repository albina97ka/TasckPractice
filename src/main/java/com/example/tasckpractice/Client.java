package com.example.tasckpractice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {

    @FXML
    private Button back;
    @FXML
    private Button button;
    @FXML
    private CheckBox check_dz;
    @FXML
    private CheckBox check_pt;
    @FXML
    private ComboBox<String> combobox_s;
    @FXML
    private ComboBox<String> combobox_work;
    @FXML
    private Label label;
    @FXML
    private RadioButton radio_b;
    @FXML
    private RadioButton radio_s;

    // Метод для расчета стоимости на основе выбранных параметров
    private void calculateCost() {
        double baseCost = 0; // Базовая стоимость работы

        // Увеличение или уменьшение стоимости в зависимости от выбранных параметров
        if (check_dz.isSelected()) {
            baseCost += 15000; // Увеличить стоимость
        }
        if (check_pt.isSelected()) {
            baseCost += 10000;
        }

        // Учитывание выбора радио кнопок
        if (radio_b.isSelected()) {
            baseCost += 40000; // Увеличить стоимость
        } else if (radio_s.isSelected()) {
            baseCost = 0; // Уменьшить стоимость
        }

        // Учитывание выбора из combobox
        String selectSize = combobox_work.getValue();
        if (selectSize != null) {
            switch (selectSize) {
                case "Жилой дом":
                    baseCost += 1500000;
                    break;
                case "Многоквартирный дом":
                    baseCost += 20000000;
                    break;
                case "Общественное здание":
                    baseCost += 15000000;
                    break;
                case "Ремонт":
                    baseCost += 200000;
                    break;
                case "Другое":
                    baseCost += 150000;
                    break;
            }
        }
            String selectedSize = combobox_s.getValue();
            if (selectedSize != null) {
                switch (selectedSize) {
                    case "Менее 10кв":
                        baseCost += 5000;
                        break;
                    case "10 - 40кв":
                        baseCost += 10000;
                        break;
                    case "40 - 100кв":
                        baseCost += 40000;
                        break;
                    case "100 - 250кв":
                        baseCost += 100000;
                        break;
                    case "250+кв":
                        baseCost += 400000;
                        break;
                }
            }

            // Отобразить стоимость в label
            label.setText("Стоимость работы от: " + baseCost + " руб.");
        }

        @FXML
        void initialize() {
            ObservableList<String> list = FXCollections.observableArrayList("Жилой дом", "Многоквартирный дом", "Общественное здание", "Ремонт", "Другое");
            combobox_work.setItems(list);

            ObservableList<String> s = FXCollections.observableArrayList("Менее 10кв", "10 - 40кв", "40 - 100кв", "100 - 250кв", "250+ кв");
            combobox_s.setItems(s);

            // Обработчик нажатия кнопки
            button.setOnAction(event -> {
                calculateCost(); // Вызов метода для расчета стоимости
            });
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
        }
    }
