package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Canvas;
import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.LightSource;

public class Spheres extends Figure{
    float theta,phi;

    @Override
    protected double getAngleStep() {
        return 0.01;
    }

    @Override
    public void fillCanvas(Canvas canvas, Coords rotation, LightSource lightSource) {
        canvas.emptyBuffers();
        for (theta = 0; TAU > theta; theta += getAngleStep()) {
            for (phi = 0; TAU > phi; phi += getAngleStep()) {
                dot.set(0.2, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0.3,0,0)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                ;
                dotNormal.set(1, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0.3,0,0)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                        .normalise()
                ;
                project(canvas, lightSource);
                dot.set(0.4, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(-0.5,0,0)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                ;
                dotNormal.set(1, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(-0.5,0,0)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                        .normalise()
                ;
                project(canvas, lightSource);
            }
        }
    }
}
