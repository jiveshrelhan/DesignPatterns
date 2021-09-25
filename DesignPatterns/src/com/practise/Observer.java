package com.practise;

import java.util.ArrayList;
import java.util.List;

public class Observer {
	public static void main(String[] args) {
		NewAgency agency = new NewAgency();
		agency.addChannel(new AajTak("cricket"));
		agency.addChannel(new ZeeTV("bulletin"));
		
		agency.updateNews("show neeraj");
	}
}


class NewAgency {
	private String news;
	private List<NewsChannel> channels = new ArrayList<>();
	
	public void addChannel(NewsChannel channel) {
		this.channels.add(channel);
	}
	
	public void removeChannel(NewsChannel channel) {
		this.channels.remove(channel);
	}
	
	public void updateNews(String news) {
		this.news = news;
		for(NewsChannel channel :channels ) {
			channel.update(this.news);
		}
	}
}

interface NewsChannel{
	public void update(String news);
}

class AajTak implements NewsChannel{

	String news;
	
	AajTak(String initialNews) {
		this.news = initialNews;
	}
	
	@Override
	public void update(String news) {
		System.out.println("Got update");
		this.news = news;
	}
}

class ZeeTV implements NewsChannel{

	String news;
	
	ZeeTV(String initialNews) {
		this.news = initialNews;
	}
	
	@Override
	public void update(String news) {
		System.out.println("Got update");
		this.news = news;
	}
}