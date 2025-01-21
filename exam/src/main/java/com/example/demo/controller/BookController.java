package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/book/*")
public class BookController {
	
	private BookService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList() );
	}
	
	@GetMapping("/register")
	public void register(BookDTO book) {
	}
	
	//등록
	@PostMapping("/register")
	//유효성 검사 체크까지
	public String registerPrc(@Validated BookDTO book,
			                  BindingResult bindingResult,
			                  RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) {
			//유효성 검사에 충족 못했으면 페이지 다시 돌려보내라
			log.info("★★★★register"+book.toString() );
			return "book/register";
		}
		log.info("★★★★register"+book.toString() );
		service.insert(book);
		
		rttr.addFlashAttribute("result", true);	//휘발성
		return "redirect:/book/list";
	}
		
	@GetMapping("/listde")
	public void listde(Model model) {
		model.addAttribute("list", service.getListde() );
	}
		
	
	@GetMapping("/")
	public String home() {
		return "/book/home";
	}
	
	@GetMapping("/home")
	public void home2() {
	}

}
