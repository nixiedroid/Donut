package com.nixiedroid.Donut.render;

import java.util.Arrays;

public class FrameBuffer {
    private final double[][] zBuffer;
    private final double[][] frameBuffer;
    private final int height;
    private final int width;
    private final double screenRatio;


    public FrameBuffer(final int width, final int height) {
        this.frameBuffer = new double[height][width];
        this.zBuffer = new double[height][width];
        this.height = height;
        this.width = width;
        this.screenRatio = (double) width / height;
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
        return (int) ((width >> 2) + (multiplier) * value);
    }

    public int projectY(double value, double multiplier) {
        return (int) ((height >> 2) + (multiplier) * value);
    }

    public int projectX(double value) {
        if (value > 1) throw new IllegalArgumentException("X = " + value + " is greater than one!");
        return (int) ((width >> 2) - 1 + (height >> 2) * screenRatio * value);
    }

    public int projectY(double value) {
        if (value > 1) throw new IllegalArgumentException("Y = " + value + " is greater than one!");
        return (int) ((height >> 2) - 1 + (height >> 2) * value);
    }

    public int stretchX(double value) {
        return (int) ((width >> 2) - 1 + (width >> 2) * value);
    }

    public int stretchY(double value) {
        return (int) ((height >> 2) - 1 + (height >> 2) * value);
    }


}
