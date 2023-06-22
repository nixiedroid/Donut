package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Brightness;
import com.nixiedroid.Donut.render.Frame;

public class Donut extends Figure {
    float theta, phi;

    @Override
    public Frame calculate(Frame frame, Coords rotation, Coords lightSource) {
        frame.emptyBuffers();
        for (theta = 0; TAU > theta; theta += 0.01) {
            for (phi = 0; TAU > phi; phi += 0.01) {
                coords.set(0.1, 0, 0)
                        .rotateY(theta)
                        .add(0.2, 0, 0)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                        .add(0, 0, 0.35)
                        .normaliseVector()
                ;
                illumination.set(1, 0, 0)
                        .rotateY(theta)
                        .rotateZ(phi)
                        .rotateX(rotation.x)
                        .rotateY(rotation.y)
                        .rotateZ(rotation.z)
                        //.normaliseVector()
                ;
                int xProjection = frame.projectX(coords.x,25);
                int yProjection = frame.projectY(coords.y,10);
               // double oneOverZPos = 1 / coords.z;
                double brightness = dotProduct(lightSource, illumination);
                if (frame.ifCoordsInBoundaries(xProjection, yProjection)
                        && coords.z < frame.getZBuffer()[yProjection][xProjection]
                ) {
                    frame.getZBuffer()[yProjection][xProjection] = coords.z;
                    frame.getXYBuffer()[yProjection][xProjection] = Brightness.getBrightnessChar(brightness);
                }
            }
        }
        return frame;
    }
}
