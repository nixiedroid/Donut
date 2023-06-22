package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Frame;

public abstract class Figure {
    protected Coords coords = new Coords();
    protected Coords illumination = new Coords();

    protected static final double TAU = 6.28f;  //aka 2*PI

    //public abstract Frame calculate(Frame frame, final double xRot, final double yRot, final double zRot);
    public abstract Frame calculate(Frame frame, Coords rotation, Coords lightSource);

    public double upscaleToTau(double normalised) {
        return normalised * TAU;
    }

    public double dotProduct(Coords a, Coords b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
}
