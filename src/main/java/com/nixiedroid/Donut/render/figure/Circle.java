package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Canvas;
import com.nixiedroid.Donut.render.LightSource;

public class Circle extends Figure{
    float theta;

    @Override
    protected double getAngleStep() {
        return 0.2;
    }

    @Override
    public void fillCanvas(Canvas canvas, Coords rotation, LightSource lightSource) {
        canvas.emptyBuffers();
        for (theta = 0; TAU > theta; theta += getAngleStep()) {
            dot.set(0.8, 0, 0)
                    .rotateZ(theta)
                    .rotateX(rotation.x)
                    .rotateY(rotation.y)
                    .rotateZ(rotation.z)
            ;
            dotNormal.set(1, 0, 0)
                    .rotateZ(theta)
                    .rotateX(rotation.x)
                    .rotateY(rotation.y)
                    .rotateZ(rotation.z)
            ;
            project(canvas,lightSource);
        }
    }
}
