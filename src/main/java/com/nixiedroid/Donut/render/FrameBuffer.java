package com.nixiedroid.Donut.render;

import java.util.Arrays;

public class FrameBuffer {
    private final double[][] zBuffer;
    private final double[][] frameBuffer;
    private final int height;
    private final int width;


    public FrameBuffer(final int width, final int height) {
        this.frameBuffer = new double[height][width];
        this.zBuffer = new double[height][width];
        this.height = height;
        this.width = width;
    }

    public double[][] getFrameBuffer() {
        return frameBuffer;
    }
    public double[][] getZBuffer() {
        return zBuffer;
    }

    public void emptyFrameBuffer() {
        for (int row = 0; row < height; row++) {
            Arrays.fill(frameBuffer[row], 0);
            Arrays.fill(zBuffer[row], 1);
        }
    }

    public boolean ifCoordsInBoundaries(int row, int column) {
        return (height > column && column > 0) && (width > row && row > 0);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int projectX(double value, double multiplier) {
        return (int) (width / 2 + (multiplier) * value);
    }

    public int projectY(double value, double multiplier) {
        return (int) (height / 2 + (multiplier) * value);
    }

    public int projectX(double normalisedValue) {
        if (normalisedValue > 1) throw new IllegalArgumentException("X = " + normalisedValue + " is not normalised!");
        return (int) (width / 2 - 1 + (height / 2) * (width/height) * normalisedValue);
    }

    public int projectY(double normalisedValue) {
        if (normalisedValue > 1) throw new IllegalArgumentException("Y = " + normalisedValue + " is not normalised!");
        return (int) (height / 2 - 1 + (height / 2) * normalisedValue);
    }

    public int stretchX(double normalisedX) {
        return (int) (width / 2 - 1 + (width / 2) * normalisedX);
    }

    public int stretchY(double normalisedY) {
        return (int) (height / 2 - 1 + (height / 2) * normalisedY);
    }


}
