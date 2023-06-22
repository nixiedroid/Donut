package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Brightness;
import com.nixiedroid.Donut.render.Frame;

public class Donut extends Figure {
    float theta, phi;

    @Override
    public Frame calculate(Frame frame, Coords rotation, Coords lightSource) {
        frame.emptyBuffers();
        for (theta = 0; TAU > theta; theta += 0.1) {
            for (phi = 0; TAU > phi; phi += 0.1) {
                coords.set(0.5, 0, 0)
                        .rotateY(theta)
                        .add(1, 0, 0)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                        .add(0, 0, -1);
                illumination.set(1, 0, 0)
                        .rotateY(theta)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z);
                double brightness = dotProduct(lightSource, illumination);
                int xProjection = frame.upscaleX(coords.x);
                int yProjection = frame.upscaleY(coords.y);
                double oneOverZPos = 1 / coords.z;
                if (frame.ifCoordsInBoundaries(xProjection, yProjection)
                        &&
                        oneOverZPos > frame.getZBuffer()[yProjection][xProjection]) {
                    frame.getZBuffer()[yProjection][xProjection] = oneOverZPos;
                    frame.getXYBuffer()[yProjection][xProjection] = Brightness.getBrightnessCharV2((int) (brightness * 8));
                }
            }
        }
        return frame;
    }
}
