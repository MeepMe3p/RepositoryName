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
        //CREATES FIRSTMAP AS A NODE TO BECOME THE PARENT
        MapHandler mapLoader = new FirstMap();
        Group node = mapLoader.loadMap("src/main/resources/textures/level2.tmx", 1440.0,512.0);
//      LOADS FXML TO BE PLACED AS A CHILD NODE OF NODE
        AnchorPane loader = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));

        node.getChildren().add(loader);
        Scene scene = new Scene(node);

//      FOR KEYHANDLING PURPOSES
        KeyInput.getInstance().inputScene(scene);

//      DISPLAYING STAGE
        stage.setTitle("Platform UWU");
        stage.setScene(scene);
        stage.show();
    }
}
