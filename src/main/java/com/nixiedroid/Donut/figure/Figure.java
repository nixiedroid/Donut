package com.nixiedroid.Donut.figure;

import com.nixiedroid.Donut.render.Frame;
import com.nixiedroid.Donut.render.FrameBuffers;

public abstract class Figure {
    protected static final double TAU = 6.28f;  //aka 2*PI
    public abstract Frame calculate(Frame frame, final double xRot, final double yRot, final double zRot) ;
    public double upscaleToTau(double normalised) {
        return normalised*TAU;
    }
}
