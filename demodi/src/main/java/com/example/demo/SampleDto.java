package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto {
	
	private String name;
	private int age;
	private String tel;
	
	//@Data 에 의해서
	//갯터 셋터 안해도 문제없이됨
	//+이퀄 +투스트링 이렇게 4개
	//메소드 자동생성

}
