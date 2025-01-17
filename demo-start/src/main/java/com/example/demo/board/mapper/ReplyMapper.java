package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplySearchDTO;

public interface ReplyMapper {
	
	//삽입 (건수를 받아와야해서) d
	public int insert(ReplyDTO replyDTO);
	
	//업데이트 (수정) d
	public int update(ReplyDTO replyDTO);
	
	//삭제 d
	public int delete(Long rno);
	
	//단건조회
	public ReplyDTO read(Long rno);
	
	//전체조회 d
	public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri,
							@Param("bno") Long bno);
	
	//페이지 카운터( 헤당 게시글에 댓글이 몇개 있는지 ) d
	public int getCountByBno(Long bno);
	
	
	// 게시글 삭제되면 해당 리플 다삭제
	public int deleteByBno(Long bno);
	
	//카운터
	public int getCount(ReplySearchDTO searchDTO);

}
