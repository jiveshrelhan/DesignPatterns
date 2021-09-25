package com.behaviour;

import java.util.HashSet;
import java.util.Set;

public class Mediator {
	public static void main(String[] args) {
		IChatRoom mediator = new ChatRoomMediator();

		User a = new User(mediator, "Jivesh");
		User b = new User(mediator, "Relhan");
	
		mediator.addUser(a);
		mediator.addUser(b);
		
		a.sendMessage("Hello", b);
		b.sendMessage("Hello Fool", a);
	
	}
}

interface IChatRoom {
	public void addUser(User user);

	public void sendMessage(String message, User toUser);
}

class User {
	IChatRoom mediator;
	String name;

	User(IChatRoom mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public void sendMessage(String message, User toUser) {
		System.out.println("Sending ... " + message);
		this.mediator.sendMessage(message, toUser);
	}

	public void receiveMessage(String message) {
		System.out.println("Received ... " + message);
	}
}

class ChatRoomMediator implements IChatRoom {
	Set<User> chatUser = new HashSet<>();

	@Override
	public void addUser(User user) {
		this.chatUser.add(user);
	}

	@Override
	public void sendMessage(String message, User toUser) {
		if (chatUser.contains(toUser)) {
			toUser.receiveMessage(message);
		}
	}
}