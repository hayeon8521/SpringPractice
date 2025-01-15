package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


//@RestController 이걸로하면 전부다 데이터값임!!!!! 아작스 처리하려면 이걸로해야함
@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/dept/*")
public class DeptController {
	
	//★아작스 응답★을 위한 컨트롤러!!!
	
	private final DeptService deptService;
	
	// ※맵퍼,서비스에 처리한 반환되는 값을 리턴받을수있게 해야한다!!!
	
	//전체 조회
	@GetMapping("/list")
	public List<DeptDTO> list() {
		return deptService.getList(null);
	}
	
	//http://localhost:81/dept/get?deptId=100
	//단건 조회
	@GetMapping("/get")
	public DeptDTO get(@RequestParam(name="deptId") Long deptId) {
		return deptService.get(deptId);
	}
	
	

}
