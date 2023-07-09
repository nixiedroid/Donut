package com.nixiedroid.Donut.render.renderSurface;

import com.nixiedroid.Donut.render.FrameBuffer;

public class TerminalSurface extends Surface {
    private final StringBuilder sb = new StringBuilder();
    private final char[] charRow;


    public TerminalSurface(int width, int height) {
        super(width,height);
        ANSI.clearScreen();
        this.charRow = new char[width];
    }


    public TerminalSurface( int height) {
        super((int) (height*2.5),height);
        this.charRow = new char[width];
    }

    @Override
    public void draw(FrameBuffer frameBuffer) {
            ANSI.moveCursorToHome();
            sb.setLength(0);
            for (int row = 0; row < height; row++) {
                fillBrightnessCharRow(frameBuffer.getFrameBuffer()[row]);
                sb.append(charRow);
                sb.append("\n");
            }
            System.out.print(sb);
    }
    private void fillBrightnessCharRow(double[] value){
        for (int i=0; i<value.length; i++) {
            charRow[i] = getCurrentGradient()[Math.max((int)(value[i] * getCurrentGradient().length - 1 ), 0)];
        }
    }
    private static final char[] gradient = " .,-~:;=!*#$0".toCharArray();
    private static final char[] gradient2 = " .:!/r(I1Z4H9W8$@".toCharArray();
    private static final char[] gradient3 = " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray();

    private static char[] getCurrentGradient(){
        return gradient2;
    }
}
