package com.practise;

public interface AbstractFactory<T> {
	abstract T generateProduct(String type);
}

interface ProductA {

}

class ProductASubTypeA implements ProductA {

}

class ProductASubTypeB implements ProductA {

}

interface ProductB {

}

class ProductBSubTypeA implements ProductB {

}

class ProductBSubTypeB implements ProductB {

}

class ProductAFactory implements AbstractFactory<ProductA> {
	@Override
	public ProductA generateProduct(String type) {
		if (type == "TypeA") {
			return new ProductASubTypeA();
		} else {
			return new ProductASubTypeB();
		}
	}
}

class ProductBFactory implements AbstractFactory<ProductB> {
	@Override
	public ProductB generateProduct(String type) {
		if (type == "TypeA") {
			return new ProductBSubTypeA();
		} else {
			return new ProductBSubTypeB();
		}
	}
}

class Factory {
	public static AbstractFactory getFactory(String choice) {
		if ("Animal".equalsIgnoreCase(choice)) {
			return new ProductAFactory();
		} else if ("Color".equalsIgnoreCase(choice)) {
			return new ProductBFactory();
		}

		return null;
	}
}

class Client {
	public static void main(String[] args) {
		AbstractFactory<ProductA> a = Factory.getFactory("Animal");
	}
}