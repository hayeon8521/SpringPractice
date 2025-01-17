package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

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
	List<BoardDTO> getList(BoardSearchDTO searchDTO);
	
	//카운터
	int getCount(BoardSearchDTO searchDTO);
	
	//게시글 수정할때 게시글수 같이 업데이트
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	

}
