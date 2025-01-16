package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;
	
	@Override
	public void register(ReplyDTO reply) {
		replyMapper.insert(reply);
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return replyMapper.update(reply) == 1 ? true : false;
	}

	// d
	@Override
	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public int getCount(ReplySearchDTO searchDTO) {
		return replyMapper.getCount(searchDTO);
	}

	// d
	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
		log.info("★★★bno"+bno);
		//처리된 결과를 객체생성해서 매퍼에 보내고 돌려받음
		return new ReplyPageDTO(
				//게시글에 몇개의 뎃글이 있는지
				replyMapper.getCountByBno(bno),
				//1페이지 10개씩 해당뎃글 가져오기
				replyMapper.getList(replySearch, bno) 
		);
	}

}
