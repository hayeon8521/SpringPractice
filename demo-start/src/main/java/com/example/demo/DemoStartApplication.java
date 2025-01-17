package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//맵퍼 스캔해서 레포지토리 빈으로 등록해줌
@MapperScan(basePackages = "com.example.demo.**.mapper")	// {"",""} 로도 됨
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStartApplication.class, args);
	}

}
