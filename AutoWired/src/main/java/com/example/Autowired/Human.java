package com.example.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {

	private Heart heart;
	
	public Human() {

	}

	
	public Human(Heart heart) {
		super();
		this.heart = heart;
		System.out.println("Human constr is getting called which has Heart as arg");
	}
	@Autowired
	@Qualifier("octopusHeart")
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("Setters method called");
	}

	public void startPumping() {
		if (heart != null) {
			heart.pump();
			System.out.println("name of the animal is : " + heart.getNameOfAnimal()+ "  No of hearts : " + heart.getNoOfHearts());
		} else {
			System.out.println("You are dead!");

		}
	}

}
