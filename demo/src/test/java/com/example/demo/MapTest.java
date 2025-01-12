package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MapTest {

	@Test
	public void test() {
		// List (ArrayList, LinkedList) : 순차구조
		// Set : 중복값 허용 X
		// Map<key, Value> : 반드시 키값으로만 접근 할 수 있음 : 검색을 빠르게 : VO 대신에 사용
		
		Map<String, Object> emp = new HashMap<>();
		emp.put("firstName", "scott");
		emp.put("lastName", "king");
		
		System.out.println(emp.get("firstName"));
		
	}
}
