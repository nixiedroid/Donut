package com.nixiedroid.Donut.figure;

import com.nixiedroid.Donut.render.Frame;
import com.nixiedroid.Donut.render.Rotation;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Sphere extends Figure{
    float theta, phi;
    @Override
    public Frame calculate(Frame frame, double xRot, double yRot, double zRot) {
        frame.emptyBuffers();
        Rotation rotation = new Rotation();
        for (theta = 0; TAU > theta; theta += 0.1) {
            for (phi = 0; TAU > phi; phi += 0.1) {
                rotation.setAngles(theta, phi,0);
                rotation.rotate(1,0,1);
                int xProjection = frame.upscaleX(rotation.xDstPos/2);
                int yProjection = frame.upscaleY(rotation.zDstPos/2);
                frame.getXYBuffer()[yProjection][xProjection] = '#';
            }
        }
        return frame;
    }
}
