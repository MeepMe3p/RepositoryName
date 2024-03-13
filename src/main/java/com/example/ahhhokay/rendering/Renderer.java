package com.example.ahhhokay.rendering;


import com.example.ahhhokay.models.Entity;
import com.example.ahhhokay.models.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    Canvas canvas;
    GraphicsContext context;

    Image background;

    List<Player> entities = new ArrayList<>();

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void addEntity(Player entity) {
        entities.add(entity);
    }


    public void setBackground(Image background) {
        this.background = background;
    }

    public void render() {
//        context.save();

        //CLEARS EVERYTME IT RENDERS TO MAKE TRAILING DISAPPEAR
        context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
//        if(background!=null){
//            context.drawImage(background, 0, 0);
//        }


        for (Entity entity : entities) {
            Point2D pos = entity.getDrawPosition();
            context.drawImage(
                    entity.getImage(),
                    pos.getX(),
                    pos.getY(),
                    entity.getWidth(),
                    entity.getHeight()
            );
        }
//        System.out.println("aaaaaaaaaaaaaaaaaaaaa");

//        context.restore();
    }





}

