package com.nixiedroid.Donut.render.renderSurface;

import com.nixiedroid.Donut.render.FrameBuffer;

public abstract class Surface {
   protected int width;
   protected int height;

   public Surface(int width, int height) {
      this.width = width;
      this.height = height;
   }

   public abstract void draw(FrameBuffer canvas);
   public int getWidth() {
      return width;
   }

   public int getHeight() {
      return height;
   }
}
