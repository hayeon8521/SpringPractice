package com.example.demo.board.service;

public interface ReplyService {

		//등록 d
		public void register(ReplyDTO reply);
		
		//단건 조회
		public ReplyDTO get(Long rno);
		
		//수정 d
		public boolean modify(ReplyDTO reply);
		
		//삭제 d
		public boolean remove(Long rno);
		
		//여러건 조회 d
		public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno);
		
		//해당게시글의 총갯수 가져오는 서비스는 왜 등록안하냐 생각했는데
		//그냥 위에있는 여러건 조회할때 서비스 impl 단에서 맵퍼호출해서 객체 만들어버림...
		//합리적이긴한데... 아 ....
		
		
		//카운터 (이건 게시판 읽는거고 안씀 필요없음 복붇의 잔해)
		public int getCount(ReplySearchDTO searchDTO);
}