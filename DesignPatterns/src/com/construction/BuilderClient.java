package com.construction;

public class BuilderClient {

	private static void buildCar(BuilderPipeLine builder) {
		builder.buildEngine();
		builder.buildInterior();
	}

	public static void main(String[] args) {
		TeslaSBuilder tesla = new TeslaSBuilder();
		buildCar(tesla);
	}
}

interface Car {
	public void setEngine(Engine engine);

	public void setInterior(Interior interior);
}

class TeslaS implements Car {
	Engine engine;
	Interior interior;

	@Override
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void setInterior(Interior interior) {
		this.interior = interior;
	}

}

class CyberTruck implements Car {
	Engine engine;
	Interior interior;

	@Override
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void setInterior(Interior interior) {
		this.interior = interior;
	}

}

interface Engine {
	void buildEngine();
}

class TurboCharged implements Engine {

	@Override
	public void buildEngine() {
		System.out.println("This is turbo charged engine");
	}

}

class V8 implements Engine {

	@Override
	public void buildEngine() {
		System.out.println("This is V8 engine");
	}

}

interface Interior {
	public void buildInterior();
}

class Leather implements Interior {

	@Override
	public void buildInterior() {
		System.out.println("This is leather interior");
	}
}

class Plastic implements Interior {
	@Override
	public void buildInterior() {
		System.out.println("This is plastic interior");
	}
}

interface BuilderPipeLine {
	public void buildEngine();

	public void buildInterior();
}

class TeslaSBuilder implements BuilderPipeLine {

	private Car car;

	TeslaSBuilder() {
		this.car = new TeslaS();
	}

	@Override
	public void buildEngine() {
		this.car.setEngine(new V8());
	}

	@Override
	public void buildInterior() {
		this.car.setInterior(new Plastic());
	}
}

class CyberTruckBuilder implements BuilderPipeLine {

	private Car car;

	CyberTruckBuilder() {
		this.car = new CyberTruck();
	}

	@Override
	public void buildEngine() {
		this.car.setEngine(new TurboCharged());
	}

	@Override
	public void buildInterior() {
		this.car.setInterior(new Leather());
	}
}
