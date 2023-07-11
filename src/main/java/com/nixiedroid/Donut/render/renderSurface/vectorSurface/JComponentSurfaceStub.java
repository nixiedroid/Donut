package com.nixiedroid.Donut.render.renderSurface.vectorSurface;

import com.nixiedroid.Donut.render.FrameBuffer;
import com.nixiedroid.Donut.render.renderSurface.Surface;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class JComponentSurfaceStub extends Surface {

    JComponentSurface surface;
    public JComponentSurfaceStub(int width, int height) {
        super(width, height);

    }

    public JComponentSurfaceStub(int height) {
        super(height, height);
    }
    public void createScene(int width, int height,ArrayList<Line2D.Double> lines ){
        Runnable r = new Runnable() {
            public void run() {
                surface = new JComponentSurface(width,height,lines);
                surface.draw();
                JOptionPane.showMessageDialog(null, surface);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    @Override
    public void drawRaster(FrameBuffer canvas) {

    }
    @Override
    public void drawVector(ArrayList<Line2D.Double> lines) {
        createScene(width,height,lines);
    }
}
