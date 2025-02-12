package com.example.demo.board.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.GridData;
import com.example.demo.common.Paging;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")	//아무나 다들어와서 api 허용해주는거
@RequestMapping("/api/board/*")
@AllArgsConstructor
public class RestBoardController {

	private BoardService service;

	@GetMapping("/list")
	public Map<String, Object> list(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
			BoardSearchDTO searchDTO, Paging paging) throws JsonMappingException, JsonProcessingException {

		paging.setPageUnit(perPage);

		// 페이징 조건
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());

		// 페이징처리
		paging.setTotalRecord(service.getCount(searchDTO));

		String str = """
								{
				  "result": true,
				  "data": {
				    "contents": [],
				    "pagination": {
				      "page": 1,
				      "totalCount": 100
				    }
				  }
				}
								""";
		ObjectMapper objectMapper = new ObjectMapper();
		//위에 내용을 맵으로 바꾸는거
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		//맵으로 바꾼거에서 data 읽어내고
		Map<String, Object> data = (Map) map.get("data");
		//페이지 네이션 읽어내고
		Map<String, Object> pagination = (Map) data.get("pagination");

		//거기에 전체 페이지랑 페이지번호 읽어옴
		// 페이징처리
		pagination.put("page", paging.getPage());
		pagination.put("totalCount", service.getCount(searchDTO));

		data.put("contents", service.getList(searchDTO));
		return map;
	}

	// 등록,수정,삭제
	@PutMapping("/modifyData")
	public Map modifyData(@RequestBody GridData<BoardDTO> board) {
		log.info("modify: " + board);
		//service.modify(board);	//서비스 안에서 리스트를 포문 돌려야함
		return Collections.singletonMap("result", true);
	}
	
	//등록 처리
	@PostMapping("/register")
	public Map register(@RequestBody GridData<BoardDTO> board) {
		log.info("register: " + board);
		//service.register(board);
		return Collections.singletonMap("result", true);
	}

	//수정 처리
	@PutMapping("/update")
	public Map modify(@RequestBody GridData<BoardDTO> board) {
		log.info("modify: " + board);
		//service.modify(board);
		return Collections.singletonMap("result", true);
	}

	//삭제 처리
	@DeleteMapping("/remove")
	public Map remove(@RequestBody GridData<BoardDTO> board) {
		//log.info("remove: " + bno);
		//service.remove(bno);
		return Collections.singletonMap("result", true);
	}
}
