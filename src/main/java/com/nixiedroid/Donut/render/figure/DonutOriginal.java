package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Brightness;
import com.nixiedroid.Donut.render.Frame;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class DonutOriginal extends Figure {

    static float phi, theta;

    @Override
    public Frame calculate(Frame frame, Coords rotation, Coords lightSource) {
        frame.emptyBuffers(' ',0);
        for (theta = 0; TAU > theta; theta += 0.07) {
            for (phi = 0; TAU > phi; phi += 0.02) {
                double sinPhi = sin(phi);
                double cosPhi = cos(phi);

                double sinTheta = sin(theta);
                double cosTheta = cos(theta);

                double sinXRot = sin(rotation.x);
                double cosXRot = cos(rotation.x);

                double cosZRot = cos(rotation.z);
                double sinZRot = sin(rotation.z);

                double h = cosTheta + 2;
                double oneOverZPos = 1 / (sinPhi * h * sinXRot + sinTheta * cosXRot + 5);
                double t = sinPhi * h * cosXRot - sinTheta * sinXRot;
                int xProjection = (int) frame.projectX(oneOverZPos * (cosPhi * h * cosZRot - t * sinZRot),30);
                int yProjection = (int) frame.projectY(oneOverZPos * (cosPhi * h * sinZRot + t * cosZRot),15);
                int brightness = (int) (8 * ((sinTheta * sinXRot - sinPhi * cosTheta * cosXRot) * cosZRot -
                        sinPhi * cosTheta * sinXRot -
                        sinTheta * cosXRot -
                        cosPhi * cosTheta * sinZRot));
                if (frame.ifCoordsInBoundaries(xProjection, yProjection)
                        && oneOverZPos > frame.getZBuffer()[yProjection][xProjection]
                ) {
                    frame.getZBuffer()[yProjection][xProjection] = oneOverZPos;
                    frame.getXYBuffer()[yProjection][xProjection] =  Brightness.palette[Math.max(brightness, 0)];;
                }
            }
        }
        return frame;
    }
}
