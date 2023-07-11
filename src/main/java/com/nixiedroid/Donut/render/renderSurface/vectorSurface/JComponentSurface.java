package com.nixiedroid.Donut.render.renderSurface.vectorSurface;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class JComponentSurface extends JComponent {
    private final ArrayList<Line2D.Double> lines;
    public JComponentSurface(int width, int height,ArrayList<Line2D.Double> lines) {
        super();
        setPreferredSize(new Dimension(width,height));
        this.lines = lines;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
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
    public void draw(){
        repaint();
    }

}
