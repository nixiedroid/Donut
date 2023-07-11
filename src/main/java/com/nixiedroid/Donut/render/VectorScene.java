package com.nixiedroid.Donut.render;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public interface VectorScene {
    void calculateNextFrame(ArrayList<Line2D.Double> lines);
}
