package com.nixiedroid.Donut.render;


public class Render {
    private Scene scene;
    private FrameBuffer frameBuffer;
    private Surface renderSurface;

    private Render() {}

    public void drawFrame() {
        scene.calculateNextFrame(frameBuffer);
        renderSurface.draw(frameBuffer);
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
        public Builder usingSurface(final Surface surface) {
            render.renderSurface = surface;
            return this;
        }

        public Builder usingScene(final Scene scene) {
            render.scene = scene;
            return this;
        }

        public Render build() {
            if (render.renderSurface == null) throw new IllegalArgumentException("Surface is not specified");
            render.frameBuffer =  new FrameBuffer(render.renderSurface.getWidth(),render.renderSurface.getHeight());
            if (render.scene == null) throw new IllegalArgumentException("Scene not specified");
            return render;
        }
    }
}
