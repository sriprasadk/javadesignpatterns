package com.ksp.structuralpatterns;

/*
 * The Decorator pattern allows adding new functionality to existing objects without altering their structure
 */
//Component interface
interface Coffee {
 double getCost();
 String getDescription();
}

//Concrete Component
class SimpleCoffee implements Coffee {
 @Override
 public double getCost() {
     return 2.0;
 }

 @Override
 public String getDescription() {
     return "Simple Coffee";
 }
}

//Decorator
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee decoratedCoffee) {
     this.decoratedCoffee = decoratedCoffee;
 }

 public double getCost() {
     return decoratedCoffee.getCost();
 }

 public String getDescription() {
     return decoratedCoffee.getDescription();
 }
}

//Concrete Decorator A
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 public double getCost() {
     return super.getCost() + 0.5;
 }

 public String getDescription() {
     return super.getDescription() + ", with Milk";
 }
}

//Concrete Decorator B
class WhipDecorator extends CoffeeDecorator {
 public WhipDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 public double getCost() {
     return super.getCost() + 0.7;
 }

 public String getDescription() {
     return super.getDescription() + ", with Whip";
 }
}

//Client
public class DecoratorExample {
 public static void main(String[] args) {
     // Create a simple coffee
     Coffee simpleCoffee = new SimpleCoffee();
     System.out.println("Cost: $" + simpleCoffee.getCost() + ", Description: " + simpleCoffee.getDescription());

     // Add milk to the simple coffee
     Coffee milkCoffee = new MilkDecorator(simpleCoffee);
     System.out.println("Cost: $" + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());

     // Add whip to the coffee with milk
     Coffee milkWithWhipCoffee = new WhipDecorator(milkCoffee);
     System.out.println("Cost: $" + milkWithWhipCoffee.getCost() + ", Description: " + milkWithWhipCoffee.getDescription());
 }
}
