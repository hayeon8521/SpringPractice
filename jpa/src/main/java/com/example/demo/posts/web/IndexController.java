package com.example.demo.posts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.service.PostsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
	
	final PostsService service;
	
	//목록조회
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", service.findAll() );		
		return "index";
	}
	
	//글등록
	@GetMapping("/save")
	public String save() {
		return "posts-insert";
	}
	
	//단건조회
	@GetMapping("/update/{id}")
	public String update(@PathVariable(name="id") Long id
						,Model model) {
		log.info("★★★"+id);
		model.addAttribute("post", service.findById(id) );
		return "posts-update";
	}
	
	

}
