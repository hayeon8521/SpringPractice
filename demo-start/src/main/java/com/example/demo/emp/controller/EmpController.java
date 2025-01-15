package com.example.demo.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpDTO;
import com.example.demo.emp.service.EmpSearchDTO;
import com.example.demo.emp.service.EmpService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/emp/*")
public class EmpController {
	
	private EmpService empService;
	
	//전체목록
	@GetMapping("/list")
	public void list(Model model, 
			         EmpSearchDTO searchDTO,
			         Paging paging) {
		log.info("list");
		
		//페이징 토탈 카운터 불러오는것
		paging.setTotalRecord(empService.getCount(searchDTO));
		
		//페이징 구하는거
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		//모델에 searchDTO랑 paging 은 자동으로 들어감
		model.addAttribute("list", empService.getList(searchDTO));
	}
	
	//수정 화면 // 또는 단건조회
	@GetMapping({"/modify", "/get"})
	//@GetMapping("/get")
	public void modify(@RequestParam(name="employeeId") Long employeeId, Model model) {
		EmpDTO emp = empService.get(employeeId);
		model.addAttribute("emp", emp);
	}
	
	//수정처리
	@PostMapping("/modify")
	public String modifyPrc(EmpDTO emp, RedirectAttributes rttr) {
		empService.modify(emp);
		rttr.addFlashAttribute("result2", true);	//휘발성
		return "redirect:/emp/list";
	}
	
	
	//등록
	//유효성 검사를 위해 BoardDTO board 이걸 넣음
	@GetMapping("/register")
	public void register(EmpDTO emp) {
	}
	
	//등록
	@PostMapping("/register")
	//유효성 검사 체크까지
	public String registerPrc(@Validated EmpDTO emp,
			                  BindingResult bindingResult,
			                  RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) {
			return "emp/register";
		}
		log.info("register");
		empService.register(emp);
		
		rttr.addFlashAttribute("result", true);	//휘발성
		return "redirect:/emp/list";
	}
	
	//삭제
	@GetMapping("/remove")
	public String remove(@RequestParam(name="employeeId") Long employeeId, RedirectAttributes rttr) {
		Boolean result =  empService.remove(employeeId);
		rttr.addFlashAttribute("result3", result);
		return "redirect:/emp/list";
	}

}
