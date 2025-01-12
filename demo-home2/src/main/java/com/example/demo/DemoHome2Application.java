package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 해당페키지에 있는 매퍼인터페이스를 자동으로 검색하고 스프링 컨텍스트에 등록
@MapperScan(basePackages = "com.example.demo.mapper")	// {"",""} 로도 됨
public class DemoHome2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoHome2Application.class, args);
	}

}
