package com.example.demo.di.restaurant;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Chef {
	
	String chefName;
	
	public Chef() {
		System.out.println("요리사 객체 생성");
	}
	
	public void callChef() {
		System.out.println("요리사를 호출 합니다");
	}
}
