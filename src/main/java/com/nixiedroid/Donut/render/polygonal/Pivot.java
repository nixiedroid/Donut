package com.nixiedroid.Donut.render.polygonal;

import com.nixiedroid.Donut.render.math.Matrix3x3;
import com.nixiedroid.Donut.render.math.Vector3;

public class Pivot
{
    public Vector3 center = new Vector3(0,0,0);
    public Vector3 xAxis = new Vector3(1,0,0);
    public Vector3 yAxis = new Vector3(0,1,0);
    public Vector3 zAxis = new Vector3(0,0,1);

    public Pivot(Vector3 center) {
        this.center = center;
        calculateMatricies();
    }

    public Pivot(Vector3 center, Vector3 xAxis, Vector3 yAxis, Vector3 zAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
        calculateMatricies();
    }

    public Matrix3x3 localCoordsMatrix;

    public Matrix3x3 globalCoordsMatrix;

    public Vector3 toLocalCoords(Vector3 global)
    {
        Vector3 sub = Vector3.substract(global,center);
        Vector3 mult = localCoordsMatrix.multiply(sub);
        return mult;
    }
    public Vector3 toGlobalCoords(Vector3 local)
    {
        Vector3 mult = globalCoordsMatrix.multiply(local);
        Vector3 add = Vector3.add(mult,center);

        return add;
    }

    public void move(Vector3 v)
    {
        center.add(v);
    }
    public void move(double x, double y, double z)
    {
        center.add(x,y,z);
    }

    public void rotateX(double angle)
    {
        yAxis.rotateX(angle);
        zAxis.rotateX(angle);
        calculateMatricies();
    }
    public void rotateY(double angle)
    {
        xAxis.rotateY(angle);
        zAxis.rotateY(angle);
        calculateMatricies();
    }
    public void rotateZ(double angle)
    {
        xAxis.rotateZ(angle);
        yAxis.rotateZ(angle);
        calculateMatricies();
    }
    public void calculateMatricies(){
        localCoordsMatrix = new Matrix3x3
                (
                        xAxis.x, yAxis.x, zAxis.x,
                        xAxis.y, yAxis.y, zAxis.y,
                        xAxis.z, yAxis.z, zAxis.z
                );

        globalCoordsMatrix = new Matrix3x3
                (
                        xAxis.x , xAxis.y , xAxis.z,
                        yAxis.x , yAxis.y , yAxis.z,
                        zAxis.x , zAxis.y , zAxis.z
                );
    }
}
