package com.behaviour;

public class Iterator {
	public static void main(String[] args) {
		Employee[] emps = new Employee[3];
		emps[0] = new Employee("J", "A", 1);
		emps[1] = new Employee("Q", "B", 2);
		emps[2] = new Employee("R", "C", 3);

		EmployeeIterator iterator = new EmployeeIterator(emps);

		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			System.out.println(emp.name);
		}
	}
}

interface IIterator<E> {
	public boolean hasNext();

	public E next();

	public void reset();
}

class Employee {
	String name;
	String address;
	int id;

	public Employee(String name, String address, int id) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
}

class EmployeeIterator implements IIterator<Employee> {

	Employee[] employees;

	private int currentPos = 0;

	public EmployeeIterator(Employee[] employees) {
		this.employees = employees;
		this.currentPos = 0;
	}

	@Override
	public boolean hasNext() {
		return currentPos < employees.length;
	}

	@Override
	public Employee next() {
		currentPos++;
		return this.employees[currentPos - 1];
	}

	@Override
	public void reset() {
		this.currentPos = 0;
	}

}
