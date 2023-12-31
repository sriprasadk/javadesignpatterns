package com.ksp.structuralpatterns;


/**
 * The Adapter design pattern allows incompatible interfaces to work together. Adapter pattern is useful for legacy implementations.
 * @author kakar
 *
 */
//Adaptee (existing class)
class LegacyRectangle {
 public void draw(int x, int y, int width, int height) {
     System.out.println("LegacyRectangle: Drawing rectangle at (" + x + ", " + y +
             ") with width " + width + " and height " + height);
 }
}

//Target interface
interface Shape {
 void drawShape(int x, int y, int width, int height);
}

//Adapter
class RectangleAdapter implements Shape {
 private LegacyRectangle legacyRectangle;

 public RectangleAdapter(LegacyRectangle legacyRectangle) {
     this.legacyRectangle = legacyRectangle;
 }

 
 public void drawShape(int x, int y, int width, int height) {
     legacyRectangle.draw(x, y, x + width, y + height);
 }
}

//Client
public class AdapterExample {
 public static void main(String[] args) {
     LegacyRectangle legacyRectangle = new LegacyRectangle();
     Shape adapter = new RectangleAdapter(legacyRectangle);

     // Use the adapter to draw the rectangle using the Shape interface
     adapter.drawShape(10, 20, 30, 40);
 }
}
