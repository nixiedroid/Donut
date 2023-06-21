package com.nixiedroid.Donut;


import com.nixiedroid.Donut.render.Render;

public class Main {

    public static void main(String[] args) {
        Render render = new Render.Builder()
                .withRotationScale(0.02f,0f,0.08f)
                .build();

        render.drawFrames(20);
        render.drawFrame(0.02f,0.08f,0.8f);
    }
}