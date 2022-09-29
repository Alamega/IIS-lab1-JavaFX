module shuman.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens shuman.lab1 to javafx.fxml;
    exports shuman.lab1;
}