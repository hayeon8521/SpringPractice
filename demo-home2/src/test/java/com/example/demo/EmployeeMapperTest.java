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

	// 실제 맵퍼 호출
	@Autowired EmployeesMapper employeesMapper;
	
	//@Test
	public void list() {
		List<EmployeesDto> list = employeesMapper.findAll(); 
		//System.out.println(list.get(0));
		for(int i=0; i<list.size(); i++) {
			System.out.println( list.get(i).getJobId() );
		}
	}
	
	//@Test
	public void list2() {
		EmployeesDto map = employeesMapper.findById(100L);
		System.out.println(map);
	}
	
	//@Test
	public void find() {
		//given 사용할 데이터
		Long id = 100L;
		
		//when 조건 
		EmployeesDto map = employeesMapper.findById(id);
		
		//then 결과
		// LAST_NAME 칼럼값인데 대문자로 적어줘야한다 그게싫으면 칼럼 as 해서 별칭으로 하면된다
		assertEquals(map.getLastName().toString(), "King");
		System.out.println("aaa"+map);
	}
	
	@Test
	public void findByDeptAndName() {
		//given
		Long id = 50L;
		String name = "";
		
		//when
		List<EmployeesDto> list = employeesMapper.findByDeptAndName(id, name);
		
		//then
		System.out.println(list.toString());
	}
}
