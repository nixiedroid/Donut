package com.nixiedroid.Donut.scene.solidOfRevolution;

import com.nixiedroid.Donut.render.FrameBuffer;

public class Snowman extends Figure{
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
                dot.set(0.1, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0,-0.5,0)
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
                dot.set(0.2, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0,-0.2,0)
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
                dot.set(0.3, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0,0.3,0)
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
                dot.set(0.03, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0,-0.5,-0.09)
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
                dot.set(0.01, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(0.02,-0.55,-0.1)
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
                dot.set(0.01, 0, 0)
                        .rotateZ(theta)
                        .rotateX(phi)
                        .add(-0.02,-0.55,-0.1)
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
