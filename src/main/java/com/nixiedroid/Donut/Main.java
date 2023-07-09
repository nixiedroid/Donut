package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.*;
import com.nixiedroid.Donut.render.LightSource;
import com.nixiedroid.Donut.render.renderSurface.ImageSurface;
import com.nixiedroid.Donut.scene.solid.solidOfRevolution.*;
import net.jafama.FastMath;

public class Main {

    public static void main(String[] args) {
        FastMath.initTables();
        LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();
        Figure spheres = new Snowman()
                .setLightSource(lightSource)
                .setRotation(new Coords(Angle.deg45,Angle.deg45,0))
                ;

        Render render = new Render.Builder()
                .usingSurface(new ImageSurface(1000,1000))
                .usingScene(spheres)
                .build();

        render.drawFrame();

    }
}