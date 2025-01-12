package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.EmployeesDto;
import com.example.demo.mapper.EmployeesMapper;

//@RestController
@Controller
public class EmployeeController {

	//맵퍼 연결
	@Autowired
	EmployeesMapper employeesMapper;
	
	//콘솔이나 값을 넘길때
//	@GetMapping("/emp")
//	public List<EmployeesDto> list() {
//		return employeesMapper.findAll();
//	}
	
	//화면에 값을 뿌려 줄때 (해당 URL 호출하면 해당 리스트를 템플릿에서 찾아서 보여줌
	@GetMapping("/emp")
	public String list(Model model) {
		model.addAttribute("empList", employeesMapper.findAll());	// 해당 결과값을 empList 에 담는다
		return "empList"; 
	}
	
	@GetMapping("/empinfo")
	public EmployeesDto map() {
		return employeesMapper.findById(100L);
	}
	
	@GetMapping("/empinfofull")
	public List<EmployeesDto> list2() {
		Long id = 50L;
		String name = "";
		
		return employeesMapper.findByDeptAndName(id, name);
	}
	
	@ResponseBody
	@GetMapping("/")
	public String hellow() {
		return "hello ~~";
	}
}
