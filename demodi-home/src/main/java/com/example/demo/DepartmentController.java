package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.di.sample.DepartmentsDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dept")
public class DepartmentController {
	
	private DepartmentsDTO dto2;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", dto2);
		List<DepartmentsDTO> list2 = new ArrayList<>();
		list2.add(DepartmentsDTO.builder().departmentId("10").departmentName("기획").build());
		list2.add(DepartmentsDTO.builder().departmentId("20").departmentName("개발").build());
		list2.add(DepartmentsDTO.builder().departmentId("123").departmentName("그래").build());
		model.addAttribute("list2", list2);
		return "dept/list";
	}
	
	@PostMapping("/insert")
	public String insertPrc(DepartmentsDTO dto) {
		dto2 = dto;
		log.debug(dto.toString());
		return "redirect:/dept/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "dept/insert";
	}
}
