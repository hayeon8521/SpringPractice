package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j	// 롬복 로거 있으면 이걸로 로거 찍을 수 있음
@Controller	// 빈등록 + 서블릿 커맨드로 바꿔주는 역활
@RequestMapping("/dept")	// 이말이 무었이냐? http://localhost:81/dept/ 이렇게 된다는 것이다
public class DeptController {
	
	//DepartmentsDTO(departmentId=asdfasd, departmentName=fasdf, managerId=dasf, locationId=dasfdasf)
	@PostMapping("/insert")
	public String insertProc(DepartmentsDTO dto) {
		log.debug(dto.toString());
		return "redirect:/dept/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "dept/insert";
	}
	
	@GetMapping("/update")
	public String update(Model model) {
		DepartmentsDTO dto2 = new DepartmentsDTO(null, null, null, null);
		dto2.setDepartmentId("50");
		dto2.setDepartmentName("우리부서");
		dto2.setManagerId("15");
		dto2.setLocationId("50");
		model.addAttribute("insertData", dto2);
		return "dept/update";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<DepartmentsDTO> list = new ArrayList<>();
		list.add(DepartmentsDTO.builder().departmentId("10").departmentName("기획").build());
		list.add(DepartmentsDTO.builder().departmentId("20").departmentName("개발").build());
		model.addAttribute("list", list);
		return "dept/list";
	}
	
	@GetMapping("/")
	public String hello() {
		return "dept/info";
	}

}
