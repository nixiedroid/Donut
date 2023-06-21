package com.nixiedroid.Donut.render;


import com.nixiedroid.Donut.ANSI;

public class Render {
    private float xRot=0;
    private float yRot=0;
    private float zRot=0;
    private float X_AXIS_ROTATION_SCALE;
    private float Y_AXIS_ROTATION_SCALE;
    private float Z_AXIS_ROTATION_SCALE;


    public void drawFrame() {
        Frame.calculate(zRot, xRot);
        Frame.draw();
        zRot+=Z_AXIS_ROTATION_SCALE;
        xRot+=X_AXIS_ROTATION_SCALE;
        yRot+=Y_AXIS_ROTATION_SCALE;
    }
    public void drawFrame(float xRot, float yRot, float zRot) {
        Frame.calculate(zRot, xRot);
        Frame.draw();
    }
    public void drawFrames(final int amount){
        for (int frameCounter = 0; frameCounter <=amount ; frameCounter++ ) {
           drawFrame();
        }
    }
    private Render(){
        ANSI.clearScreen();
    }
    public static class Builder {
        private final Render render;
        public Builder(){
            render = new Render();
        }
        public Builder withRotationScale(float xAxis, float yAxis, float zAxis){
            render.X_AXIS_ROTATION_SCALE = xAxis;
            render.Y_AXIS_ROTATION_SCALE = yAxis;
            render.Z_AXIS_ROTATION_SCALE = zAxis;
            return this;
        }
        public Render build(){
            return render;
        }
    }
}
