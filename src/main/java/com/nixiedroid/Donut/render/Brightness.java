package com.nixiedroid.Donut.render;

public class Brightness {
    private static final float SQRT_2 = 1.414F;
    public static final char[] palette = new char[]{'.',',','-','~',':',';','=','!','*','#','$','0',};
    private static final char[] gradient = ".'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray();

    public static char getBrightnessChar(double brightness){

        return gradient[Math.max((int)(brightness * gradient.length - 1 ), 0)];
        //return
    }
}
