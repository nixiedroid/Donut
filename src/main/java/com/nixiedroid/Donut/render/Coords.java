package com.nixiedroid.Donut.render;

public class Coords {
    public double x;
    public double y;
    public double z;
    private double sinA;
    private double cosA;
    private boolean isNormalised = false;
    private boolean isStrictNormalised = false;

    public Coords(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coords() {
    }


    public Coords set(double x, double y, double z){
        if(isNormalised && x>1 )
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }
    public Coords add(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    public Coords add(double value){
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }
    public Coords add(Coords value){
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }
    public Coords mult(double value){
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }
    public Coords mult(double x, double y, double z){
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Coords rotateX(double angle) {
        cosA = Math.cos(angle);
        sinA = Math.sin(angle);
        double tmpY = y;
        y = z * sinA + y * cosA;
        z = -(tmpY * sinA) + z * cosA;
        return this;
    }

    public Coords rotateY(double angle) {
        cosA = Math.cos(angle);
        sinA = Math.sin(angle);
        double tmpZ = z;
        z = x * sinA + z * cosA;
        x = -(tmpZ * sinA) + x * cosA;
        return this;
    }

    public Coords rotateZ(double angle) {
        cosA = Math.cos(angle);
        sinA = Math.sin(angle);
        double tmpX = x;
        x = y * sinA + x * cosA;
        y = -(tmpX * sinA) + y * cosA;
        return this;
    }
    public boolean isNormalised(){
        return isNormalised;
    }
    public void setNormalised(boolean value){
        this.isNormalised = value;
    }
    public boolean isStrictNormalised(){
        return isStrictNormalised;
    }
    public void setStrictNormalisedNormalised(){
        this.isStrictNormalised = true;
    }
    private boolean validateNormalised(double x, double y, double z){
           return false     ;
    }
    private double fastInvSqrt(double value){
        return 0;
    }
    public double normaliseVector(){
        return 0;
    }
}
