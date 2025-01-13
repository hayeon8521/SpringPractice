package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di.Resutaurant;

@SpringBootTest
public class DiTest2 {
	
	@Autowired Resutaurant resutaurant;
	
	@Test
	public void dites2(){
		resutaurant.getChef().getName();
	}
}
