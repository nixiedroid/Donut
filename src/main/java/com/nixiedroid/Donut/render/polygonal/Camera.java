package com.nixiedroid.Donut.render.polygonal;

import com.nixiedroid.Donut.render.math.Vector2;
import com.nixiedroid.Donut.render.math.Vector3;
import com.nixiedroid.Donut.render.enums.ProjectionType;

import static java.lang.Float.NaN;

public class Camera {
    public Pivot center;
    public float screenDist;
    public int screenHeight, screenWidth;
    public double observeRange;
    public double scale;
    ProjectionType projectionType;

    public Camera(Vector3 center, int screenHeight, int screenWidth, float observeRange, float screenDist, ProjectionType projectionType) {
        this.center = new Pivot(center);
        this.observeRange = observeRange;
        this.screenDist = screenDist;
        this.screenHeight = screenHeight;
        //scale = screenWidth / (2 * screenDist * Math.tan(observeRange / 2));
        scale = screenWidth / observeRange;
        this.screenWidth = screenWidth;
        this.projectionType = projectionType;
    }
    public Camera(Vector3 center, int screenHeight, int screenWidth, float observeRange,float screenDist) {
        this(center,screenHeight,screenWidth,observeRange,screenDist, ProjectionType.PARALLEL);
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


    Vector2 projection;
    public Vector2 screenProjection(Vector3 v) {
       Vector3 local = center.toLocalCoords(v);
        double delta;
        if (local.z < screenDist) {
            return new Vector2(NaN, NaN);
        }
        switch (projectionType){
            case PARALLEL:
                projection  = new Vector2(local.x, local.y).multiply(scale);
                break;
            case PERSPECTIVE:
                delta = screenDist / local.z*scale;
                projection = new Vector2(local.x, local.y).multiply(delta);
                break;
        }

        Vector2 screen = projection.add((double) screenWidth / 2, (double) -screenHeight / 2);
        Vector2 screenCoords = new Vector2(screen.x, -screen.y);

        if (screenCoords.x >= 0 && screenCoords.x < screenWidth && screenCoords.y >= 0 && screenCoords.y < screenHeight) {
            return screenCoords;
        }
        return new Vector2(NaN, NaN);
    }
}