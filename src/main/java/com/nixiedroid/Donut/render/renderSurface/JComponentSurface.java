package com.nixiedroid.Donut.render.renderSurface;

import com.nixiedroid.Donut.render.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class JComponentSurface extends JComponent {

    ArrayList<Line2D.Double> lines;

    public JComponentSurface(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        lines = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int)line.getX1(),
                    (int)line.getY1(),
                    (int)line.getX2(),
                    (int)line.getY2()
            );

        }

    }
    public void drawObject(Primitive primitive , Camera camera)
    {
        for (int i = 0; i < primitive.indexes.length; i+=3)
        {
            // индексы вершин полигона
            int i1 = primitive.indexes[i];
            int i2 = primitive.indexes[i+ 1];
            int i3 = primitive.indexes[i+ 2];
            // вершины полигона
            Vector3 v1 = primitive.globalVertices[i1];
            Vector3 v2 = primitive.globalVertices[i2];
            Vector3 v3 = primitive.globalVertices[i3];
            // рисуем полигон
            drawPolygon(v1,v2,v3 , camera );
        }
    }

    public void drawPolygon(Vector3 v1, Vector3 v2, Vector3 v3, Camera camera )
    {
        //проекции вершин
        Vector2D p1 = camera.screenProjection(v1);
        Vector2D p2 = camera.screenProjection(v2);
        Vector2D p3 = camera.screenProjection(v3);
        //рисуем полигон
        drawLine(p1, p2);
        drawLine(p2, p3);
        drawLine(p3, p1);
    }

    public void drawLine(Vector2D p1, Vector2D p2) {
        Line2D.Double line = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
        lines.add(line);
        repaint();
    }
}
