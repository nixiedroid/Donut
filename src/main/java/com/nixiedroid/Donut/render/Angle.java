package com.nixiedroid.Donut.render;

public final class Angle {
    public static final double PI = 3.141;
    public static final double deg180 = PI;
    public static final double deg90 = PI / 2;
    public static final double deg45 = PI / 4;
    public static final double pi = PI;
    public static final double halfPi = PI / 2;
    public static final double quarterPi = PI / 4;

    public static double deg(double deg) {
        return deg * PI / 180;
    }

    public static double rad(double rad) {
        return rad;
    }

    private final double angleValue;

    public Angle(double angleValue) {
        this.angleValue = angleValue;
    }
}
