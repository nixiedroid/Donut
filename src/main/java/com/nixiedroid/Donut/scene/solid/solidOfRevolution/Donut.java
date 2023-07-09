package com.nixiedroid.Donut.scene.solid.solidOfRevolution;

import com.nixiedroid.Donut.render.FrameBuffer;

public class Donut extends Figure {
    float theta, phi;

    @Override
    protected double getAngleStep() {
        return 0.005;
    }

    @Override
    public void calculateNextFrame(FrameBuffer canvas) {
        canvas.emptyFrameBuffer();
        for (theta = 0; TAU > theta; theta += getAngleStep()*2) {
            for (phi = 0; TAU > phi; phi += getAngleStep()) {
                dot.set(0.3, 0, 0)
                        .rotateY(theta)
                        .add(0.5, 0, 0)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                ;
                dotNormal.set(1, 0, 0)
                        .rotateY(theta)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                ;
                //dotNormal.set(dot).normalise();
                project(canvas, lightSource);

            }
        }
        rotation.add(rotationScale);
    }
}
