package com.behaviour;

public class ChainOfResponsiblity {

	private static BaseHandler getChainOfHandler() {
		BaseHandler baseHandler = new TouchEventHandler();
		baseHandler.setNext(new KeyboardEventHandler());
		return baseHandler;
	}

	public static void main(String[] args) {
		BaseHandler handlers = ChainOfResponsiblity.getChainOfHandler();
		Token Keytoken = new Keyboard();
		Token touchToken = new Touch();
		Token barCodeToken = new BarCodeScanner();

		handlers.handle(Keytoken);
		handlers.handle(touchToken);
		handlers.handle(barCodeToken);
	}
}

interface Token {
	public void consume();
}

class Touch implements Token {
	@Override
	public void consume() {
		System.out.println("This is touch token");
	}
}

class Keyboard implements Token {
	@Override
	public void consume() {
		System.out.println("This is keyboard token");
	}
}

class BarCodeScanner implements Token {
	@Override
	public void consume() {
		System.out.println("This is barcode token");
	}
}

abstract class BaseHandler {
	BaseHandler handler;

	public abstract void setNext(BaseHandler h);

	public abstract void handle(Token t) throws TypeNotPresentException;
}

class TouchEventHandler extends BaseHandler {

	@Override
	public void setNext(BaseHandler h) {
		this.handler = h;
	}

	@Override
	public void handle(Token t) throws TypeNotPresentException {
		if (t instanceof Touch) {
			t.consume();
		} else if (this.handler != null) {
			this.handler.handle(t);
		} else {
			throw new TypeNotPresentException("Can't find this type of token", null);
		}
	}
}

class KeyboardEventHandler extends BaseHandler {

	@Override
	public void setNext(BaseHandler h) {
		this.handler = h;
	}

	@Override
	public void handle(Token t) throws TypeNotPresentException {
		if (t instanceof Keyboard) {
			t.consume();
		} else if (this.handler != null) {
			this.handler.handle(t);
		} else {
			throw new TypeNotPresentException("Can't find this type of token", null);
		}
	}
}