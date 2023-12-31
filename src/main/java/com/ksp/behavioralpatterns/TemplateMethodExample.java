package com.ksp.behavioralpatterns;

//Abstract class defining the template method
abstract class Beverage {
 // Template method
 public final void prepareRecipe() {
     boilWater();
     brew();
     pourInCup();
     if (customerWantsCondiments()) {
         addCondiments();
     }
 }

 // Abstract methods to be implemented by subclasses
 abstract void brew();
 abstract void addCondiments();

 // Common methods used in the template method
 void boilWater() {
     System.out.println("Boiling water");
 }

 void pourInCup() {
     System.out.println("Pouring into cup");
 }

 // Hook method (optional override by subclasses)
 boolean customerWantsCondiments() {
     return true;
 }
}

//Concrete subclass 1
class Tea extends Beverage {
 @Override
 void brew() {
     System.out.println("Steeping the tea");
 }

 @Override
 void addCondiments() {
     System.out.println("Adding lemon");
 }

 // Override hook method
 @Override
 boolean customerWantsCondiments() {
     // For Tea, customer doesn't want condiments by default
     return false;
 }
}

//Concrete subclass 2
class Coffee extends Beverage {
 @Override
 void brew() {
     System.out.println("Dripping coffee through filter");
 }

 @Override
 void addCondiments() {
     System.out.println("Adding sugar and milk");
 }
}

//Client
public class TemplateMethodExample {
 public static void main(String[] args) {
     System.out.println("Making tea...");
     Beverage tea = new Tea();
     tea.prepareRecipe();

     System.out.println("\nMaking coffee...");
     Beverage coffee = new Coffee();
     coffee.prepareRecipe();
 }
}
