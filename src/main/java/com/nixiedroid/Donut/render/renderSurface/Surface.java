package com.nixiedroid.Donut.render.renderSurface;

import com.nixiedroid.Donut.render.FrameBuffer;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public abstract class Surface {
   protected int width;
   protected int height;
   //RenderSurfaceType type;

   public Surface(int width, int height) {
      this.width = width;
      this.height = height;
   }
   public Surface(int height) {
      this.width = (int) (height*2.5);
      this.height = height;
   }

   public abstract void drawRaster(FrameBuffer canvas);
   public abstract void drawVector(ArrayList<Line2D.Double> lines);
   public int getWidth() {
      return width;
   }

   public int getHeight() {
      return height;
   }
   private void drawLine(FrameBuffer fb,int x1, int y1, int x2, int y2){
      throw new RuntimeException("Not Implemented Yet!");
   }
   protected FrameBuffer convertVectorToRaster(ArrayList<Line2D.Double> lines){
      FrameBuffer fb = new FrameBuffer(width,height);
      for (Line2D line:lines) {
         drawLine(fb,
                 (int) line.getX1(), (int) line.getY1(),
                 (int) line.getX2(), (int) line.getY2()
                 );
      }
      return fb;
   }
}
