package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j	// 롬복 로거 있으면 이걸로 로거 찍을 수 있음
@Controller	// 빈등록 + 서블릿 커맨드로 바꿔주는 역활
@RequestMapping("/sample/")	// 이말이 무었이냐? http://localhost:81/sample/ 이렇게 된다는 것이다
public class SampleController {
	
	//Logger log = LoggerFactory.getLogger(SampleController.class);
	
	@GetMapping("a")
	//@RequestMapping(value="a", method = {RequestMethod.GET, RequestMethod.POST} )	//value url // 
	public String main() {
		//System.out.println("sample");
		log.info("sample a");
		return "sample";
	}
	
	@GetMapping("b")
	public String basicb() {
		log.info("sample b");
		return "sample";
	}

}
