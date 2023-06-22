package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Frame;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Circle extends Figure{
    float theta;

    @Override
    public Frame calculate(Frame frame, Coords rotation, Coords lightSource) {
        frame.emptyBuffers();
        for (theta = 0; TAU > theta; theta += 0.1) {
            int xProjection = frame.upscaleX(cos(theta));
            int yProjection = frame.upscaleY(sin(theta));
            frame.getXYBuffer()[yProjection][xProjection] = '*';
        }
        return frame;
    }
}
