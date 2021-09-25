package com.structural;

public class AdpaterClient {

	public static void main(String[] args) {
		Connection.makeConnection(new UkPlug());
		Connection.makeConnection(new Adapter(new UsPlug()));
	}

}

class Connection {

	static MacBook laptop = new MacBook();

	public static void makeConnection(UkPlug plug) {
		laptop.charge(plug);
	}

}

class MacBook {

	public void charge(UkPlug plug) {
		System.out.println("Macbook charging from " + plug.threePinSocket());
	}
}

class UsPlug {
	public String twoPinSocket() {
		return "This is two pin socket";
	}
}

class UkPlug {
	public String threePinSocket() {
		return "This is three Pin Socket";
	}
}

class Adapter extends UkPlug {
	UsPlug plug;

	Adapter(UsPlug plug) {
		this.plug = plug;
	}

	@Override
	public String threePinSocket() {
		return "One Socket will be unused" + plug.twoPinSocket();
	}
}