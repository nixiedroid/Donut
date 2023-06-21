package com.nixiedroid.Donut.render;

public class Brightness {
   // private static final int
    private static final int PRESCALER;
    private static final float SQRT_2 = 1.414F;
    static final char[] palette = new char[]{'.',',','-','~',':',';','=','!','*','#','$','0',};

    static {
        PRESCALER = (int)(palette.length/SQRT_2);
    }
    public static char getBrightnessChar(double brightness){
        return palette[Math.max((int)(brightness* PRESCALER), 0)];
    }
}
