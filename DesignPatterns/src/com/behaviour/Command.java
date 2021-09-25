package com.behaviour;

public class Command {
	public static void main(String[] args) {
		HouseAutomation automation = new HouseAutomation();
		Light drawingRoom = new Light();
		automation.setICommand(new LightOnCommand(drawingRoom));
		automation.execute();
		automation.setICommand(new LightOffCommand(drawingRoom));
		automation.execute();
	}
}

class HouseAutomation {
	ICommand command;

	public void setICommand(ICommand command) {
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}
}

interface ICommand {
	public void execute();
}

class Light {
	public void turnOn() {
		System.out.println("Turned On");
	}

	public void turnOff() {
		System.out.println("Turned Off");
	}
}

class LightOnCommand implements ICommand {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOn();
	}
}

class LightOffCommand implements ICommand {
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOff();
	}
}