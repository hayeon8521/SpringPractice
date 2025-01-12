package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// @RestController get post 요청 처리
// 결과 json 형태로 반환
@RestController
public class CustController	{
	
	// 해당 인터페이스 객체 사용 할 수 있어짐
	@Autowired	//curd 할 수 있는 레포지토리 객체 자동으로 연결해줌
	public CustomerRepository customerRepository;
	
	@GetMapping("/custmer")	//보여주고자 하는 url 매핑 해서 아래결과를 여기에 리턴해줌
	public List<Customer> list() {	// 겟터 셋터에 의해 값이 돌아오는데 단일값이 아니라서 list에 담아야함
		//LIST 는 객체 저장하는 컬렉션 프레임워크
		return customerRepository.findAll();
	}
}