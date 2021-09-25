package com.construction;

public class AbstractFactoryClient {
	public static void main(String[] args) {
		Factory normal_customer_factory = new NormalGiftBox();
		GiftBox normalBox = normal_customer_factory.packGiftBox();
		normalBox.open();
		
		Factory premium_customer_factory = new PremiumGiftBox();
		GiftBox premiumBox = premium_customer_factory.packGiftBox();
		premiumBox.open();
	}
}

interface Snacks {
	public void eat();
}

class Biscuits implements Snacks {
	@Override
	public void eat() {
		System.out.println("Eating biscuits");
	}
}

class Namkeen implements Snacks {
	@Override
	public void eat() {
		System.out.println("Eating Namkeen");
	}
}

class JeeraBiscuit implements Snacks {
	@Override
	public void eat() {
		System.out.println("Eating Jeera Biscuit");
	}
}

class DryFruitNamkeen implements Snacks {
	@Override
	public void eat() {
		System.out.println("Eating Dry Fruit Namkeen");
	}
}

class GiftBox {
	Snacks snack1;
	Snacks snack2;

	GiftBox(Snacks biscuit, Snacks namkeen) {
		this.snack1 = biscuit;
		this.snack2 = namkeen;
	}

	void open() {
		this.snack1.eat();
		this.snack2.eat();
	}
}

interface Factory {
	GiftBox packGiftBox();
}

class NormalGiftBox implements Factory {

	@Override
	public GiftBox packGiftBox() {
		return new GiftBox(new Biscuits(), new Namkeen());
	}
}

class PremiumGiftBox implements Factory {

	@Override
	public GiftBox packGiftBox() {
		return new GiftBox(new JeeraBiscuit(), new DryFruitNamkeen());
	}
}