package com.nixiedroid.Donut.render.renderSurface;

import com.nixiedroid.Donut.render.FrameBuffer;
import com.nixiedroid.Donut.render.Surface;

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
    public void draw(FrameBuffer frameBuffer) {
        ANSI.moveCursorToHome();
        for (int i = 0; i < frameBuffer.getHeight(); i++) {
            for (int j = 0; j < frameBuffer.getWidth(); j++) {
                ANSI.printGrayscaleChar((int)(frameBuffer.getFrameBuffer()[i][j]*255));
            }
            System.out.println();
        }
        ANSI.fixTextColor();
    }

}
