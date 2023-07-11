package com.nixiedroid.Donut.render.polygonal;

import com.nixiedroid.Donut.render.math.Vector3;

public abstract class Primitive {
    //public Vector3[] vertices;
    public int[] indexes;
    public Pivot pivot;
    public Vector3[] localVertices;
    public Vector3[] globalVertices;

    public Primitive move(Vector3 v)
    {
        pivot.move(v);
        for (int i = 0; i < localVertices.length; i++) globalVertices[i].add(v);
        return this;
    }
    public Primitive move(double x, double y, double z)
    {
        pivot.move(x,y,z);
        for (int i = 0; i < localVertices.length; i++) globalVertices[i].add(x,y,z);
        return this;
    }

    public Primitive rotateX(double angle)
    {
        pivot.rotateX(angle);
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = pivot.toGlobalCoords(localVertices[i]);
        }
        return this;
    }
    public Primitive rotateY(double angle)
    {
        pivot.rotateY(angle);
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = pivot.toGlobalCoords(localVertices[i]);
        }
        return this;
    }
    public Primitive rotateZ(double angle)
    {
        pivot.rotateZ(angle);
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = pivot.toGlobalCoords(localVertices[i]);
        }
        return this;
    }

    public void Scale(float k)
    {
        for (Vector3 localVertex : localVertices) localVertex.multiply(k);

        for (int i = 0; i < localVertices.length; i++)
            globalVertices[i] = pivot.toGlobalCoords(localVertices[i]);
    }
}
