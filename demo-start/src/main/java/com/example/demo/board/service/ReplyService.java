package com.example.demo.board.service;

public interface ReplyService {

	//등록
		public void register(ReplyDTO reply);
		//단건 조회
		public ReplyDTO get(Long rno);
		//수정
		public boolean modify(ReplyDTO reply);
		
		
		//삭제 d
		public boolean remove(Long rno);
		
		//여러건 조회 d
		public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno);
		
		
		//카운터
		public int getCount(ReplySearchDTO searchDTO);
}