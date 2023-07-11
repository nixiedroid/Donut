package com.nixiedroid.Donut.scene.polygonal;

import com.nixiedroid.Donut.render.polygonal.Pivot;
import com.nixiedroid.Donut.render.polygonal.Primitive;
import com.nixiedroid.Donut.render.math.Vector3;

public class Triangle extends Primitive {
    public Triangle(Vector3 center)
    {
        pivot = new Pivot(center);
        localVertices = new Vector3[]
                {
                        new Vector3(0 , 2, 0) ,//0
                        new Vector3(2, 0, 0) ,//1
                        new Vector3(0 , 0, 2) ,//2
                };
        globalVertices = new Vector3[localVertices.length];
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = localVertices[i];
        }
        indexes = new int[]
                {
                        0,1,2
                };
    }
}
