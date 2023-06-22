package com.nixiedroid.Donut.render.figure;

import com.nixiedroid.Donut.render.Brightness;
import com.nixiedroid.Donut.render.Coords;
import com.nixiedroid.Donut.render.Canvas;
import com.nixiedroid.Donut.render.LightSource;

public abstract class Figure {
    protected final Coords dot = new Coords(0,0,0);
    protected final Coords dotNormal = new Coords(0,0,0);
    protected static final double TAU = 6.28f;  //aka 2*PI
    protected abstract double getAngleStep();
    public abstract void fillCanvas(Canvas canvas, Coords rotation, LightSource lightSource);
    private double dotProduct(Coords a, Coords b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    protected void project(Canvas canvas, LightSource lightSource){
        int xProjection = canvas.projectX(dot.x);
        int yProjection = canvas.projectY(dot.y);
        double brightness = dotProduct(lightSource.getCoords(), dotNormal);
        if (brightness>1) brightness=1;
        if (canvas.ifCoordsInBoundaries(xProjection, yProjection)
                && dot.z < canvas.getZBuffer()[yProjection][xProjection]
        ) {
            canvas.getZBuffer()[yProjection][xProjection] = dot.z;
            canvas.getXYBuffer()[yProjection][xProjection] = Brightness.getBrightnessChar(brightness);
        }
    }
}
