package com.nixiedroid.Donut.render.math;

import net.jafama.FastMath;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double dotProduct(Vector2 a, Vector2 b) {
        if (a == null || b == null) return 0;
        return a.x * b.x + a.y * b.y;
    }

    public Vector2 set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2 set(Vector2 coords) {
        if (coords == null) return this;
        this.x = coords.x;
        this.y = coords.y;
        return this;
    }

    public Vector2 add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2 add(double value) {
        return add(value, value);
    }


    public Vector2 add(Vector2 value) {
        if (value == null) return this;
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    public Vector2 substract(Vector2 value) {
        if (value == null) return this;
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    public Vector2 multiply(double value) {
        return multiply(value, value);
    }

    public Vector2 multiply(double x, double y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2 rotate(double angle) {
        double sinA = FastMath.sinQuick(angle);
        double cosA = FastMath.cosQuick(angle);
        double tmp = x;
        x = x * cosA - y * sinA;
        y = tmp * sinA + y * cosA;
        return this;
    }


    public void normalise() {
        double magnitude = FastMath.invSqrtQuick(x * x + y * y);
        x *= magnitude;
        y *= magnitude;
    }

    public double dotProduct(Vector2 coords) {
        if (coords == null) return 0;
        return this.x * coords.x + this.y * coords.y;
    }
}
