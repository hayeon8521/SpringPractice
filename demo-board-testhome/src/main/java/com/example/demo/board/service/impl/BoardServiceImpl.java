package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	//보드 맵퍼 가져오기 (생성자 인젝트)
	private final BoardMapper boardMapper;

	@Override
	public void register(BoardDTO board) {
		boardMapper.insert(board);
	}
	@Override
	public BoardDTO get(Long bno) {
		return boardMapper.read(bno);
	}
	@Override
	public boolean modify(BoardDTO board) {
		return boardMapper.update(board) == 1 ? true : false;
	}
	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) == 1 ? true : false;
	}
	@Override
	public List<BoardDTO> getList(BoardSearchDTO searchDTO) {
		return boardMapper.getList(searchDTO);
	}
	@Override
	public int getCount(BoardSearchDTO searchDTO) {
		return boardMapper.getCount(searchDTO);
	}

}
