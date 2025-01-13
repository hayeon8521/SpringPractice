package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j	// 롬복 로거 있으면 이걸로 로거 찍을 수 있음
@Controller	// 빈등록 + 서블릿 커맨드로 바꿔주는 역활
@RequestMapping("/sample")	// 이말이 무었이냐? http://localhost:81/sample/ 이렇게 된다는 것이다
public class SampleController {
	
	
	// @ModelAttribute 이값도 같이 넘어감
	// 값을 계속 넘겨 줘야하면 이렇게 하면 됨
	@ModelAttribute("dept")	// 의 또다른 용도
	public List<String> deptList(){
		return Arrays.asList("기획","개발","인사");
	}
	
	//샘플 페이지로 값을 넘겨주고 싶을때 사용하는게 model 임
	//커멘트 객체는 그냥 자동으로 전달 됨 어트리뷰트 안해도 됨 대신 html에 넘거갈때 첫글짜 소문자로 넘어가서 사용됨
	//커멘드 객체의 이름을 바꿔서 넘겨주고 싶으면 모델 어트리뷰트 ㅎ주면됨
	//데이터 타임 포멧하면 이제 원하는 형식으로 받을수있음!!!
	//http://localhost:81/sample/ex03?title=hello&dueDate=2025-01-13
	//(type=Bad Request, status=400).
	// http://localhost:81/sample/ex03?title=hello&dueDate=2025/01/13
	// 유틸리티는데이트는 슬러시 // sql데이터는 빼기
	// TodoDTO(title=hello, dueDate=Mon Jan 13 00:00:00 KST 2025)
	// http://localhost:81/sample/ex03?title=hello&dueDate=2025/01/13%2016:40
	// TodoDTO(title=hello, dueDate=Mon Jan 13 16:40:00 KST 2025)
	//날짜 포멧 처리
	@GetMapping("/ex03")
	public ModelAndView ex03(@ModelAttribute(name="todo") TodoDTO dto) {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("serverTime", new Date());
		log.debug("TodoDTO : " + dto);
		return mv;	//포워드 : request 전달
	}
	
	
	//http://localhost:81/sample/ex02Bean
	//?list[0].name=kim&list[0].age=10&list[1].name=yeon&list[1].age=20
	// vo 이용해서 값을 받는거
	//SampleDtoList(list=[SampleDto(name=kim, age=10, tel=null), SampleDto(name=park, age=20, tel=null)])
	// 갯으로 하면 [] 를 인코딩 행해서 포스트로 바꿨음
	// http://localhost:81/sample/ex02Bean?list%5B0%5D.name=kim&list%5B0%5D.age=10&list%5B1%5D.name=yeon&list%5B1%5D.age=20
	// SampleDtoList(list=[SampleDto(name=kim, age=10, tel=null), SampleDto(name=yeon, age=20, tel=null)])
	@PostMapping("/ex02Bean")
	public String ex02Bean(SampleDtoList dtoList) {
		log.debug("dtoList : " + dtoList);
		return "sample";
	}
	
	
	//http://localhost:81/sample/ex02List?hobby=read&hobby=game
	// hobby : [read, game]
	// 배열 파라메터를 받는 방법
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam(name="hobby") List<String> hobby) {
		//여러개인경우 리스트 맵 vo 배열 원하는걸로 받을수있음 그냥 이번에 리스트로 받은거뿐임 
		log.debug("hobby : " + hobby);
		return "sample";
	}
	
	
	// 이렇게 값을 하나씩 받을 수 도 있음
	// http://localhost:81/sample/ex02?name=kim&age=10
	// [14:52:00] INFO  com.example.demo.SampleController - [20] name : kim
	// [14:52:00] INFO  com.example.demo.SampleController - [21] age : 10
	// 파라메터 다 안넘어가면 에러남 [ Whitelabel Error Page ]
	// required 값 필수 여부 // defaultValue 초기값 
	@GetMapping("/ex02")
	public String ex02(@RequestParam(name="username") String name,
						@RequestParam(name="age", required = false, defaultValue = "5") int age) {
		//String name = Request.getParam("username");	//이게 이거임 @RequestParam(name="username") String name
		log.info("name : "+ name);
		log.info("age : "+ age);
		return "sample";
	}
	
	
	// 이렇게 전체를 다 받을수도있고 // 이건 특정값 안넘어 와도 초기값으로 셋팅해줌
	// http://localhost:81/sample/ex01?name=kim&age=10
	// [14:43:37] DEBUG com.example.demo.SampleController - [18] SampleDto(name=kim, age=10, tel=null)
	@GetMapping("/ex01")
	public String ex01 (SampleDto dto) {
		log.debug(dto.toString());
		log.debug(dto.getName().toString());
		return "sample";
	}
	
	
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
