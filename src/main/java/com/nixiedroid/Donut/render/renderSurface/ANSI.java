package com.nixiedroid.Donut.render.renderSurface;

public class ANSI {
    public static char escapeChar = '\u001b'; //
    public static void clearScreen(){
       System.out.print(escapeChar + "[2J");
    }
    public static void moveCursorToHome(){
        System.out.print(escapeChar + "[H");
    }
    public static void printGrayscaleChar(int brightness, char value){
        System.out.print(escapeChar + "[38;2;"+brightness+";"+brightness+";"+brightness+"m"+value);
    }
    public static void printGrayscaleChar(int brightness){
        System.out.print(escapeChar + "[38;2;"+ brightness +";"+ brightness +";"+ brightness +"m\u2588");
    }
    public static void fixTextColor(){
        System.out.print(escapeChar + "[0m"+" ");
    }

}
