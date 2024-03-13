package com.example.ahhhokay.mapStuff;

import javafx.scene.Group;
//  MADE THIS AN INTERFACE CUZ MY ORIGINAL PLAN WAS TO HAVE DIFFERENT MAPS SO YEA THEY HAVE DIFFERENT IMPLEMNETAIONS
public interface MapHandler {
    Group loadMap(String filePath, double sceneWidth,double sceneHeight);
}
