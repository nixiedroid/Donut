package com.nixiedroid.Donut.render;


import com.nixiedroid.Donut.ANSI;
import com.nixiedroid.Donut.figure.Figure;

public class Render {
    private double xRot = 0;
    private double yRot = 0;
    private double zRot = 0;
    private double xRotScale = 0;
    private double yRotScale = 0;
    private double zRotScale = 0;

    private Figure figure;
    private Frame frameBuffer;


    private Render() {
        ANSI.clearScreen();
    }

    public void drawFrame() {
        figure.calculate(frameBuffer, xRot, yRot, zRot);
        frameBuffer.draw();
        zRot += zRotScale;
        xRot += xRotScale;
        yRot += yRotScale;
    }

    public void drawFrame(double xRot, double yRot, double zRot) {
        figure.calculate(frameBuffer, xRot, yRot, zRot);
        frameBuffer.draw();
    }

    public void drawFrames(final int amount) {
        for (int frameCounter = 0; frameCounter <= amount; frameCounter++) {
            drawFrame();
        }
    }

    public static class Builder {
        private final Render render;

        public Builder() {
            render = new Render();
        }

        public Builder withRotationScale(double xAxis, double yAxis, double zAxis) {
            render.xRotScale = xAxis;
            render.yRotScale = yAxis;
            render.zRotScale = zAxis;
            return this;
        }

        public Builder usingFigure(final Figure fig) {
            render.figure = fig;
            return this;
        }

        public Builder createWindow(int width,int height) {
            render.frameBuffer =  new Frame(width,height);
            return this;
        }

        public Render build() {
            if (render.figure == null) throw new IllegalArgumentException("Figure not specified");
            if (render.frameBuffer == null) throw new IllegalArgumentException("Framebuffer is null");
            return render;
        }
    }
}
