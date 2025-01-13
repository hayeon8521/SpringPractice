package com.example.demo.di.restaurant;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Restaurant {

	private final Chef chef;
	
	public void chefname() {
		chef.setChefName("hayeon");
		System.out.println("셰프 이름: " + chef.getChefName());
	}
	
	public void chefCall() {
		chef.callChef();
	}
}
