package com.example.ahhhokay.controls;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;
//  FOR KEYBOARD HANDLING
public class KeyInput {

    private static Scene scene;
    private static final Set<KeyCode> keysCurrentlyDown = new HashSet<>();

    private KeyInput() {
    }

    public static KeyInput getInstance() {
        return new KeyInput();
    }

    public void inputScene(Scene scene) {
        clearKeys();
        removeCurrentKeyHandlers();
        setScene(scene);
    }

    private void clearKeys() {
        keysCurrentlyDown.clear();
    }

    private void removeCurrentKeyHandlers() {
        if (scene != null) {
            KeyInput.scene.setOnKeyPressed(null);
            KeyInput.scene.setOnKeyReleased(null);
        }
    }

    private void setScene(Scene scene) {
        KeyInput.scene = scene;
        KeyInput.scene.setOnKeyPressed((keyEvent -> {
            keysCurrentlyDown.add(keyEvent.getCode());
        }));
        KeyInput.scene.setOnKeyReleased((keyEvent -> {
            keysCurrentlyDown.remove(keyEvent.getCode());
        }));
    }

    public boolean isDown(KeyCode keyCode) {
        return keysCurrentlyDown.contains(keyCode);
    }


}
