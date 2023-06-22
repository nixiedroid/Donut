package com.nixiedroid.Donut.render;

import net.jafama.FastMath;

public class Coords {
    public double x;
    public double y;
    public double z;
    private double sinA, cosA;
    //private DoubleWrapper cosA = new DoubleWrapper();

    public Coords(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coords set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }
    public Coords set(Coords coords) {
        this.x = coords.x;
        this.y = coords.y;
        this.z = coords.z;
        return this;
    }

    public Coords add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Coords add(double value) {
        return add(value,value,value);
    }

    public Coords add(Coords value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }
    public Coords mult(double value) {
        return mult(value,value,value);
    }
    public Coords mult(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }
    public Coords rotateX(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        double tmpY = y;
        y = z * sinA + y * cosA;
        z = -(tmpY * sinA) + z * cosA;
        return this;
    }
    public Coords rotateY(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        double tmpZ = z;
        z = x * sinA + z * cosA;
        x = -(tmpZ * sinA) + x * cosA;
        return this;
    }
    public Coords rotateZ(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        double tmpX = x;
        x = y * sinA + x * cosA;
        y = -(tmpX * sinA) + y * cosA;
        return this;
    }
    public double getMagnitude(){
        return FastMath.invSqrtQuick(x * x + y * y + z * z);
    }
    public Coords normalise() {
        double magnitude = getMagnitude();
       // double magnitude = invSqrt(x * x + y * y + z * z);
        x *= magnitude;
        y *= magnitude;
        z *= magnitude;
        return this;
    }

}
