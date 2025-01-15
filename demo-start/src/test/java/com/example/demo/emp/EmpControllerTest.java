package com.example.demo.emp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
public class EmpControllerTest {

	@Autowired
	MockMvc mvc;
	
	//@Test
	@DisplayName("조회컨트롤러 테스트")
	void list() throws Exception {
		ModelMap map = mvc.perform( MockMvcRequestBuilders.get("/emp/list")
				.param("page", "10") )
		    	   .andReturn()
		    	   .getModelAndView()
		    	   .getModelMap();

		    	log.debug(map.getAttribute("list").toString());
		    	log.debug(map.getAttribute("paging").toString());

	}
	
}
