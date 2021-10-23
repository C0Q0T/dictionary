module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires freetts;

    opens main to javafx.fxml;
    exports main;
}