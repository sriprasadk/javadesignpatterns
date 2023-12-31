package com.ksp.behavioralpatterns;

//Visitor interface
interface ShapeVisitor {
 void visit(Circle circle);
 void visit(Rectangle rectangle);
 void visit(Triangle triangle);
}

//Element interface
interface Shape {
 void accept(ShapeVisitor visitor);
}

//Concrete Element A
class Circle implements Shape {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 public double getRadius() {
     return radius;
 }

 @Override
 public void accept(ShapeVisitor visitor) {
     visitor.visit(this);
 }
}

//Concrete Element B
class Rectangle implements Shape {
 private double width;
 private double height;

 public Rectangle(double width, double height) {
     this.width = width;
     this.height = height;
 }

 public double getWidth() {
     return width;
 }

 public double getHeight() {
     return height;
 }

 @Override
 public void accept(ShapeVisitor visitor) {
     visitor.visit(this);
 }
}

//Concrete Element C
class Triangle implements Shape {
 private double sideA;
 private double sideB;
 private double sideC;

 public Triangle(double sideA, double sideB, double sideC) {
     this.sideA = sideA;
     this.sideB = sideB;
     this.sideC = sideC;
 }

 public double getSideA() {
     return sideA;
 }

 public double getSideB() {
     return sideB;
 }

 public double getSideC() {
     return sideC;
 }

 @Override
 public void accept(ShapeVisitor visitor) {
     visitor.visit(this);
 }
}

//Concrete Visitor
class AreaPerimeterCalculator implements ShapeVisitor {
 @Override
 public void visit(Circle circle) {
     double area = Math.PI * circle.getRadius() * circle.getRadius();
     double perimeter = 2 * Math.PI * circle.getRadius();
     System.out.println("Circle - Area: " + area + ", Perimeter: " + perimeter);
 }

 @Override
 public void visit(Rectangle rectangle) {
     double area = rectangle.getWidth() * rectangle.getHeight();
     double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
     System.out.println("Rectangle - Area: " + area + ", Perimeter: " + perimeter);
 }

 @Override
 public void visit(Triangle triangle) {
     // Calculation for triangle area and perimeter
     double semiPerimeter = (triangle.getSideA() + triangle.getSideB() + triangle.getSideC()) / 2;
     double area = Math.sqrt(semiPerimeter *
                 (semiPerimeter - triangle.getSideA()) *
                 (semiPerimeter - triangle.getSideB()) *
                 (semiPerimeter - triangle.getSideC()));
     double perimeter = triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
     System.out.println("Triangle - Area: " + area + ", Perimeter: " + perimeter);
 }
}

//Client
public class VisitorExample {
 public static void main(String[] args) {
     Shape[] shapes = {
             new Circle(5),
             new Rectangle(3, 4),
             new Triangle(3, 4, 5)
     };

     AreaPerimeterCalculator calculator = new AreaPerimeterCalculator();
     
     for (Shape shape : shapes) {
         shape.accept(calculator);
     }
 }
}
