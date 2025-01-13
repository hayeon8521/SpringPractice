package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di.TV;

@SpringBootTest
public class DiTest {
	
	@Autowired TV tv;
	//@Autowired org.springframework.context.ApplicationContext context;	//= 스프링 IoC 컨테이너(빈을 담고있는)
	
	@Test
	@DisplayName("DI TEST")
	public void test() {

		//TV tv = new LgTV();   //LgTV로 교체해보세요
		//TV tv = new SamsungTV();   //LgTV로 교체해보세요
		
		//TV tv = context.getBean(TV.class);

		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	//손 안대고 엘지와 삼성으로 바꿔보겠다
	// 그러기 위해서는 인터페이스를 써야한다

}
