package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping("/hello")
	@ResponseBody	// 그냥 문자 넘긴다 라는거고 ★이거 없으면 hello.thml 찾아감
	public String main() {
		return "hello머지오류";
	}
}
