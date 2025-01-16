package com.example.demo.board;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ReplyServiceTest {

	@Autowired
	ReplyService replyService;

	//@Test
	@DisplayName("댓글 수정")
	public void update() {
		// given
		ReplyDTO reply = ReplyDTO.builder()
				   .rno(17L)          // 실행전 존재하는 번호인지 확인할 것
				   .reply("댓글수정")
				   .replyer("김수정")
				   .build();

		// when
		boolean result = replyService.modify(reply);

		// then
		assertThat(result).isEqualTo(true);
	}
	
	
	//@Test
	@DisplayName("댓글 등록")
	public void insert() {
		// given
		ReplyDTO reply = ReplyDTO.builder()
								.bno(22L)
								.reply("왜 롱타입쓰는거야??")
								.replyer("확장성")
								.build();

		// when
		replyService.register(reply);

		// then
		//assertThat(result).isEqualTo(true);
	}
	
	//@Test
	@DisplayName("댓글 삭제")
	public void remove() {
		// given
		Long rno = 31L;

		// when
		boolean result =  replyService.remove(rno);

		// then
		assertThat(result).isEqualTo(true);
	}
	
	//@Test
	@DisplayName("댓글 단건조회")
	public void read() {
		// given
		Long rno = 18L;

		// when
		ReplyDTO re =  replyService.get(rno);

		// then
		log.info(re.toString());
	}
	

}
