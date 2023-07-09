package com.nixiedroid.Donut.render.renderSurface;

public class ANSI {
    public static char escapeChar = '\u001b'; //
    public static void clearScreen(){
       System.out.print(escapeChar + "[2J");
    }
    public static void moveCursorToHome(){
        System.out.print(escapeChar + "[H");
    }
}
