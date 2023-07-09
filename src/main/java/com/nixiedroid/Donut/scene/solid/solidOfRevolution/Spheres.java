package com.nixiedroid.Donut.scene.solid.solidOfRevolution;

import com.nixiedroid.Donut.render.FrameBuffer;
public class Spheres extends Figure{
    float theta,phi;

    @Override
    protected double getAngleStep() {
        return 0.01;
    }

    @Override
    public void calculateNextFrame(FrameBuffer frameBuffer) {
        frameBuffer.emptyFrameBuffer();
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
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                ;
                project(frameBuffer, lightSource);
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
                        .rotateX(rotation.x)
                 .rotateY(rotation.y)
                  .rotateZ(rotation.z)
                ;
                project(frameBuffer, lightSource);

            }
        }
        rotation.add(rotationScale);
    }
}
