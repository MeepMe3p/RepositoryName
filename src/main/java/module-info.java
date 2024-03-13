module com.example.ahhhokay {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.xml;

    opens com.example.ahhhokay.controllers to javafx.fxml;
    exports com.example.ahhhokay;
}