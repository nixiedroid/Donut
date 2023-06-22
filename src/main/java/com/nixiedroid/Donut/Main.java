package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.figure.*;
import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Render;

public class Main {

    public static void main(String[] args) {
        Coords rotationScale = new Coords(0.1,0,0.0f);
        Coords SingleFrameRotation = new Coords(-0.1f,-0.1f,0.0f);
        Render render = new Render.Builder()
                .withRotationScale(rotationScale)
                .usingFigure(new DonutOriginal())
                .createWindow(60,22)
                .setLightSource(new Coords(0,-1,-1))
                .build();

        render.drawFrames(100);
        //render.drawFrame();
        //render.drawFrame(rotation);
    }
}