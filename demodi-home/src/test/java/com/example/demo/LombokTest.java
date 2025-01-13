package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.di.sample.SampleDto;

public class LombokTest {
	@Test
	public void test() {
		SampleDto dto = SampleDto.builder()
				.name("aaaa")
				.tel("asdfasd")
				.age(10)
				.build();		
		
		System.out.println(dto);
	}
}