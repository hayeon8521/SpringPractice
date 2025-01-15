package com.example.demo.board.service;

import java.util.List;

//컨트롤에서 서비스 호출하는곳
public interface BoardService {

	//등록
	public void register(BoardDTO board);
	//단건 조회
	public BoardDTO get(Long bno);
	//수정
	public boolean modify(BoardDTO board);
	//삭제
	public boolean remove(Long bno);
	//여러건 조회
	public List<BoardDTO> getList(BoardSearchDTO searchDTO);
	//카운터
	public int getCount(BoardSearchDTO searchDTO);
}