package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.*;
import com.nixiedroid.Donut.render.figure.*;
import com.nixiedroid.Donut.render.renderSurface.TerminalSurface;
import net.jafama.FastMath;

public class Main {

    public static void main(String[] args) {
        FastMath.initTables();
        LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();
        Scene scene = new Spheres()
                .setRotationScale(new Coords(Angle.rad(0.05),Angle.rad(0.05),Angle.rad(0.01)))
                .setLightSource(lightSource);
        Coords SingleFrameRotation = new Coords(Angle.deg45,Angle.deg(30),0);

        Render render = new Render.Builder()
                .usingSurface(new TerminalSurface(150))
                .usingScene(scene)
                .build();



        render.drawFrames(1000);
        //render.drawFrame();
        //render.drawFrame(SingleFrameRotation);

    }
}