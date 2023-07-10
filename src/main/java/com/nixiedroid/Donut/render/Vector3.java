package com.nixiedroid.Donut.render;

import net.jafama.FastMath;

public class Vector3 implements Cloneable{
    public double x;
    public double y;
    public double z;
    private double sinA, cosA, tmp;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vector3 set(Vector3 coords) {
        if (coords == null) return this;
        this.x = coords.x;
        this.y = coords.y;
        this.z = coords.z;
        return this;
    }

    public Vector3 add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector3 add(double value) {
        return add(value, value, value);
    }

    public Vector3 add(Vector3 value) {
        if (value == null) return this;
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }
    public Vector3 substract(Vector3 value) {
        if (value == null) return this;
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    public Vector3 multiply(double value) {
        return multiply(value, value, value);
    }

    public Vector3 multiply(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vector3 rotateX(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        tmp = y;
        y = z * sinA + y * cosA;
        z = -(tmp * sinA) + z * cosA;
        return this;
    }

    public Vector3 rotateY(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        tmp = z;
        z = x * sinA + z * cosA;
        x = -(tmp * sinA) + x * cosA;
        return this;
    }

    public Vector3 rotateZ(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        tmp = x;
        x = y * sinA + x * cosA;
        y = -(tmp * sinA) + y * cosA;
        return this;
    }
    public Vector3 clone() {
        try {
            return (Vector3) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void normalise() {
        double magnitude = FastMath.invSqrtQuick(x * x + y * y + z * z);
        x *= magnitude;
        y *= magnitude;
        z *= magnitude;
    }

    public double dotProduct(Vector3 coords) {
        if (coords == null) return 0;
        return this.x * coords.x + this.y * coords.y + this.z * coords.z;
    }

    @Override
    public String toString() {
        return "Vector3 \n[ " +
                x +
                ", " + y +
                ", " + z +
                " ]";
    }
    public static Vector3 substract(Vector3 a, Vector3 b){
        return new Vector3(a.x-b.x,a.y-b.y,a.z-b.z);
    }
    public static Vector3 add(Vector3 a, Vector3 b){
        return new Vector3(a.x+b.x,a.y+b.y,a.z+b.z);
    }
    public static Vector3 multiply(Vector3 a, Vector3 b){
        return new Vector3(a.x*b.x,a.y*b.y,a.z*b.z);
    }
    public static Vector3 add(Vector3 a, double value){
        return new Vector3(a.x+value,a.y+value,a.z+value);
    }
    public static Vector3 multiply(Vector3 a, double value){
        return new Vector3(a.x*value,a.y*value,a.z*value);
    }
    public static double dotProduct(Vector3 a, Vector3 b) {
        if (a == null || b == null) return 0;
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    public static final Vector3 UNIT_X = new Vector3(1,0,0);
    public static final Vector3 UNIT_Y = new Vector3(0,1,0);
    public static final Vector3 UNIT_Z = new Vector3(0,0,1);
}
