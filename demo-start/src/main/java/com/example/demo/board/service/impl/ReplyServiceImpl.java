package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;
	
	private final BoardMapper boardMapper;
	
	@Override
	@Transactional
	public void register(ReplyDTO reply) {
		// bno, amount
		log.info("★★★★★"+reply.toString());
		boardMapper.updateReplyCnt(reply.getBno(), 1);
		
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
	@Transactional
	public boolean remove(Long rno) {
		//단건조회로 bno 랑 가져와서
		ReplyDTO obj = replyMapper.read(rno);
		
		// bno, amount
		boardMapper.updateReplyCnt(obj.getBno(), -1);
		
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public int getCount(ReplySearchDTO searchDTO) {
		return replyMapper.getCount(searchDTO);
	}

	// d
	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
		
		Paging paging = new Paging();
		int cnt = replyMapper.getCountByBno(bno);
		
		//paging - 전체 건수, pageunit, page
		paging.setPage(replySearch.getPage());
		paging.setPageUnit(replySearch.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
				cnt,
				paging,
				replyMapper.getList(replySearch, bno) 
		);
	}

}
