package com.dependencyInjection;

public class HelloTuneService implements Service{
	
	@Override
	public void service() {
		System.out.println("Activated Hello Tune Service!");
		
	}

}
