package com.nixiedroid.Donut;


import com.nixiedroid.Donut.figure.Donut;
import com.nixiedroid.Donut.figure.Sphere;
import com.nixiedroid.Donut.render.Render;

public class Main {

    public static void main(String[] args) {
        Render render = new Render.Builder()
                .withRotationScale(0.08f,0f,0.02f)
                .usingFigure(new Sphere())
                .createWindow(80,22)
                .build();

       // render.drawFrames(20);
        //render.drawFrame(3.14/4,0.08,3.14/2);
       render.drawFrame();
    }
}