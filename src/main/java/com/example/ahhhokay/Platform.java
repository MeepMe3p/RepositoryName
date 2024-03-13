package com.example.ahhhokay;


import com.example.ahhhokay.controls.KeyInput;
import com.example.ahhhokay.mapStuff.FirstMap;
import com.example.ahhhokay.mapStuff.MapHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Platform extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MapHandler mapLoader = new FirstMap();
        Group node = mapLoader.loadMap("src/main/resources/textures/level2.tmx", 1440.0,512.0);
//        node.getChildren().add();
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
        AnchorPane loader = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));

        node.getChildren().add(loader);
        Scene scene = new Scene(node);
//
        KeyInput.getInstance().inputScene(scene);
//
//        stage.setScene(scene);



//        Node uwu = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
//        root.getChildren().add(uwu);
//        Scene scene1 = new Scene(root,720*2,128*4, Color.RED);


        stage.setScene(scene);
//        stage.set
        stage.show();
    }
}
