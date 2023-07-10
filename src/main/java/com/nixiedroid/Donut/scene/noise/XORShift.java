package com.nixiedroid.Donut.scene.noise;

import java.util.Random;

public class XORShift {
    long seed = Long.MAX_VALUE>>5;
    //Read IEE754 standard
    private static final double NORM_DOUBLE64_MIN_VAL = 1. / ( 1L << 53 );
    private static final int DOUBLE64_EXP_SIZE = 11;
    Random randomG = new Random();
    public long randomLong() {
//        seed ^= (seed << 21);
//        seed ^= (seed >>> 35);
//        seed ^= (seed << 4);

        return (long) (randomG.nextLong()%19*Long.MAX_VALUE/20);
    }
    public double nextDouble() {
        return ( randomLong() >>> DOUBLE64_EXP_SIZE) * NORM_DOUBLE64_MIN_VAL;
    }
}
