package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.Angle;
import com.nixiedroid.Donut.render.LightSource;
import com.nixiedroid.Donut.render.figure.*;
import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Render;
import net.jafama.FastMath;

public class Main {

    public static void main(String[] args) {
        FastMath.initTables();
        Figure figure = new Donut();
        Coords rotationAdditivePerFrame = new Coords(Angle.rad(0.1),Angle.rad(0.1),Angle.rad(0.2));
        Coords SingleFrameRotation = new Coords(Angle.deg45,Angle.deg(30),0);
        LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();
        Render render = new Render.Builder()
                .withRotationScale(rotationAdditivePerFrame)
                .usingFigure(figure)
                .createWindow(120)
                .setLightSource(lightSource)
                .build();

        render.drawFrames(1000);
        //render.drawFrame();
        //render.drawFrame(SingleFrameRotation);
    }
}