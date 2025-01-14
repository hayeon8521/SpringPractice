package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	private BoardService boardService;
	//@Autowired BoardService boardService;

	//전체목록
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", boardService.getList());
	}
	
	//등록
	@GetMapping("/register")
	public void register() {
	}
	
	//등록
	@PostMapping("/register")
	public String registerPrc(BoardDTO board, RedirectAttributes rttr) {
		log.info("register");
		boardService.register(board);
		
		//rttr.addAttribute("result", true);	//파라메터형식
		rttr.addFlashAttribute("result", true);	//휘발성
		return "redirect:/board/list";
		// redirect 해줘야 데이터를 가지고 이동함!!!
		// 리다이렉트는 모델을 사용 못함 RedirectAttributes
	}
	
	//수정 화면 // 또는 단건조회
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam(name="bno") Long bno, Model model) {
		BoardDTO board = boardService.get(bno);
		model.addAttribute("board", board);
	}
	
	//수정처리
	@PostMapping("/modify")
	public String modifyPrc(BoardDTO board, RedirectAttributes rttr) {
		boardService.modify(board);
		rttr.addFlashAttribute("result2", true);	//휘발성
		return "redirect:/board/list";
	}
	
	//삭제
	@GetMapping("/remove")
	public String remove(@RequestParam(name="bno") Long bno, RedirectAttributes rttr) {
		Boolean result =  boardService.remove(bno);
		rttr.addFlashAttribute("result3", result);
		return "redirect:/board/list";
	}
	
}
