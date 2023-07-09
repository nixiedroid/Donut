package com.nixiedroid.Donut.scene.solid.solidOfRevolution;

import com.nixiedroid.Donut.render.FrameBuffer;

public class Circle extends Figure{
    float theta;
    @Override
    protected double getAngleStep() {
        return 0.2;
    }

    @Override
    public void calculateNextFrame(FrameBuffer canvas) {
        canvas.emptyFrameBuffer();
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
        rotation.add(rotationScale);
    }
}
