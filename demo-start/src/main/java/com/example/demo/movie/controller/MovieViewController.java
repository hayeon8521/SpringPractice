package com.example.demo.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.controller.BoardController;
import com.example.demo.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/movie/*")
public class MovieViewController {
	
	@GetMapping("/list")
	public void list() {
		
	}

}
