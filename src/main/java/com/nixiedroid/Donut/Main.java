package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.math.Angle;
import com.nixiedroid.Donut.render.math.Vector3;
import com.nixiedroid.Donut.render.polygonal.Camera;
import com.nixiedroid.Donut.render.polygonal.PolygonalScene;
import com.nixiedroid.Donut.render.polygonal.Primitive;
import com.nixiedroid.Donut.render.renderSurface.vectorSurface.JComponentSurfaceStub;
import com.nixiedroid.Donut.scene.polygonal.Cube;
import net.jafama.FastMath;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FastMath.initTables();
//        LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();
//        Figure spheres = new Snowman()
//                .setLightSource(lightSource)
//                .setRotation(new Vector3(Angle.deg45,Angle.deg45,0))
//                ;
//
//        Render render = new Render.Builder()
//                .usingSurface(new ImageSurface(1000,1000))
//                .usingScene(spheres)
//                .build();
//
//        render.drawFrame();
        ArrayList<Line2D.Double> lines = new ArrayList<>();
        JComponentSurfaceStub surface = new JComponentSurfaceStub(500, 500);
        PolygonalScene scene = new PolygonalScene(lines);
        Camera camera = new Camera(new Vector3(0, 0, -20), 500, 500, 50, -10);
        Primitive primitive = new Cube(new Vector3(0, 0, 0), 15).rotateX(Angle.deg(45))
                .rotateZ(Angle.deg(45));
        scene.drawObject(primitive, camera);
        primitive = new Cube(new Vector3(-5, 0, 0), 5).rotateX(Angle.deg(20))
                .rotateY(Angle.deg(45)).rotateZ(Angle.deg(45)).move(0, -10, 0);
        scene.drawObject(primitive, camera);
        primitive = new Cube(new Vector3(8, 0, 0), 5).rotateX(Angle.deg(20))
                .rotateY(Angle.deg(-45)).rotateZ(Angle.deg(-45)).move(0, 20, 0);
        scene.drawObject(primitive, camera);
        surface.drawVector(lines);
    }
}