package com.nixiedroid.Donut.render;

public class Rotation {
    public double xDstPos;
    public double yDstPos;
    public double zDstPos;

    private double
            xRot=0,yRot=0,zRot=0,
            cosX,cosY,cosZ,sinX,sinY,sinZ;
    private void calculateTrig() {
        cosX = Math.cos(xRot);
        sinX = Math.sin(xRot);
        cosY = Math.cos(yRot);
        sinY = Math.sin(yRot);
        cosZ = Math.cos(zRot);
        sinZ = Math.sin(zRot);
    }
    private double calculateX(final double xPos, final double yPos, final double zPos){
        return   cosZ*(sinY*(yPos*sinX-zPos*cosX+xPos*cosY)) +sinZ*(zPos*sinX+yPos*cosX);
    }
    private double calculateY(final double xPos, final double yPos, final double zPos){
        return -(sinZ*(sinY*(yPos*sinX-zPos*cosX+xPos*cosY)))+cosZ*(zPos*sinX+yPos*cosX);
    }
    private double calculateZ(final double xPos, final double yPos, final double zPos){
        return xPos*sinY+(zPos*cosX*cosY-yPos*cosY*sinX);
    }
    public void rotate(final double xPos, final double yPos, final double zPos){
      calculateTrig();
      xDstPos = calculateX(xPos,yPos,zPos);
      yDstPos = calculateY(xPos,yPos,zPos);
      zDstPos = calculateZ(xPos,yPos,zPos);
    }
    public void setAngles(final double xRot, final double yRot, final double zRot){
        this.xRot = xRot;
        this.yRot = yRot;
        this.zRot = zRot;
    }
}
