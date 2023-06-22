package com.nixiedroid.Donut.render;


import com.nixiedroid.Donut.render.figure.Figure;

public class Render {
    private Figure figure;
    private Canvas frameBuffer;
    private LightSource lightSource;
    private final Coords rotation = new Coords(0,0,0);
    private Coords rotationScale = new Coords(0,0,0);

    private Render() {
        ANSI.clearScreen();
    }

    public void drawFrame() {
        figure.fillCanvas(frameBuffer, rotation,lightSource);
        frameBuffer.draw();
        rotation.add(rotationScale);
    }

    public void drawFrame(Coords rotation) {
        figure.fillCanvas(frameBuffer, rotation,lightSource);
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

        public Builder withRotationScale(Coords rotationScale) {
            render.rotationScale = rotationScale;
            return this;
        }

        public Builder usingFigure(final Figure fig) {
            render.figure = fig;
            return this;
        }
        public Builder setLightSource(final LightSource lightSource) {
            render.lightSource = lightSource;
            return this;
        }
        public Builder createWindow(int height) {
            render.frameBuffer =  new Canvas((int) (height*2.5),height);
            return this;
        }

        public Render build() {
            if (render.figure == null) throw new IllegalArgumentException("Figure not specified");
            if (render.frameBuffer == null) throw new IllegalArgumentException("Framebuffer is null");
            if (render.lightSource == null) render.lightSource = new LightSource.Builder().placeBackwards().placeUp().normalise();
            return render;
        }
    }
}
