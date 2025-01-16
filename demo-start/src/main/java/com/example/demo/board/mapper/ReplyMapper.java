package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplySearchDTO;

public interface ReplyMapper {
	
	//삽입 (건수를 받아와야해서)
	public int insert(ReplyDTO replyDTO);
	
	//업데이트 (수정)
	public int update(ReplyDTO replyDTO);
	
	//삭제 d
	public int delete(Long rno);
	
	//단건조회
	public ReplyDTO read(Long rno);
	
	//전체조회 d
	public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri,
							@Param("bno") Long bno);
	// d
	public int getCountByBno(Long bno);
	
	
	
	//카운터
	public int getCount(ReplySearchDTO searchDTO);

}
