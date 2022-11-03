package com.example.demo;

public class Vodaphone implements Sim{

	@Override
	public void calling() {
		System.out.println("Calling on Vodaphone Sim");
		
	}

	@Override
	public void data() {
		System.out.println("Browsing internet on Vodaphone Sim");
		
	}

}
