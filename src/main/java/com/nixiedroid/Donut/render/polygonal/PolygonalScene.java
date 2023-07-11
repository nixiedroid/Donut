package com.nixiedroid.Donut.render.polygonal;

import com.nixiedroid.Donut.render.VectorScene;
import com.nixiedroid.Donut.render.math.Vector2;
import com.nixiedroid.Donut.render.math.Vector3;

import java.awt.geom.Line2D;
import java.util.ArrayList;


public class PolygonalScene implements VectorScene {
    private final ArrayList<Line2D.Double> lines;

    public PolygonalScene(ArrayList<Line2D.Double> lines) {
        this.lines = lines;
    }

    public void drawObject(Primitive primitive , Camera camera)
    {
        for (int i = 0; i < primitive.indexes.length; i+=3)
        {
            int i1 = primitive.indexes[i];
            int i2 = primitive.indexes[i+ 1];
            int i3 = primitive.indexes[i+ 2];
            Vector3 v1 = primitive.globalVertices[i1];
            Vector3 v2 = primitive.globalVertices[i2];
            Vector3 v3 = primitive.globalVertices[i3];
            drawPolygon(v1,v2,v3 , camera );
        }
    }

    public void drawPolygon(Vector3 v1, Vector3 v2, Vector3 v3, Camera camera )
    {
        Vector2 p1 = camera.screenProjection(v1);
        Vector2 p2 = camera.screenProjection(v2);
        Vector2 p3 = camera.screenProjection(v3);
        drawLine(p1, p2);
        drawLine(p2, p3);
        drawLine(p3, p1);
    }

    public void drawLine(Vector2 p1, Vector2 p2) {
        Line2D.Double line = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
        lines.add(line);
    }


    @Override
    public void calculateNextFrame(ArrayList<Line2D.Double> lines) {

    }
}
