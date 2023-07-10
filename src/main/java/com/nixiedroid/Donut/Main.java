package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.*;
import com.nixiedroid.Donut.render.renderSurface.JComponentSurface;
import com.nixiedroid.Donut.scene.poligonal.Cube;
import com.nixiedroid.Donut.scene.poligonal.Donut;
import com.nixiedroid.Donut.scene.poligonal.Pyramid;
import net.jafama.FastMath;

import javax.swing.*;

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
        Runnable r = new Runnable() {
            public void run() {
                JComponentSurface lineComponent = new JComponentSurface(500,500);
                Camera camera = new Camera(new Vector3(0,0,-20),10,500,500,10);
//                lineComponent.drawObject(new Cube(new Vector3(0,0,0),20).rotateX(Angle.deg(20))
//                                .rotateY(Angle.deg(20)).rotateZ(Angle.deg(10)).move(-10,10,0)
//                        ,camera);
//                lineComponent.drawObject(new Pyramid(new Vector3(0,0,0),20)
//                                .rotateY(Angle.deg(20)).rotateZ(Angle.deg(30))
//                                .move(10,-20,0)
//                        ,camera);
                lineComponent.drawObject(
                        new Donut(new Vector3(0,0,0),
                                5,10,10,20)
                        ,camera);
                JOptionPane.showMessageDialog(null, lineComponent);
            }
        };
        SwingUtilities.invokeLater(r);


    }
}