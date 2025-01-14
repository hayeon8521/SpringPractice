package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.BoardDTO;

public interface BoardMapper {
	
	//삽입 (건수를 받아와야해서)
	int insert(BoardDTO boardDTO);
	
	//업데이트
	int update(BoardDTO boardDTO);
	
	//삭제
	int delete(Long bno);
	
	//단건조회
	BoardDTO read(Long bno);
	
	//전체조회
	List<BoardDTO> getList();

}
