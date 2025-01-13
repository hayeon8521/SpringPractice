package com.example.demo;

import org.junit.jupiter.api.Test;

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
