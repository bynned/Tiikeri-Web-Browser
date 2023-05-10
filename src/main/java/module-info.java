module com.example.tiikeri {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.tiikeri to javafx.fxml;
    exports com.example.tiikeri;
}