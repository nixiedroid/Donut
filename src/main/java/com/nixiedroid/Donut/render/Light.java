package com.nixiedroid.Donut.render;

public class Light {
    private final Coords lightSourceCoords;

    public Light(double x, double y, double z) {
        this.lightSourceCoords = new Coords(x, y, z);
    }
    public double getX(){
        return lightSourceCoords.x;
    }
    public double getY(){
        return lightSourceCoords.y;
    }
    public double getZ(){
        return lightSourceCoords.z;
    }
    public void set(double x, double y, double z) {
        this.lightSourceCoords.set(x, y, z);
    }
}
