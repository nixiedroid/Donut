package com.nixiedroid.Donut.scene.solidOfRevolution;

import com.nixiedroid.Donut.render.*;

public abstract class Figure implements Scene {
    protected static final double TAU = 6.28f;  //aka 2*PI
    protected final Vector3 dot = new Vector3(0, 0, 0);
    protected final Vector3 dotNormal = new Vector3(0, 0, 0);
    protected Vector3 rotation = new Vector3(0, 0, 0);
    protected Vector3 rotationScale = new Vector3(0.02, 0, 0.02);
    protected LightSource lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();

    protected abstract double getAngleStep();

    public Figure setRotation(Vector3 rotation) {
        this.rotation = rotation;
        return this;
    }

    public Figure setRotationScale(Vector3 rotationScale) {
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
        double brightness = Vector3.dotProduct(lightSource.getCoords(), dotNormal);
        if (brightness > 1) brightness = 1;
        if (canvas.ifCoordsInBoundaries(xProjection, yProjection)
                && dot.z < canvas.getZBuffer()[yProjection][xProjection]
        ) {
            canvas.getZBuffer()[yProjection][xProjection] = dot.z;
            canvas.getFrameBuffer()[yProjection][xProjection] = (brightness>0)?brightness:0;
        }
    }
}
