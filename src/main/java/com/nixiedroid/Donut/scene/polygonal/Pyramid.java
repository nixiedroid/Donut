package com.nixiedroid.Donut.scene.polygonal;

import com.nixiedroid.Donut.render.polygonal.Pivot;
import com.nixiedroid.Donut.render.polygonal.Primitive;
import com.nixiedroid.Donut.render.math.Vector3;

public class Pyramid extends Primitive {
    public Pyramid(Vector3 center, float sideLen)
    {
        pivot = new Pivot(center);
        localVertices = new Vector3[]
                {
                        new Vector3(0 , 0, 0) ,//0
                        new Vector3(sideLen, 0, 0) ,//1
                        new Vector3(0 , 0, sideLen) ,//2
                        new Vector3(0, sideLen, 0) ,//3
                };
        globalVertices = new Vector3[localVertices.length];
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = localVertices[i];
        }
        indexes = new int[]
                {
                        0,1,2 , //Poly1
                        0,1,3 , //Poly2
                        0,2,3 ,
                        1,2,3
                };
    }
}
