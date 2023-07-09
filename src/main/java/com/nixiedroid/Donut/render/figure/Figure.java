package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.*;

public abstract class Figure extends Scene {
    protected static final double TAU = 6.28f;  //aka 2*PI
    protected final Coords dot = new Coords(0, 0, 0);
    protected final Coords dotNormal = new Coords(0, 0, 0);
    protected Coords rotation = new Coords(0, 0, 0);
    protected Coords rotationScale = new Coords(0.02, 0, 0.02);
    protected LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();

    protected abstract double getAngleStep();

    @Override
    public void calculate(FrameBuffer frameBuffer) {
        calculateSingleFrame(frameBuffer);
        rotation.add(rotationScale);
    }

    public Figure setRotation(Coords rotation) {
        this.rotation = rotation;
        return this;
    }

    public Figure setRotationScale(Coords rotationScale) {
        this.rotationScale = rotationScale;
        return this;
    }
    public Figure setLightSource(LightSource lightSource) {
        this.lightSource = lightSource;
        return this;
    }

    protected void project(FrameBuffer canvas, LightSource lightSource) {
        int xProjection = canvas.projectX(dot.x);
        int yProjection = canvas.projectY(dot.y);
        double brightness = CMath.dotProduct(lightSource.getCoords(), dotNormal);
        if (brightness > 1) brightness = 1;
        if (canvas.ifCoordsInBoundaries(xProjection, yProjection)
                && dot.z < canvas.getZBuffer()[yProjection][xProjection]
        ) {
            canvas.getZBuffer()[yProjection][xProjection] = dot.z;
            canvas.getFrameBuffer()[yProjection][xProjection] = brightness;
        }
    }
}
