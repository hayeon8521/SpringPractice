package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.mapper.DepartmentsMapper;

@Controller
public class DpartmentController {
	
	@Autowired DepartmentsMapper departmentsMapper;
	
	@GetMapping("/dept")
	public String list(Model model) {
		model.addAttribute("deptList", departmentsMapper.findAll());
		return "deptList";
	}
	

}
