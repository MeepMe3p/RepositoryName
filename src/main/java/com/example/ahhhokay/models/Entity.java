package com.example.ahhhokay.models;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Entity {

    Point2D position;
    float scale = 1;
    double width;
    double height;

    Image entityImage;
//constructor for creating an entity needs and image but i think BufferedImage or something if wid animations or file
    public Entity(Image entityImage) {
        this.entityImage = entityImage;
        this.width = entityImage.getWidth();
        this.height = entityImage.getHeight();
    }

//     --------------------------POSITIONAL---------------------------
//    FOR CHANGING POSITIONS USING POINT2D CUZ WHY NOT, CAN BE REFACTORED TO BE X Y
    public Point2D getDrawPosition() {
        return position;
    }

    public void setDrawPosition(float x, float y) {
        this.position = new Point2D(x, y);
    }


    public void move(Point2D vector) {
        this.position = this.position.add(vector);
    }


    public float getScale() {
        return scale;
    }



//     --------------------------IMAGE---------------------------
//   FOR IMAGE DETAILS PURPOSES
    public Image getImage() {
        return entityImage;
    }
    public double getWidth() {
        return this.width * getScale();
    }

    public double getHeight() {
        return this.height * getScale();
    }

//     --------------------------MOVEMENT---------------------------

//    private float MAX_SPEED = 5f;

    private Point2D currentLocation = new Point2D(0, 0);

//   CHARACTER MOVES EVERYTIME UPDATE IS CALLED IN GAMECONTROLLER
    public void update() {
        move(currentLocation);
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
