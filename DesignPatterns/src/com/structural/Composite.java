package com.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {

	public static void main(String[] args) {
		Image one = new Image();
		one.render();

		Container con = new Container();
		con.addElement(new Image());
		con.addElement(new Image());
		con.addElement(new Image());

		con.render();
	}

}

interface Element {
	public void render();

	public String getName();
}

class Image implements Element {

	@Override
	public void render() {
		System.out.println("Rendering " + getName());
	}

	@Override
	public String getName() {
		return "I am Image";
	}

}

class Container implements Element {
	List<Element> container = new ArrayList<>();

	public void addElement(Element ele) {
		this.container.add(ele);
	}

	@Override
	public void render() {
		for (Element e : container) {
			System.out.println("Rendering " + e.getName());
		}
	}

	@Override
	public String getName() {
		return "I am Container";
	}
}
