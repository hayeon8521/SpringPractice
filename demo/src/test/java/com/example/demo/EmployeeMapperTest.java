package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.EmployeesDto;
import com.example.demo.mapper.EmployeesMapper;

@SpringBootTest
public class EmployeeMapperTest {

	@Autowired EmployeesMapper employeesMapper;
	
	@Test
	public void list() {
		List<EmployeesDto> list = employeesMapper.findAll();
		System.out.println(list.get(0));
	}
	
	
	@Test
	public void find() {
		//given 사용할데이터
		Long id = 100L;
		
		//when
		EmployeesDto map = employeesMapper.findById(id);
		
		//then
		assertEquals(map.getLastName().toString(), "King");
		System.out.println(map);
	}
	
	@Test
	public void findBydeptAndName() {
		//given
		Long id = 50L;
		//String name = "Kevin";	// 결과가 나옴
		String name = "";	// null이 아니기에 값이 통과해서 and first_name = '' 으로 찾음
				
		//when
		List<EmployeesDto> list = employeesMapper.findBydeptAndName(id, name);
		System.out.println(list.toString());
				
		//then
	}

}
