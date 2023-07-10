package com.nixiedroid.Donut.scene.noise;

import com.nixiedroid.Donut.render.FrameBuffer;

public class RandomNoise extends Noise{
    @Override
    public void calculateNextFrame(FrameBuffer frameBuffer) {
        XORShift  random = new XORShift();
        for (int i = 0; i < frameBuffer.getHeight(); i++) {
            for (int j = 0; j < frameBuffer.getWidth(); j++) {
                frameBuffer.getFrameBuffer()[i][j] = random.nextDouble();
                //random.nextGaussian()
            }
        }
    }
}
