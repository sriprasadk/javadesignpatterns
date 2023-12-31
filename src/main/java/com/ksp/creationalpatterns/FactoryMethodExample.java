package com.ksp.creationalpatterns;

/**
 * the Factory Method pattern involves creating an interface for creating an object, but allowing the subclasses to alter the type of objects that will be created
 * @author kakar
 *
 */
//Product interface
interface Vehicle {
	void manufacture();
}

//Concrete Product A
class Car implements Vehicle {

	public void manufacture() {
		System.out.println("Car is being manufactured.");
	}
}

//Concrete Product B
class Bike implements Vehicle {

	public void manufacture() {
		System.out.println("Bike is being manufactured.");
	}
}

//Creator (Factory) interface
interface VehicleFactory {
	Vehicle createVehicle();
}

//Concrete Creators
class CarFactory implements VehicleFactory {

	public Vehicle createVehicle() {
		return new Car();
	}
}

class BikeFactory implements VehicleFactory {

	public Vehicle createVehicle() {
		return new Bike();
	}
}

//Client
public class FactoryMethodExample {
	public static void main(String[] args) {
		VehicleFactory carFactory = new CarFactory();
		Vehicle car = carFactory.createVehicle();
		car.manufacture();

		VehicleFactory bikeFactory = new BikeFactory();
		Vehicle bike = bikeFactory.createVehicle();
		bike.manufacture();
	}
}

