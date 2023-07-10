package com.nixiedroid.Donut.render;

import net.jafama.FastMath;

public class Vector2D {
    public double x;
    public double y;
    private double sinA, cosA, tmp;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double dotProduct(Vector2D a, Vector2D b) {
        if (a == null || b == null) return 0;
        return a.x * b.x + a.y * b.y;
    }

    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D coords) {
        if (coords == null) return this;
        this.x = coords.x;
        this.y = coords.y;
        return this;
    }

    public Vector2D add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D add(double value) {
        return add(value, value);
    }


    public Vector2D add(Vector2D value) {
        if (value == null) return this;
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    public Vector2D substract(Vector2D value) {
        if (value == null) return this;
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    public Vector2D multiply(double value) {
        return multiply(value, value);
    }

    public Vector2D multiply(double x, double y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2D rotate(double angle) {
        sinA = FastMath.sinQuick(angle);
        cosA = FastMath.cosQuick(angle);
        tmp = y;
        x = x * cosA - y * sinA;
        y = x * sinA + y * cosA;
        return this;
    }


    public void normalise() {
        double magnitude = FastMath.invSqrtQuick(x * x + y * y);
        x *= magnitude;
        y *= magnitude;
    }

    public double dotProduct(Vector2D coords) {
        if (coords == null) return 0;
        return this.x * coords.x + this.y * coords.y;
    }
}
