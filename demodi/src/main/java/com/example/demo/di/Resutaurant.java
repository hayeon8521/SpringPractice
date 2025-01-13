package com.example.demo.di;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Resutaurant {
	
	//생성자 주입방법 필드 앞에 final 붙이면 생성자가 자동으로
	//만들어짐
	private final Chef chef;

}
