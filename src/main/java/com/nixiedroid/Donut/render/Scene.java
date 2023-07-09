package com.nixiedroid.Donut.render;

public abstract class Scene {
    protected abstract void calculate(FrameBuffer frameBuffer);
    protected abstract void calculateSingleFrame(FrameBuffer frameBuffer);

}
