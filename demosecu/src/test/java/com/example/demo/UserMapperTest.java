package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.securing.mapper.UserMapper;
import com.example.demo.securing.service.UserDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UserMapperTest {
	
	@Autowired UserMapper mapper;
	
	@Test
	public void test() {
		String userId = "user";
		UserDTO user = mapper.getUser(userId);
		
		//List<RoleDTO> list = mapper.getRole(user.getId());
		
		log.info("★★★★"+user.toString());
		//log.info(list.toString());
	}
	

}
