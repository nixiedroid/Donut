package com.nixiedroid.Donut.render;

import static java.lang.Float.NaN;

public class Camera {
    public Pivot center;
    public float screenDist;
    public int screenHeight, screenWidth;
    public double observeRange;
    public double scale;

    public Camera(Vector3 center, float screenDist, int screenHeight, int screenWidth, float observeRange) {
        this.center = new Pivot(center);
        this.observeRange = observeRange;
        this.screenDist = screenDist;
        this.screenHeight = screenHeight;
        scale = screenWidth / (2 * screenDist * Math.tan(observeRange / 2));
        this.screenWidth = screenWidth;
    }

    public void move(Vector3 v) {
        center.move(v);
    }

    public Camera rotateX(double angle) {
        center.rotateX(angle);
        return this;
    }

    public Camera rotateY(double angle) {
        center.rotateY(angle);
        return this;
    }

    public Camera rotateZ(double angle) {
        center.rotateZ(angle);
        return this;
    }



    public Vector2D screenProjection(Vector3 v) {
       Vector3 local = center.toLocalCoords(v);

//        if (local.z < screenDist) {
//            return new Vector2D(NaN, NaN);
//        }

        Vector2D projection = new Vector2D(local.x, local.y).multiply(scale);

//        double delta = screenDist / local.z*scale;
//        Vector2D projection = new Vector2D(local.x, local.y).multiply(delta);

        Vector2D screen = projection.add((double) screenWidth / 2, (double) -screenHeight / 2);
        Vector2D screenCoords = new Vector2D(screen.x, -screen.y);

        if (screenCoords.x >= 0 && screenCoords.x < screenWidth && screenCoords.y >= 0 && screenCoords.y < screenHeight) {
            return screenCoords;
        }
        return new Vector2D(NaN, NaN);
    }
}