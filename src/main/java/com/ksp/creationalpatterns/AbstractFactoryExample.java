package com.ksp.creationalpatterns;

//Abstract Product A
interface Shape {
	void draw();
}

//Concrete Product A1
class Circle implements Shape {
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

//Concrete Product A2
class Square implements Shape {
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}

//Abstract Product B
interface Color {
	void fill();
}

//Concrete Product B1
class Red implements Color {
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}

//Concrete Product B2
class Blue implements Color {
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}
}

//Abstract Factory
interface AbstractFactory {
	Shape createShape();
	Color createColor();
}

//Concrete Factory 1
class CircleShapeColorFactory implements AbstractFactory {
	public Shape createShape() {
		return new Circle();
	}

	public Color createColor() {
		return new Red();
	}
}

//Concrete Factory 2
class SquareShapeColorFactory implements AbstractFactory {
	public Shape createShape() {
		return new Square();
	}

	public Color createColor() {
		return new Blue();
	}
}

//Client
public class AbstractFactoryExample {
	public static void main(String[] args) {
		// Create factory 1
		AbstractFactory factory1 = new CircleShapeColorFactory();
		Shape shape1 = factory1.createShape();
		Color color1 = factory1.createColor();

		shape1.draw();
		color1.fill();

		// Create factory 2
		AbstractFactory factory2 = new SquareShapeColorFactory();
		Shape shape2 = factory2.createShape();
		Color color2 = factory2.createColor();

		shape2.draw();
		color2.fill();
	}
}

