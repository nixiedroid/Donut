package com.nixiedroid.Donut.scene.polygonal;

import com.nixiedroid.Donut.render.polygonal.Pivot;
import com.nixiedroid.Donut.render.math.Vector3;
import com.nixiedroid.Donut.render.polygonal.Primitive;

public class Cube extends Primitive {
    public Cube(Vector3 center, float sideLen)
    {
        pivot = new Pivot(center);
        double d = sideLen/2;
        localVertices = new Vector3[]
                {
                        new Vector3(center.x - d , center.y + d, center.z - d) ,//0
                        new Vector3(center.x + d , center.y + d, center.z - d) ,//1
                        new Vector3(center.x + d , center.y + d, center.z + d) ,//2
                        new Vector3(center.x - d , center.y + d, center.z + d) ,//3
                        new Vector3(center.x - d , center.y - d, center.z - d) ,//4
                        new Vector3(center.x + d , center.y - d, center.z - d) ,//5
                        new Vector3(center.x + d , center.y - d, center.z + d) ,//6
                        new Vector3(center.x - d , center.y - d, center.z + d) ,//7
                };
        globalVertices = new Vector3[localVertices.length];
        for (int i = 0; i < localVertices.length; i++) {
            globalVertices[i] = pivot.toGlobalCoords(localVertices[i]);
        }
        indexes = new int[]
                {
                        0,1,2 , //Poly1
                        0,2,3 , //Poly2
                        0,3,7 ,
                        0,4,7 ,

                        1,2,6,
                        1,6,5,
                        4,5,6,
                        4,6,7,

                        3,2,6,
                        3,7,6,
                        4,0,1,
                        4,5,1
                };
    }
}
