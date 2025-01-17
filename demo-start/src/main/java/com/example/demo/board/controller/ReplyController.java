package com.example.demo.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	//★★★
@AllArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
	
	private final ReplyService service;
	
	//등록처리
	//@RequestBody이걸 사용함으로 받아오는값을 객체로 만들어서 dto에 넣는다
	@PostMapping("/new")
	public ReplyDTO register(@RequestBody ReplyDTO dto) {
		service.register(dto);
		return dto;
	}
	
	//수정처리
	@PutMapping("/{rno}")
	public String modify(
			@RequestBody ReplyDTO replyDTO,
			@PathVariable(name="rno") Long rno) {
		replyDTO.setRno(rno);
		service.modify(replyDTO);
		return "success";
	}
	
	//http://localhost:81/replies/1
	//삭제처리 
	@DeleteMapping("/{rno}")
	public String remove(@PathVariable(name="rno") Long rno) {
		service.remove(rno);
		return "success";
	}
	
	//http://localhost:81/replies/32
	//단건조회
	@GetMapping("/{rno}")
	public ReplyDTO get(@PathVariable(name="rno") Long rno) {
		return service.get(rno);
	}
	
	// d
	//http://localhost:81/replies/pages/384/1
	//댓글목록조회
	@GetMapping("/pages/{bno}/{page}")
	//리플 페이지 DTO로 리턴 받는데 (
	public ReplyPageDTO getList(
			//게시글번호랑 뎃글페이지번호 받아옴
			@PathVariable(name="page") int page,
			@PathVariable(name="bno") Long bno ) {
		
		//해당VO에 넣는데 1페이지에 10개씩 출력 으로 한다
		ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 3);
		
		//담아논 객체를 읽어오는 서비스에 던짐 (페이지네이션정보, 게시글번호)
		return service.getList(replySearchDTO, bno);
	}

}
