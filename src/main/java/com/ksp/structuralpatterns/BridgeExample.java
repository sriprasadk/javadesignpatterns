package com.ksp.structuralpatterns;

/**
 * The Bridge pattern decouples an abstraction from its implementation, allowing them to vary independently
 *
 */
//Implementor interface for color
interface Color {
 void applyColor();
}

//Concrete Implementor A: Red color
class RedColor implements Color {
 
 public void applyColor() {
     System.out.println("Applying red color");
 }
}

//Concrete Implementor B: Green color
class GreenColor implements Color {
 
 public void applyColor() {
     System.out.println("Applying green color");
 }
}

//Abstraction
abstract class Shapec {
 protected Color color;

 public Shapec(Color color) {
     this.color = color;
 }

 abstract void applyColor();
}

//Refined Abstraction: Circle shape
class Circle extends Shapec {
 public Circle(Color color) {
     super(color);
 }

 
 void applyColor() {
     System.out.print("Circle filled with ");
     color.applyColor();
 }
}

//Refined Abstraction: Square shape
class Square extends Shapec {
 public Square(Color color) {
     super(color);
 }

 
 void applyColor() {
     System.out.print("Square filled with ");
     color.applyColor();
 }
}

//Client
public class BridgeExample {
 public static void main(String[] args) {
     Color red = new RedColor();
     Color green = new GreenColor();

     Shapec redCircle = new Circle(red);
     Shapec greenSquare = new Square(green);

     redCircle.applyColor(); // Output: Circle filled with red color
     greenSquare.applyColor(); // Output: Square filled with green color
 }
}

