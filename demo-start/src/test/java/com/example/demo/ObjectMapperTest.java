package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//이건 스프링 부트 테스트 아니고
//JSON 테스트 하는거라서 없어도 됨 @스프링부트테스트
@Slf4j
public class ObjectMapperTest {
	
	@Test
	public void test() throws JsonMappingException, JsonProcessingException  {
		// string ==> vo   @RequestBody
		String str = """
				{
					"name":"홍",
					"age":20
				}
				""";
		str = "{\"name\":\"홍\",\"age\":20}";
		// ★스트링 타입을 JSON 객체로 반환해주는 라이브러리!!!
		ObjectMapper om = new ObjectMapper();
		MemVO vo = om.readValue(str, MemVO.class);
		log.info(vo.toString());
		assertThat(vo.getName()).isEqualTo("홍");
		
		
		// vo => string   @ResponseBody
		String data = om.writeValueAsString(vo);
		log.info(data);
		
		//이렇게 직접 할 필요없고!!!!!!!!!!! 어노테이션만 써주면 알아서 됨
	}

}
