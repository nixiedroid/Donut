package com.nixiedroid.Donut.figure;

import com.nixiedroid.Donut.render.Brightness;
import com.nixiedroid.Donut.render.Frame;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Donut extends Figure {
    public static final int BIG_RADIUS = 2;
    public static final int SMALL_RADIUS = 1;
    static float phi, theta;

    @Override
    public Frame calculate(Frame frame, double xRot, double yRot, double zRot) {
        frame.emptyBuffers();

        for (theta = 0; TAU > theta; theta += 0.07) {
            for (phi = 0; TAU > phi; phi += 0.02) {
                double sinPhi = sin(phi);
                double cosPhi = cos(phi);
                double sinTheta = sin(theta);
                double cosTheta = cos(theta);

                double sinXRot = sin(xRot);
                double cosXRot = cos(xRot);

                double cosZRot = cos(zRot);
                double sinZRot = sin(zRot);

                double h = cosTheta + Donut.BIG_RADIUS;
                double zPos = 1 / (sinPhi * h * sinXRot + sinTheta * cosXRot + 5);
                double t = sinPhi * h * cosXRot - sinTheta * sinXRot;
                //int xProjection = frame.upscaleX(zPos * (cosPhi * h * cosZRot - t * sinZRot));
                // int yProjection = frame.upscaleY(zPos * (cosPhi * h * sinZRot + t * cosZRot));
                int xProjection = (int) (40 + 30 * zPos * (cosPhi * h * cosZRot - t * sinZRot));
                int yProjection = (int) (12 + 15 * zPos * (cosPhi * h * sinZRot + t * cosZRot));
                double brightness = ((sinTheta * sinXRot - sinPhi * cosTheta * cosXRot) * cosZRot -
                        sinPhi * cosTheta * sinXRot -
                        sinTheta * cosXRot -
                        cosPhi * cosTheta * sinZRot);
                if (frame.ifCoordsInBoundaries(xProjection, yProjection) && zPos > frame.getZBuffer()[yProjection][xProjection]) {
                    frame.getZBuffer()[yProjection][xProjection] = zPos;
                    frame.getXYBuffer()[yProjection][xProjection] = Brightness.getBrightnessChar(brightness);
                }
            }
        }
        return frame;
    }
}
