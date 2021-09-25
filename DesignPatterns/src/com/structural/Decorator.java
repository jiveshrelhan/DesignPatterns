package com.structural;

/*
 * Has A and Is A relationship both
 */
public class Decorator {

	public static void main(String[] args) {
		Product coffee = new Coffee();
		coffee = new SugarDecorator(coffee);
		coffee = new MilkDecorator(coffee);
		coffee = new MilkDecorator(coffee);

		System.out.println(coffee.getName() + " --" + coffee.getCost());

	}
}

interface Product {
	public String getName();

	public int getCost();
}

class Coffee implements Product {

	@Override
	public String getName() {
		return "This is coffee";
	}

	@Override
	public int getCost() {
		return 3;
	}
}

abstract class AddOnDecorator implements Product {
}

class SugarDecorator extends AddOnDecorator {
	Product product;

	public SugarDecorator(Product product) {
		this.product = product;
	}

	@Override
	public String getName() {
		return this.product.getName() + " with sugar ";
	}

	@Override
	public int getCost() {
		return this.product.getCost() + 1;
	}
}

class MilkDecorator extends AddOnDecorator {
	Product product;

	public MilkDecorator(Product product) {
		this.product = product;
	}

	@Override
	public String getName() {
		return this.product.getName() + " with milk ";
	}

	@Override
	public int getCost() {
		return this.product.getCost() + 2;
	}
}
