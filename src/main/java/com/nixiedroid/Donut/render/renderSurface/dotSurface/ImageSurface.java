package com.nixiedroid.Donut.render.renderSurface.dotSurface;

import com.nixiedroid.Donut.render.FrameBuffer;
import com.nixiedroid.Donut.render.renderSurface.Surface;

import javax.imageio.ImageIO;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageSurface extends Surface {
    int rgb;
    public ImageSurface(int width, int height) {
        super(width, height);
    }
    public ImageSurface(int height) {
        super(height,height);
    }

    @Override
    public void drawRaster(FrameBuffer canvas) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                rgb = (int) (canvas.getFrameBuffer()[i][j]*255+
                        canvas.getFrameBuffer()[i][j]*65536+
                        canvas.getFrameBuffer()[i][j]*16777214);
                image.setRGB(j, i, rgb);
            }
        }
        try {
            ImageIO.write(image, "png", new File("image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void drawVector(ArrayList<Line2D.Double> lines) {
        FrameBuffer fb = convertVectorToRaster(lines);
        drawRaster(fb);
    }
}
