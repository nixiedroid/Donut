package com.nixiedroid.Donut.render.renderSurface.dotSurface;

import com.nixiedroid.Donut.render.FrameBuffer;
import com.nixiedroid.Donut.render.enums.RenderSurfaceType;
import com.nixiedroid.Donut.render.renderSurface.Surface;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GrayscaleTerminalSurface extends Surface {
    private final StringBuilder sb = new StringBuilder();
    private final char[] charRow;


    public GrayscaleTerminalSurface(int width, int height) {
        super(width,height);
        ANSI.clearScreen();
        this.charRow = new char[width];
    }


    public GrayscaleTerminalSurface(int height) {
        super(height);
        ANSI.clearScreen();
        this.charRow = new char[width];
    }

    @Override
    public void drawRaster(FrameBuffer frameBuffer) {
        ANSI.moveCursorToHome();
        for (int i = 0; i < frameBuffer.getHeight(); i++) {
            for (int j = 0; j < frameBuffer.getWidth(); j++) {
                ANSI.printGrayscaleChar((int)(frameBuffer.getFrameBuffer()[i][j]*255));
            }
            System.out.println();
        }
        ANSI.fixTextColor();
    }

    @Override
    public void drawVector(ArrayList<Line2D.Double> lines) {
        FrameBuffer fb = convertVectorToRaster(lines);
        drawRaster(fb);
    }

}
