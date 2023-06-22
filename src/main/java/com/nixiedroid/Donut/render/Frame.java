package com.nixiedroid.Donut.render;

import java.util.Arrays;

public class Frame {
    private final double[][] zBuffer;
    private final int[][] xyBuffer;
    private final int height;
    private final int width;

    public Frame(final int width, final int height) {
        this.zBuffer = new double[height][width];
        this.xyBuffer = new int[height][width];

        this.height = height;
        this.width = width;
    }

    public double[][] getZBuffer() {
        return zBuffer;
    }

    public int[][] getXYBuffer() {
        return xyBuffer;
    }

    public void emptyBuffers() {
        for (int row = 0; row < height; row++) {
            Arrays.fill(xyBuffer[row], ' ');
            Arrays.fill(zBuffer[row], 1);
        }
    }
    public void emptyBuffers(char character, double value) {
        for (int row = 0; row < height; row++) {
            Arrays.fill(xyBuffer[row], character);
            Arrays.fill(zBuffer[row], value);
        }
    }

    public boolean ifCoordsInBoundaries(int row, int column) {
        return (height > column && column > 0) && (width > row && row > 0);
    }

    public void draw() {
        ANSI.moveCursorToHome();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                System.out.print((char) xyBuffer[row][column]);
            }
            System.out.println();
        }
    }

    public int projectX(double value, double multiplier) {
        return (int) (width / 2 + (multiplier) * value);
    }

    public int projectY(double value, double multiplier) {
        return (int) (height / 2 + (multiplier) * value);
    }

    public int projectX(double normalisedValue) {
        if (normalisedValue > 1) throw new IllegalArgumentException("X = " +normalisedValue+ " is not normalised!");
        return (int) (width / 2 - 1 + (height / 2) * normalisedValue);
    }

    public int projectY(double normalisedValue) {
        if (normalisedValue > 1) throw new IllegalArgumentException("Y = " +normalisedValue+ " is not normalised!");
        return (int) (height / 2 - 1 + (height / 2) * normalisedValue);
    }

    public int stretchX(double normalisedX) {
        return (int) (width / 2 + (width / 2 - 1) * normalisedX);
    }

    public int stretchY(double normalisedY) {
        return (int) (height / 2 + (height / 2 - 1) * normalisedY);
    }


}
