package shuman.lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainController {
    @FXML private Button btn;
    @FXML private CheckBox sign1;
    @FXML private CheckBox sign2;
    @FXML private CheckBox sign3;
    @FXML private CheckBox sign4;
    @FXML private CheckBox sign5;
    @FXML private Label resultLabel;
    @FXML private ComboBox<String> comboBox;

    @FXML
    void initialize() {
        resultLabel.setText("");
        comboBox.getItems().add(0, "Расстояние");
        comboBox.getItems().add(1, "Функция сходства Рассела и Рао");
        comboBox.getItems().add(2, "Функция сходства Жокара и Нидмена");
        comboBox.getItems().add(3, "Функция сходства Дайса");
        comboBox.getItems().add(4, "Функция сходства Сокаля и Снифа");
        comboBox.getItems().add(5, "Функция сходства Сокаля и Мишнера");
        comboBox.getItems().add(6, "Функция сходства Кульжинского");
        comboBox.getItems().add(7, "Функция сходства Юла");
        comboBox.getSelectionModel().select(0);
        btn.setOnAction(actionEvent -> {
            int[] input = new int[5];
            if(sign1.isSelected()) { input[0] = 1; } else { input[0] = 0; }
            if(sign2.isSelected()) { input[1] = 1; } else { input[1] = 0; }
            if(sign3.isSelected()) { input[2] = 1; } else { input[2] = 0; }
            if(sign4.isSelected()) { input[3] = 1; } else { input[3] = 0; }
            if(sign5.isSelected()) { input[4] = 1; } else { input[4] = 0; }

            if (comboBox.getSelectionModel().getSelectedIndex() == 0) {
                String result = "";
                for (int i = 0; i < Approach.approaches.length; i++) {
                    result += Approach.approaches[i].name + ": " + Approach.getDistance(input, Approach.approaches[i]) + "\n";
                }
                resultLabel.setText(result);
            } else {
                String result = "";
                double max = 0;
                int maxIndex = 0;
                for (int i = 0; i < Approach.approaches.length; i++) {
                    if (Approach.getSimilarity(input, Approach.approaches[i], comboBox.getSelectionModel().getSelectedIndex())>max) {
                        max = Approach.getSimilarity(input, Approach.approaches[i], comboBox.getSelectionModel().getSelectedIndex());
                        maxIndex = i;
                    }
                    result += Approach.approaches[i].name + ": " + Approach.getSimilarity(input, Approach.approaches[i], comboBox.getSelectionModel().getSelectedIndex()) + "\n";
                }
                if (!(Approach.getSimilarity(input, Approach.approaches[0], comboBox.getSelectionModel().getSelectedIndex()) >= -1 && Approach.getSimilarity(input, Approach.approaches[0], comboBox.getSelectionModel().getSelectedIndex()) <= 1)) {
                    result = "Для введенных данных сравнение невозможно!";
                } else {
                    result += "Наиболее подходящий эталон: " + Approach.approaches[maxIndex].name;
                }
                resultLabel.setText(result);
            }
        });
    }
}
