package com.nixiedroid.Donut.render;

import com.nixiedroid.Donut.ANSI;

import java.util.Arrays;

public class Frame {
    static final float TAU = 6.28f;  //aka 2*PI
    static float i, j;
    static final int WIDTH = 80;
    static final int HEIGHT = 22;
    static double[][] zBuffer = new double[HEIGHT][WIDTH];
    static int[][] framebuffer = new int[HEIGHT][WIDTH];

    public static void calculate(float A, float B) {
        emptyBuffers();
        for (j = 0; TAU > j; j += 0.07) {
            for (i = 0; TAU > i; i += 0.02) {
                double c = Math.sin(i),
                        d = Math.cos(j),
                        e = Math.sin(A),
                        f = Math.sin(j),
                        g = Math.cos(A),
                        h = d + 2,
                        distance = 1 / (c * h * e + f * g + 5),
                        l = Math.cos(i),
                        m = Math.cos(B),
                        n = Math.sin(B),
                        t = c * h * g - f * e;
                int x = (int) (40 + 30 * distance * (l * h * m - t * n));
                int y = (int) (12 + 15 * distance * (l * h * n + t * m));
                int N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                if (22 > y && y > 0 && x > 0 && 80 > x && distance > zBuffer[y][x]) {
                    zBuffer[y][x] = distance;
                    framebuffer[y][x] = Brightness.palette[Math.max(N, 0)];
                }
            }
        }
    }

    public static void emptyBuffers() {
        for (int l = 0; l < HEIGHT; l++) {
            Arrays.fill(framebuffer[l], ' ');
            Arrays.fill(zBuffer[l], 0);
        }
    }

    public static void draw() {
        ANSI.moveCursorToHome();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print((char) framebuffer[y][x]);
            }
            System.out.println();
        }
    }
}
