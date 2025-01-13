package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.di.SampleDto;

public class LombokTest {
	
	@Test
	public void test() {
		SampleDto dto = SampleDto.builder()
								.name("aaa")
								.tel("010-8888-4444")
								.age(10)
								.build();
		
		System.out.println(dto.toString());
	}

}
