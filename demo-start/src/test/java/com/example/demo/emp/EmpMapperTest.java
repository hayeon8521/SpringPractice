package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpDTO;
import com.example.demo.emp.service.EmpSearchDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpMapperTest {
	
	@Autowired EmpMapper empMapper;
	
	@Test
	@DisplayName("전체조회")
	public void testGetList() {
		//given
		EmpSearchDTO search = new EmpSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		
		//when
		List<EmpDTO> list = empMapper.getList(search);
		//then
		list.forEach(emp -> log.info(emp.toString()));
		assertThat(list).isNotNull();
	}

}
