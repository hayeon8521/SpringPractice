package com.example.demo.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer  {
	
	//화면 읽기전에 미리 해당 위치를 갈수있는 컨트롤러가 만들어 진다
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("/board/list");
		//registry.addViewController("/hello").setViewName("hello");
		//registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
	}

}
