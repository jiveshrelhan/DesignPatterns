package com.practise;

public class CommandPattern {
	
	
	public static void main(String[] args) {
		Executer executer = new Executer();
		executer.executeCommand(new OpenCommand());
		executer.executeCommand(new CloseCommand());
	}
}

interface Command {
	public void execute();
}

class OpenCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Openning File");
	}

}

class CloseCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Openning File");
	}

}

class Executer {
	public void executeCommand(Command command) {
		command.execute();
	}
}
