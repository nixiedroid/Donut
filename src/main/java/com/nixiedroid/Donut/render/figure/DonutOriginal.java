package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.FrameBuffer;
import com.nixiedroid.Donut.render.LightSource;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

//That thing is broken. Do not use
@Deprecated
public class DonutOriginal extends Figure {
    @Override
    protected void calculateSingleFrame(FrameBuffer frameBuffer) {

    }

    static float phi, theta;

    @Override
    protected double getAngleStep() {
        return 0;
    }

    public void fillCanvas(FrameBuffer canvas, Coords rotation, LightSource lightSource) {
        canvas.emptyFrameBuffer();
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
                int xProjection = (int) canvas.projectX(oneOverZPos * (cosPhi * h * cosZRot - t * sinZRot),30);
                int yProjection = (int) canvas.projectY(oneOverZPos * (cosPhi * h * sinZRot + t * cosZRot),15);
                int brightness = (int) (8 * ((sinTheta * sinXRot - sinPhi * cosTheta * cosXRot) * cosZRot -
                        sinPhi * cosTheta * sinXRot -
                        sinTheta * cosXRot -
                        cosPhi * cosTheta * sinZRot));
                if (canvas.ifCoordsInBoundaries(xProjection, yProjection)
                      //  && oneOverZPos > canvas.getZBuffer()[yProjection][xProjection]
                ) {
                   // canvas.getZBuffer()[yProjection][xProjection] = oneOverZPos;
                 //   canvas.getXYBuffer()[yProjection][xProjection] =  Brightness.getPalette()[Math.max(brightness, 0)];;
                }
            }
        }
    }
}
