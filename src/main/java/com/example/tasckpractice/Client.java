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
    private CheckBox check_r;
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

        // Увеличение стоимости на основе выбранных флажков
        if (check_dz.isSelected()) {
            baseCost += 25000;
        }
        if (check_pt.isSelected()) {
            baseCost += 80000;
        }
        if (check_r.isSelected()) {
            baseCost += 150000;
        }

        // Учитывание выбора радио кнопок
        if (radio_s.isSelected()) {
            baseCost += 450000;
        } else if (radio_b.isSelected()) {
            baseCost += 0;
        }

        // Учитывание выбора из combobox
        String selectSize = combobox_work.getValue();
        if (selectSize != null) {
            switch (selectSize) {
                case "Жилой дом":
                    baseCost += 1500000;
                    break;
                case "Многоквартирный дом":
                    baseCost += 150000000;
                    break;
                case "Общественное здание":
                    baseCost += 20000000;
                    break;
                case "Другое":
                    baseCost += 50000;
                    break;
            }
        }
            String selectedSize = combobox_s.getValue();
            if (selectedSize != null) {
                switch (selectedSize) {
                    case "Менее 10кв":
                        baseCost += 50000;
                        break;
                    case "10 - 40кв":
                        baseCost += 250000;
                        break;
                    case "40 - 100кв":
                        baseCost += 500000;
                        break;
                    case "100 - 250кв":
                        baseCost += 1000000;
                        break;
                    case "250+кв":
                        baseCost += 4000000;
                        break;
                }
            }

            // Отобразить стоимость в label
            label.setText("Стоимость работы от: " + baseCost + " руб");
        }

        @FXML
        void initialize() {
            ObservableList<String> list = FXCollections.observableArrayList("Жилой дом", "Многоквартирный дом", "Общественное здание", "Другое");
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
