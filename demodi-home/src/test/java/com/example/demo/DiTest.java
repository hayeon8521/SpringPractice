package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di.restaurant.Restaurant;
import com.example.demo.di.tv.TV;

import lombok.Data;

@Data
@SpringBootTest
public class DiTest {
	
	//@Autowired TV tv;
	@Autowired org.springframework.context.ApplicationContext context;
	
	@Test
	@DisplayName("DI TEST")
	public void test() {
		TV tv = context.getBean(TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	
//	private final Restaurant restaurant;
//	Restaurant restaurant;
//	public DiTest(Restaurant restaurant) {
//		//super();
//		this.restaurant = restaurant;
//	}
	
	@Autowired Restaurant restaurant;
	
	@Test
	@DisplayName("레스토랑 생성")
	public void test2() {
		restaurant.chefname();
		restaurant.chefCall();
		//restaurant.getChef().setChefName("haha");
		System.out.println(restaurant.getChef().getChefName());
	}

	
}