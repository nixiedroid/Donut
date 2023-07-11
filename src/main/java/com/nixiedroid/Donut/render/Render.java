package com.nixiedroid.Donut.render;


import com.nixiedroid.Donut.render.renderSurface.Surface;

public class Render {
    private RasterScene rasterScene;
    private FrameBuffer frameBuffer;
    private Surface renderSurface;

    private Render() {}

    public void drawFrame() {
        rasterScene.calculateNextFrame(frameBuffer);
        renderSurface.drawRaster(frameBuffer);
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

        public Builder usingScene(final RasterScene rasterScene) {
            render.rasterScene = rasterScene;
            return this;
        }

        public Render build() {
            if (render.renderSurface == null) throw new IllegalArgumentException("Surface is not specified");
            render.frameBuffer =  new FrameBuffer(render.renderSurface.getWidth(),render.renderSurface.getHeight());
            if (render.rasterScene == null) throw new IllegalArgumentException("RasterScene not specified");
            return render;
        }
    }
}
