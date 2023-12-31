package com.ksp.creationalpatterns;

//Product class
class Pizza {
	private String dough;
	private String sauce;
	private String topping;

	public void setDough(String dough) {
		this.dough = dough;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	@Override
	public String toString() {
		return "Pizza with " + dough + " dough, " + sauce + " sauce, and " + topping + " topping.";
	}
}

//Builder interface
interface PizzaBuilder {
	void buildDough();
	void buildSauce();
	void buildTopping();
	Pizza getPizza();
}

//Concrete Builder
class HawaiianPizzaBuilder implements PizzaBuilder {
	private Pizza pizza;

	public HawaiianPizzaBuilder() {
		pizza = new Pizza();
	}

	public void buildDough() {
		pizza.setDough("thin");
	}

	public void buildSauce() {
		pizza.setSauce("tomato");
	}

	public void buildTopping() {
		pizza.setTopping("ham and pineapple");
	}

	public Pizza getPizza() {
		return pizza;
	}
}

//Director
class Waiter {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
}

//Client
public class BuilderPatternExample {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

		waiter.setPizzaBuilder(hawaiianPizzaBuilder);
		waiter.constructPizza();

		Pizza pizza = waiter.getPizza();
		System.out.println("Pizza built: " + pizza);
	}
}

